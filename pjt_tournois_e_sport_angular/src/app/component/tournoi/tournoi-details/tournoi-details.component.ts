import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Championnat } from 'src/app/model/championnat';
import { Ligue } from 'src/app/model/ligue';
import { Tournoi } from 'src/app/model/tournoi';
import { TournoiService } from 'src/app/service/tournoi.service';

@Component({
  selector: 'app-tournoi-details',
  templateUrl: './tournoi-details.component.html',
  styleUrls: ['./tournoi-details.component.css'],
})
export class TournoiDetailsComponent implements OnInit {
  tournoi: Tournoi = new Tournoi();

  constructor(
    private activatedRoute: ActivatedRoute,
    private tournoiService: TournoiService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['idTournoi']) {
        this.tournoiService.get(params['idTournoi']).subscribe((result) => {
          console.log(result);
          this.tournoi = result;
        });
      }
    });
  }
}
