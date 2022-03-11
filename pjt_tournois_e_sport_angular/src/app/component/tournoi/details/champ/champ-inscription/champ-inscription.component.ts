import { Championnat } from 'src/app/model/championnat';
import { UtilisateurService } from 'src/app/service/utilisateur.service';
import { InscriptionService } from './../../../../../service/inscription.service';
import { Inscription } from 'src/app/model/inscription';
import { Utilisateur } from 'src/app/model/utilisateur';
import { Ligue } from 'src/app/model/ligue';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-champ-inscription',
  templateUrl: './champ-inscription.component.html',
  styleUrls: ['./champ-inscription.component.css'],
})
export class ChampInscriptionComponent implements OnInit {
  @Input()
  champ: Championnat = new Championnat();

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
    this.inscription.idTournoi = this.champ.idTournoi;
    if (confirm('Confirmer votre inscription au championnat ?')) {
      this.inscriptionService.create(this.inscription).subscribe((ok) => {
        alert('Inscription bien prise en compte !');
        this.router.navigate(['/tournoi-resume']);
      });
    }
  }
}
