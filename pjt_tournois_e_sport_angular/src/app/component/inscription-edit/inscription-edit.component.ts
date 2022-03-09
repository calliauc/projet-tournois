import { TournoiService } from './../../service/tournoi.service';
import { UtilisateurService } from './../../service/utilisateur.service';
import { Observable, map, debounceTime } from 'rxjs';
import {
  FormGroup,
  FormControl,
  Validators,
  AsyncValidatorFn,
  AbstractControl,
  ValidationErrors,
} from '@angular/forms';
import { InscriptionService } from './../../service/inscription.service';
import { Inscription } from './../../model/inscription';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';

@Component({
  selector: 'app-inscription-edit',
  templateUrl: './inscription-edit.component.html',
  styleUrls: ['./inscription-edit.component.css'],
})
export class InscriptionEditComponent implements OnInit {
  inscription: Inscription = new Inscription();
  creation: boolean = true;
  myForm!: FormGroup;
  inscriptionObservable!: Observable<Inscription>;

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private inscriptionService: InscriptionService,
    private utilisateurService: UtilisateurService,
    private tournoiService: TournoiService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['idJoueur'] && params['idTournoi']) {
        this.creation = false;
        this.inscriptionService
          .get(params['idJoueur'], params['idTournoi'])
          .subscribe((result) => {
            this.inscription = result;
            this.initForm();
          });
      }
    });

    this.initForm();

    this.inscriptionObservable = this.myForm.valueChanges.pipe(
      map((formValue) => this.inscription)
    );
  }

  initForm(): void {
    this.myForm = new FormGroup({
      keyJoueur: new FormControl(
        this.inscription.idJoueur,
        [Validators.required],
        this.checkJoueurEnBase()
      ),
      keyTournoi: new FormControl(
        this.inscription.idTournoi,
        [Validators.required],
        this.checkTournoiEnBase()
      ),
      position: new FormControl(this.inscription.position),
      score: new FormControl(this.inscription.score, [Validators.min(0)]),
    });
  }

  save() {
    this.inscription.idJoueur = this.myForm.controls['keyJoueur'].value;
    this.inscription.idTournoi = this.myForm.controls['keyTournoi'].value;
    if (!this.creation) {
      this.inscription.position = this.myForm.controls['position'].value;
      this.inscription.score = this.myForm.controls['score'].value;
      this.inscriptionService.update(this.inscription).subscribe((ok) => {
        this.router.navigate(['/inscription']);
      });
    } else {
      this.inscriptionService.create(this.inscription).subscribe((ok) => {
        this.router.navigate(['/inscription']);
      });
    }
    this.creation = true;
  }

  checkJoueurEnBase(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.utilisateurService.checkId(control.value).pipe(
        debounceTime(1000),
        map((res: boolean) => {
          return res ? { joueurAbsentBase: true } : null;
        })
      );
    };
  }

  checkTournoiEnBase(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.tournoiService.checkId(control.value).pipe(
        debounceTime(1000),
        map((res: boolean) => {
          return res ? { tournoiAbsentBase: true } : null;
        })
      );
    };
  }
}
