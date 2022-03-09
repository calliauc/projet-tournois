import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Championnat } from 'src/app/model/championnat';
import { Tournoi } from 'src/app/model/tournoi';
import { TournoiService } from 'src/app/service/tournoi.service';

@Component({
  selector: 'app-tournoi-details',
  templateUrl: './tournoi-details.component.html',
  styleUrls: ['./tournoi-details.component.css'],
})
export class TournoiDetailsComponent implements OnInit {
  tournoi: Tournoi = new Championnat();

  constructor(
    private activatedRoute: ActivatedRoute,
    private tournoisService: TournoiService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['idTournoi']) {
        this.tournoisService.get(params['idTournoi']).subscribe((result) => {
          console.log(result);
          this.tournoi = result;
        });
      }
    });
  }
}
