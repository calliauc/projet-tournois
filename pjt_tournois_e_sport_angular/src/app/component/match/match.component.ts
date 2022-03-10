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
  matchObservable!: Observable<Match[]>;
  rechercheMatch!: Observable<Match[]>;
  match!: Observable<Match>;
  typeRecherche!: string;
  idRecherche!: number;

  constructor(
    private matchService: MatchService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private formModule: FormsModule
  ) {}

  ngOnInit(): void {
    this.matchObservable = this.matchService.getAll();
  }

  getByIdMatch(idMatch: number) {
    if (idMatch) {
      this.match = this.matchService.get(idMatch);
    }
  }

  getByIdTournoi(idTournoi: number) {}

  getByJournee(idJournee: number) {
    if (idJournee) {
      this.rechercheMatch = this.matchService.getByJournee(idJournee);
    }
  }

  delete(id: number) {
    this.matchService.delete(id).subscribe((ok) => {
      this.matchObservable = this.matchService.getAll();
    });
  }
}
