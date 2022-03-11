import { Component, OnInit } from '@angular/core';
import { Championnat } from 'src/app/model/championnat';
import { ActivatedRoute } from '@angular/router';
import { Tournoi } from 'src/app/model/tournoi';
import { Router } from '@angular/router';
import { ChampionnatService } from 'src/app/service/championnat.service';
import { Utilisateur } from 'src/app/model/utilisateur';
import { UtilisateurService } from 'src/app/service/utilisateur.service';
@Component({
  selector: 'app-championnat-edit',
  templateUrl: './championnat-edit.component.html',
  styleUrls: ['./championnat-edit.component.css'],
})
export class ChampionnatEditComponent implements OnInit {
  tournoi: Championnat = new Championnat();
  orga: Utilisateur = new Utilisateur();

  constructor(
    private activatedRoute: ActivatedRoute,
    private championnatService: ChampionnatService,
    private userService: UtilisateurService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.tournoi.type = 'championnat';
    this.tournoi.nbParticipantsParMatch = 2;
    this.activatedRoute.params.subscribe((params) => {
      if (params['idTournoi']) {
        this.championnatService.get(params['idTournoi']).subscribe((result) => {
          console.log(result);
          this.tournoi = result;
        });
      }
    });

    this.userService
      .getByUsername(localStorage.getItem('login')!)
      .subscribe((result) => {
        console.log(result);
        this.orga = result;
      });
  }

  save() {
    this.tournoi.organisateur = this.orga;
    if (this.tournoi.idTournoi) {
      this.championnatService.update(this.tournoi).subscribe((ok) => {
        this.router.navigate(['/tournoi']);
      });
    } else {
      this.championnatService.create(this.tournoi).subscribe((ok) => {
        this.router.navigate(['/tournoi']);
      });
    }
  }

  byId(obj1: Tournoi, obj2: Tournoi) {
    if (obj1 && obj2) return obj1.idTournoi == obj2.idTournoi;
    if (obj1 == obj2) return true;
    return false;
  }
}
