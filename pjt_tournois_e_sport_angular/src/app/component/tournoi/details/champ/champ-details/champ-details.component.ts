import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Championnat } from 'src/app/model/championnat';
import { ChampionnatService } from 'src/app/service/championnat.service';

@Component({
  selector: 'app-champ-details',
  templateUrl: './champ-details.component.html',
  styleUrls: ['./champ-details.component.css'],
})
export class ChampDetailsComponent implements OnInit {
  champ: Championnat = new Championnat();

  constructor(
    private activatedRoute: ActivatedRoute,
    private championnatService: ChampionnatService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['idTournoi']) {
        this.championnatService.get(params['idTournoi']).subscribe((result) => {
          console.log(result);
          this.champ = result;
        });
      }
    });
  }
}
