import { Inscription } from 'src/app/model/inscription';
import { UtilisateurService } from 'src/app/service/utilisateur.service';
import { InscriptionService } from './../../../../../service/inscription.service';
import { Utilisateur } from 'src/app/model/utilisateur';
import { Ligue } from 'src/app/model/ligue';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ligue-inscription',
  templateUrl: './ligue-inscription.component.html',
  styleUrls: ['./ligue-inscription.component.css'],
})
export class LigueInscriptionComponent implements OnInit {
  @Input()
  ligue: Ligue = new Ligue();

  user: Utilisateur = new Utilisateur();
  inscription: Inscription = new Inscription();

  constructor(
    private inscriptionService: InscriptionService,
    private userService: UtilisateurService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.userService
      .getByUsername(localStorage.getItem('login')!)
      .subscribe((result) => {
        this.user = result;
      });
  }

  joueurInscription() {
    this.inscription.idJoueur = this.user.id;
    this.inscription.idTournoi = this.ligue.idTournoi;
    if (confirm('Confirmez vous votre inscription à ce tournoi ?')) {
      this.inscriptionService.create(this.inscription).subscribe((ok) => {
        alert('Inscription bien prise en compte');
        this.router.navigate(['/tournoi-resume']);
      });
    }
  }
}
