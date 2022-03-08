import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Tournoi } from 'src/app/model/tournoi';
import { Ligue } from 'src/app/model/ligue';
import { TournoiService } from 'src/app/service/tournoi.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-ligue-edit',
  templateUrl: './ligue-edit.component.html',
  styleUrls: ['./ligue-edit.component.css'],
})
export class LigueEditComponent implements OnInit {
  tournoi: Tournoi = new Ligue();

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
