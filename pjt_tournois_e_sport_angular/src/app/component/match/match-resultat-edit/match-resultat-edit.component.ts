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
  matchAFinir: Match = new Match();
  resultatJ1: Resultat = new Resultat();
  resultatJ2: Resultat = new Resultat();
  listResultats: Resultat[] = [this.resultatJ1, this.resultatJ2];

  constructor(
    private matchService: MatchService,
    private resultatService: ResultatService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
    this.matchAFinir.resultats = this.listResultats;
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['idResultat1']) {
        this.resultatService.get(params['idResultat1']).subscribe((result) => {
          console.log('j1');
          console.log(result);
          this.resultatJ1 = result;
        });
      } else {
        console.log(this.resultatJ1);
      }
    });
    this.activatedRoute.params.subscribe((params) => {
      if (params['idResultat2']) {
        this.resultatService.get(params['idResultat2']).subscribe((result) => {
          console.log('j2');
          console.log(result);
          this.resultatJ2 = result;
        });
      } else {
        console.log(this.resultatJ2);
      }
    });
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.matchService.get(params['id']).subscribe((result) => {
          console.log(result);
          this.matchAFinir = result;
          this.resultatJ1.match = result;
          this.resultatJ2.match = result;
          this.resultatJ1.participant = result.inscriptions![0];
          this.resultatJ2.participant = result.inscriptions![1];
          console.log(this.resultatJ1);
        });
      }
    });
  }

  save() {
    this.matchAFinir.resultats = [this.resultatJ1, this.resultatJ2];
    if (this.matchAFinir.id) {
      this.matchService.update(this.matchAFinir).subscribe((ok) => {});
    } else {
      this.matchService.create(this.matchAFinir).subscribe((ok) => {});
    }
  }

  saveMatch() {
    if (this.matchAFinir.id) {
      this.matchService.update(this.matchAFinir).subscribe((ok) => {
        this.router.navigate(['/match']);
      });
    } else {
      this.matchService.create(this.matchAFinir).subscribe((ok) => {
        this.router.navigate(['/match']);
      });
    }
  }

  saveResultsAndMatch() {
    if (this.matchAFinir.id) {
      this.matchAFinir.resultats = [this.resultatJ1, this.resultatJ2];
      this.matchService.update(this.matchAFinir).subscribe((ok) => {
        this.router.navigate(['/match']);
      });
    } else {
      this.matchAFinir.resultats = [this.resultatJ1, this.resultatJ2];
      this.matchService.create(this.matchAFinir).subscribe((ok) => {
        this.router.navigate(['/match']);
      });
    }
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
