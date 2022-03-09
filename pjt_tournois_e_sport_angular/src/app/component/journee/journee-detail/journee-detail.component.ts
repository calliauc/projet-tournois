import { Observable } from 'rxjs';
import { Journee } from './../../../model/journee';
import { JourneeService } from 'src/app/service/journee.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Match } from 'src/app/model/match';

@Component({
  selector: 'app-journee-detail',
  templateUrl: './journee-detail.component.html',
  styleUrls: ['./journee-detail.component.css'],
})
export class JourneeDetailComponent implements OnInit {
  journee: Journee = new Journee();
  constructor(
    private journeeService: JourneeService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}
  matchObservable!: Match[];

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.journeeService.get(params['id']).subscribe((result) => {
          console.log(result);
          this.journee = result;
        });
      }
    });
    this.matchObservable = this.journee.matchsAJouerPourJournee!;
    console.log(this.matchObservable);
  }
}
