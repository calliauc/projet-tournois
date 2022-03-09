import { Tournoi } from 'src/app/model/tournoi';
import { Utilisateur } from 'src/app/model/utilisateur';
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
  utilisateur: Utilisateur = new Utilisateur();
  tournoi!: Tournoi;
  creation: boolean = true;

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private inscriptionService: InscriptionService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['idJoueur'] && params['idTournoi']) {
        this.creation = false;
        this.inscriptionService
          .get(params['idJoueur'], params['idTournoi'])
          .subscribe((result) => {
            this.inscription = result;
            this.tournoi = this.inscription.id!.tournoi;
            this.utilisateur = this.inscription.id!.joueur;
          });
      }
    });
  }

  save() {
    this.inscription.id!.joueur = this.utilisateur;
    this.inscription.id!.tournoi = this.tournoi;
    if (!this.creation) {
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
}
