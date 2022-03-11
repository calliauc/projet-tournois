import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { UtilisateurService } from 'src/app/service/utilisateur.service';

@Component({
  selector: 'app-utilisateur-login',
  templateUrl: './utilisateur-login.component.html',
  styleUrls: ['./utilisateur-login.component.css'],
})
export class UtilisateurLoginComponent implements OnInit {
  form!: FormGroup;
  error = false;

  constructor(
    private utilisateurService: UtilisateurService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.form = new FormGroup({
      login: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
    });
  }

  save() {
    console.log('In save() : utilisateur-login');
    this.utilisateurService
      .authentication(
        this.form.controls['login'].value,
        this.form.controls['password'].value
      )
      .subscribe({
        next: (ok) => {
          this.error = false;
          localStorage.setItem('login', this.form.controls['login'].value);
          localStorage.setItem(
            'token',
            btoa(
              this.form.controls['login'].value +
                ':' +
                this.form.controls['password'].value
            )
          );
          this.router.navigateByUrl('/accueil');
          location.replace('/accueil');
        },
        error: (error) => {
          this.error = true;
        },
      });
  }
}
