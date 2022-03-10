import { Tournoi } from 'src/app/model/tournoi';
import { Utilisateur } from 'src/app/model/utilisateur';
import { InscriptionKey } from './../../model/inscription-key';
import { Match } from './../../model/match';
import { ActivatedRoute, Router } from '@angular/router';
import { Resultat } from './../../model/resultat';
import { ResultatService } from './../../service/resultat.service';
import { Component, OnInit } from '@angular/core';
import { Inscription } from 'src/app/model/inscription';

@Component({
  selector: 'app-resultat-edit',
  templateUrl: './resultat-edit.component.html',
  styleUrls: ['./resultat-edit.component.css'],
})
export class ResultatEditComponent implements OnInit {
  resultat: Resultat = new Resultat();

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private resultatService: ResultatService
  ) {
    this.resultat.match = new Match();
    this.resultat.participant = new Inscription();
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.resultatService.get(params['id']).subscribe((result) => {
          this.resultat = result;
          if (!this.resultat.match) {
            this.resultat.match = new Match();
          }
          if (!this.resultat.participant) {
            this.resultat.participant = new Inscription();
          }
        });
      }
    });
  }

  save() {
    if (this.resultat.id) {
      this.resultatService.update(this.resultat).subscribe((ok) => {
        this.router.navigate(['/resultat']);
      });
    } else {
      this.resultatService.create(this.resultat).subscribe((ok) => {
        console.log(this.resultat);
        this.router.navigate(['/resultat']);
      });
    }
  }
}
