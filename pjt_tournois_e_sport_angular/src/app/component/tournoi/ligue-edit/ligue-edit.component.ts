import { UtilisateurService } from 'src/app/service/utilisateur.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Tournoi } from 'src/app/model/tournoi';
import { Ligue } from 'src/app/model/ligue';
import { LigueService } from 'src/app/service/ligue.service';
import { Router } from '@angular/router';
import { map } from 'rxjs';
import { Utilisateur } from 'src/app/model/utilisateur';

@Component({
  selector: 'app-ligue-edit',
  templateUrl: './ligue-edit.component.html',
  styleUrls: ['./ligue-edit.component.css'],
})
export class LigueEditComponent implements OnInit {
  tournoi: Ligue = new Ligue();
  orga: Utilisateur = new Utilisateur();

  constructor(
    private activatedRoute: ActivatedRoute,
    private ligueService: LigueService,
    private userService: UtilisateurService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.tournoi.type = 'ligue';
    this.tournoi.nbParticipantsParMatch = 2;
    this.activatedRoute.params.subscribe((params) => {
      if (params['idTournoi']) {
        this.ligueService.get(params['idTournoi']).subscribe((result) => {
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
    this.tournoi.organisateur = this.orga;
  }

  save() {
    if (this.tournoi.idTournoi) {
      this.ligueService.update(this.tournoi).subscribe((ok) => {
        this.router.navigate(['/tournoi']);
      });
    } else {
      this.ligueService.create(this.tournoi).subscribe((ok) => {
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
