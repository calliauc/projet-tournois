import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Tournoi } from 'src/app/model/tournoi';
import { TournoiService } from 'src/app/service/tournoi.service';

@Component({
  selector: 'app-tournoi-resume',
  templateUrl: './tournoi-resume.component.html',
  styleUrls: ['./tournoi-resume.component.css'],
})
export class TournoiResumeComponent implements OnInit {
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

  details(idTournoi: number) {
    this.tournoiService.delete(idTournoi).subscribe((ok) => {
      this.tournoisObservable = this.tournoiService.getAll();
    });
  }
}
