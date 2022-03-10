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
  resultatJ2: Resultat = new Resultat();

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
    this.activatedRoute.params.subscribe((params) => {
      if (params['idResultat1']) {
        this.resultatService.get(params['idResultat1']).subscribe((result) => {
          console.log('j1');
          console.log(result);
          this.resultatJ1 = result;
        });
      }
    });
    this.activatedRoute.params.subscribe((params) => {
      if (params['idResultat2']) {
        this.resultatService.get(params['idResultat2']).subscribe((result) => {
          console.log('j2');
          console.log(result);
          this.resultatJ2 = result;
        });
      }
    });
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

  saveResultsAndMatch() {
    if (this.resultatJ1.id) {
      this.resultatService.update(this.resultatJ1).subscribe((ok) => {});
    } else {
      this.resultatService.create(this.resultatJ1).subscribe((ok) => {});
    }
    if (this.resultatJ2.id) {
      this.resultatService.update(this.resultatJ2).subscribe((ok) => {
        this.router.navigate(['/match']);
      });
    } else {
      this.resultatService.create(this.resultatJ2).subscribe((ok) => {
        this.router.navigate(['/match']);
      });
    }
  }

  byIdMatch(obj1: Match, obj2: Match) {
    if (obj1 && obj2) return obj1.id == obj2.id;
    if (obj1 == obj2) return true;
    return false;
  }
  byIdResultat(obj1: Resultat, obj2: Resultat) {
    if (obj1 && obj2) return obj1.id == obj2.id;
    if (obj1 == obj2) return true;
    return false;
  }
}
