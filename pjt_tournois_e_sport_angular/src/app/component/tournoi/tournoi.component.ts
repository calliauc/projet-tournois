import { Observable } from 'rxjs';
import { Tournoi } from './../../model/tournoi';
import { TournoiService } from './../../service/tournoi.service';
import { Component, OnInit } from '@angular/core';

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
