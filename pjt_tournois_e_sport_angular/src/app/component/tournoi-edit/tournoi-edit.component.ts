import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Tournoi } from './../../model/tournoi';
import { TournoiService } from './../../service/tournoi.service';

@Component({
  selector: 'app-tournoi-edit',
  templateUrl: './tournoi-edit.component.html',
  styleUrls: ['./tournoi-edit.component.css'],
})
export class EditTournoiComponent implements OnInit {
  tournoi: Tournoi = new Tournoi();

  constructor(
    private activatedRoute: ActivatedRoute,
    private tournoiService: TournoiService,
    private router: Router
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

  save() {
    if (this.tournoi.idTournoi) {
      this.tournoiService.update(this.tournoi).subscribe((ok) => {
        this.router.navigate(['/tournoi']);
      });
    } else {
      this.tournoiService.create(this.tournoi).subscribe((ok) => {
        this.router.navigate(['/tournoi']);
      });
    }
  }

  byId(obj1: Tournoi, obj2: Tournoi) {
    if (obj1 && obj2) return obj1.idTournoi == obj2.idTournoi;
    if (obj1 == obj2) return true;
    return false;
  }
}
