import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Ligue } from 'src/app/model/ligue';
import { LigueService } from 'src/app/service/ligue.service';
import { PositionLigue } from 'src/app/model/positionLigue';

@Component({
  selector: 'app-ligue-classement',
  templateUrl: './ligue-classement.component.html',
  styleUrls: ['./ligue-classement.component.css'],
})
export class LigueClassementComponent implements OnInit {
  tournoi: Ligue = new Ligue();
  classement?: PositionLigue[];
  constructor(
    private activatedRoute: ActivatedRoute,
    private ligueService: LigueService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['idTournoi']) {
        this.ligueService.get(params['idTournoi']).subscribe((result) => {
          console.log(result);
          this.tournoi = result;
        });
        this.ligueService
          .getClassement(params['idTournoi'])
          .subscribe((result) => {
            console.log('classement');
            console.log(result);
            this.classement = result;
          });
      }
    });
  }
}
