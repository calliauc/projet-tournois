import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Ligue } from 'src/app/model/ligue';
import { LigueService } from 'src/app/service/ligue.service';

@Component({
  selector: 'app-ligue-details',
  templateUrl: './ligue-details.component.html',
  styleUrls: ['./ligue-details.component.css'],
})
export class LigueDetailsComponent implements OnInit {
  ligue: Ligue = new Ligue();

  constructor(
    private activatedRoute: ActivatedRoute,
    private ligueService: LigueService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['idTournoi']) {
        this.ligueService.get(params['idTournoi']).subscribe((result) => {
          console.log(result);
          this.ligue = result;
        });
      }
    });
  }
}
