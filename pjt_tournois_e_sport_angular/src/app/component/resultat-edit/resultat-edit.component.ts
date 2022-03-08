import { Match } from './../../model/match';
import { ActivatedRoute, Router } from '@angular/router';
import { Resultat } from './../../model/resultat';
import { ResultatService } from './../../service/resultat.service';
import { Component, OnInit } from '@angular/core';

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
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.resultatService.get(params['id']).subscribe((result) => {
          console.log(result);
          this.resultat = result;
          if (!this.resultat.match) {
            this.resultat.match = new Match();
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
        this.router.navigate(['/resultat']);
      });
    }
  }
}
