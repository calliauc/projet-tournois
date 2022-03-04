import { Tournoi } from './../../model/tournoi';
import { TournoiService } from './../../service/tournoi.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tournoi',
  templateUrl: './tournoi.component.html',
  styleUrls: ['./tournoi.component.css'],
  providers: [{ useClass: TournoiService, provide: TournoiService }],
})
export class TournoiComponent implements OnInit {
  constructor(private tournoiService: TournoiService) {}

  tournois: Tournoi[] = [];

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.tournoiService.getAll().subscribe((result) => {
      this.tournois = result;
    });
  }

  delete(id: number) {
    this.tournoiService.delete(id).subscribe((result) => {
      this.list();
    });
  }
}
