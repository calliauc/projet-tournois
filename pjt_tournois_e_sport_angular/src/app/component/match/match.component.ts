import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Match } from 'src/app/model/match';
import { MatchService } from 'src/app/service/match.service';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-match',
  templateUrl: './match.component.html',
  styleUrls: ['./match.component.css'],
})
export class MatchComponent implements OnInit {
  matchObservable!: Observable<Match[]> | undefined;
  rechercheMatch!: Observable<Match[]> | undefined;
  match: Match | undefined;
  typeRecherche!: string;
  idRecherche!: number;

  constructor(
    private matchService: MatchService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private formModule: FormsModule
  ) {}

  ngOnInit(): void {
    this.matchObservable = undefined;
    this.matchObservable = this.matchService.getAll();
    this.typeRecherche = 'match';
    this.idRecherche = 100;
    this.match = undefined;
    this.rechercheMatch = undefined;
  }

  getAll() {
    this.matchObservable = this.matchService.getAll();
  }

  getByIdMatch(idMatch: number) {
    this.activatedRoute.params.subscribe((params) => {
      if (idMatch) {
        this.matchService.get(idMatch).subscribe((result) => {
          console.log(result);
          this.match = result;
        });
      }
    });
  }

  getByJournee(idJournee: number) {
    if (idJournee) {
      this.matchObservable = this.matchService.getByJournee(idJournee);
    }
  }

  getByTournoi(idTournoi: number) {
    if (idTournoi) {
      this.matchObservable = this.matchService.getByTournoi(idTournoi);
    }
  }

  searchMatch() {
    console.log(this.typeRecherche);
    if (this.typeRecherche == 'Match') {
      this.getByIdMatch(this.idRecherche);
    }
    if (this.typeRecherche == 'Journee') {
      this.getByJournee(this.idRecherche);
    }
    if (this.typeRecherche == 'Tournoi') {
      this.getByTournoi(this.idRecherche);
    }
  }

  setRechercheTournoi() {
    this.typeRecherche = 'Tournoi';
  }

  setRechercheJournee() {
    this.typeRecherche = 'Journee';
  }

  setRechercheMatch() {
    this.typeRecherche = 'Match';
  }

  delete(id: number) {
    this.matchService.delete(id).subscribe((ok) => {
      this.matchObservable = this.matchService.getAll();
    });
  }
}
