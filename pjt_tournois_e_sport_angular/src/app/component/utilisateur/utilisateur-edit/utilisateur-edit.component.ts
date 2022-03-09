import { Utilisateur } from 'src/app/model/utilisateur';
import { UtilisateurService } from './../../../service/utilisateur.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Role } from 'src/app/model/role';
import {
  FormGroup,
  FormControl,
  Validators,
  AbstractControl,
  AsyncValidatorFn,
  ValidationErrors,
  FormArray,
} from '@angular/forms';
import { Observable, debounceTime, map } from 'rxjs';

@Component({
  selector: 'app-utilisateur-edit',
  templateUrl: './utilisateur-edit.component.html',
  styleUrls: ['./utilisateur-edit.component.css'],
})
export class UtilisateurEditComponent implements OnInit {
  form!: FormGroup;
  utilisateur: Utilisateur = new Utilisateur();

  roles: any;

  constructor(
    private activatedRoute: ActivatedRoute,
    private utilisateurService: UtilisateurService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.form = new FormGroup({
      mail: new FormControl(
        '',
        [Validators.required, Validators.email],
        this.checkMail()
      ),
      login: new FormControl(
        '',
        [
          Validators.required,
          Validators.minLength(3),
          Validators.maxLength(255),
        ],
        this.checkLogin()
      ),
      passwordGrp: new FormGroup(
        {
          password: new FormControl('', [
            Validators.required,
            Validators.pattern(
              /^(?=.*[a-z])(?=.*[A-Z])(?=.*[$@#_-])(?=.*[0-9])([a-zA-Z0-9$@#_-]{4,25})$/
            ),
            Validators.maxLength(150),
          ]),
          confirm: new FormControl(''),
        },
        this.checkNotEquals
      ),
    });
  }

  checkMail(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.utilisateurService.checkMail(control.value).pipe(
        debounceTime(1000),
        map((res: boolean) => {
          return res ? { mailAlreadyUsed: true } : null;
        })
      );
    };
  }

  checkLogin(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.utilisateurService.checkUsername(control.value).pipe(
        debounceTime(1000),
        map((res: boolean) => {
          return res ? { loginAlreadyUsed: true } : null;
        })
      );
    };
  }

  checkNotEquals(group: AbstractControl): ValidationErrors | null {
    let formGroup = group as FormGroup;
    if (formGroup.controls['password'].errors) {
      return null;
    }
    return formGroup.controls['password'].value ==
      formGroup.controls['confirm'].value
      ? null
      : { checkNotEquals: true };
  }

  save() {
    this.utilisateur.username = this.form.get('login')!.value as string;
    this.utilisateur.mail = this.form.get('mail')!.value as string;
    this.utilisateur.password = this.form.get('passwordGrp')!.get('password')
      ?.value as string;
    this.utilisateur.roles = [
      Role.ROLE_JOUEUR,
      Role.ROLE_ADMIN,
      Role.ROLE_ORGANISATEUR,
    ];
    console.log(this.utilisateur);
    this.utilisateurService.create(this.utilisateur).subscribe((ok) => {
      this.router.navigateByUrl('/acceuil');
    });
  }

  get errorPassword(): string {
    let control = this.form.get('passwordGrp')?.get('password');
    if (control!.invalid) {
      if (control!.hasError('required')) return 'mot de passe obligatoire';
      else if (control!.hasError('minlength'))
        return 'le mot de passe doit faire 4 caracteres minimum';
      else if (control!.hasError('maxlength'))
        return 'le mot de passe ne doit pas faire plus de 25 caracteres';
      else if (control!.hasError('pattern'))
        return ' le mot de passe doit contenir 1 minuscule, 1 majuscule, 1 chiffre et un caractere #@$_-';
    }
    return '';
  }
}
