import { Observable } from 'rxjs';
import { Match } from './../../model/match';
import { ResultatService } from './../../service/resultat.service';
import { Component, OnInit } from '@angular/core';
import { Resultat } from 'src/app/model/resultat';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-resultat',
  templateUrl: './resultat.component.html',
  styleUrls: ['./resultat.component.css'],
})
export class ResultatComponent implements OnInit {
  resultatsObservable!: Observable<Resultat[]>;

  resultat: Resultat = new Resultat();

  constructor(
    private resultatService: ResultatService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
    this.resultat.match = new Match();
  }

  ngOnInit(): void {
    this.resultatsObservable = this.resultatService.getAll();
  }

  idResultat: number = 100;
  getById(idResultat: number) {
    this.activatedRoute.params.subscribe((params) => {
      if (idResultat) {
        this.resultatService.get(idResultat).subscribe((result) => {
          console.log(result);
          this.resultat = result;
          if (!this.resultat.match) {
            this.resultat.match = new Match();
          }
        });
      }
    });
  }

  delete(id: number) {
    this.resultatService.delete(id).subscribe((ok) => {
      this.resultatsObservable = this.resultatService.getAll();
    });
  }
}
