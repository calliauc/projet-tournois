import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Match } from 'src/app/model/match';
import { MatchService } from 'src/app/service/match.service';
@Component({
  selector: 'app-match',
  templateUrl: './match.component.html',
  styleUrls: ['./match.component.css'],
})
export class MatchComponent implements OnInit {
  matchObservable!: Observable<Match[]>;

  constructor(private matchService: MatchService) {}

  ngOnInit(): void {
    this.matchObservable = this.matchService.getAll();
  }

  delete(id: number) {
    this.matchService.delete(id).subscribe((ok) => {
      this.matchObservable = this.matchService.getAll();
    });
  }
}
