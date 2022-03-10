import { MatchService } from './../../../service/match.service';
import { Match } from './../../../model/match';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-match-edit',
  templateUrl: './match-edit.component.html',
  styleUrls: ['./match-edit.component.css'],
})
export class MatchEditComponent implements OnInit {
  match: Match = new Match();

  constructor(
    private matchService: MatchService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.matchService.get(params['id']).subscribe((result) => {
          console.log(result);
          this.match = result;
        });
      }
    });
  }

  save() {
    if (this.match.id) {
      this.matchService.update(this.match).subscribe((ok) => {
        this.router.navigate(['/match']);
      });
    } else {
      this.matchService.create(this.match).subscribe((ok) => {
        this.router.navigate(['/match']);
      });
    }
  }

  byId(obj1: Match, obj2: Match) {
    if (obj1 && obj2) return obj1.id == obj2.id;
    if (obj1 == obj2) return true;
    return false;
  }
}
