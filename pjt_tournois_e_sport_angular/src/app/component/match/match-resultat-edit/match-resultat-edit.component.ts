import { Resultat } from './../../../model/resultat';
import { ResultatService } from './../../../service/resultat.service';
import { MatchService } from './../../../service/match.service';
import { Match } from './../../../model/match';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-match-resultat-edit',
  templateUrl: './match-resultat-edit.component.html',
  styleUrls: ['./match-resultat-edit.component.css'],
})
export class MatchResultatEditComponent implements OnInit {
  match: Match = new Match();
  resultatJ1: Resultat = new Resultat();
  resulatJ2: Resultat = new Resultat();
  resultatJ1ID: string | undefined;
  resultatJ2ID: number | undefined;

  constructor(
    private matchService: MatchService,
    private resultatService: ResultatService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.matchService.get(params['id']).subscribe((result) => {
          console.log(result);
          this.match = result;
        });
      }
    });
    if (this.match.resultats != null) {
      this.resultatJ1ID = this.match.resultats[0]?.id?.toString();
    }
  }

  save() {
    if (this.match.id) {
      this.matchService.update(this.match).subscribe((ok) => {
        this.router.navigate(['/match']);
      });
    } else {
      this.matchService.create(this.match).subscribe((ok) => {
        this.router.navigate(['/match']);
      });
    }
  }

  byId(obj1: Match, obj2: Match) {
    if (obj1 && obj2) return obj1.id == obj2.id;
    if (obj1 == obj2) return true;
    return false;
  }
}
