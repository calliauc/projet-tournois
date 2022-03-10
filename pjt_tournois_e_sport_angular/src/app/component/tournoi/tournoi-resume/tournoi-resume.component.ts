import { Component, Input, OnInit } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Tournoi } from 'src/app/model/tournoi';
import { TournoiService } from 'src/app/service/tournoi.service';

@Component({
  selector: 'app-tournoi-resume',
  templateUrl: './tournoi-resume.component.html',
  styleUrls: ['./tournoi-resume.component.css'],
})
export class TournoiResumeComponent implements OnInit {
  tournoisObservable!: Observable<Tournoi[]>;
  @Input() title = 'Liste des tournois';
  @Input() fromMyProfile = false;
  @Input() tournois: Tournoi[] = [];

  constructor(private tournoiService: TournoiService) {}

  ngOnInit(): void {
    if (!this.fromMyProfile) {
      this.tournoiService
        .getAll()
        .subscribe((result) => (this.tournois = result));
      // .pipe(map((result) => (this.tournois = result)));
    }
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
