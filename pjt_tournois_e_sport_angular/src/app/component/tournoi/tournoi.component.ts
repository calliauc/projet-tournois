import { filter, Observable } from 'rxjs';
import { Tournoi } from './../../model/tournoi';
import { TournoiService } from './../../service/tournoi.service';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-tournoi',
  templateUrl: './tournoi.component.html',
  styleUrls: ['./tournoi.component.css'],
})
export class TournoiComponent implements OnInit {
  tournoisObservable!: Observable<Tournoi[]>;

  constructor(private tournoiService: TournoiService) {}

  ngOnInit(): void {
    this.tournoisObservable = this.tournoiService.getAll();
  }

  delete(idTournoi: number) {
    this.tournoiService.delete(idTournoi).subscribe((ok) => {
      this.tournoisObservable = this.tournoiService.getAll();
    });
  }
}
