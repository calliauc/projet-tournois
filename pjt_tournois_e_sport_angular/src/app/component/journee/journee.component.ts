import { Journee } from './../../model/journee';
import { Component, OnInit } from '@angular/core';
import { JourneeService } from 'src/app/service/journee.service';
import { Observable } from 'rxjs';
import { Match } from 'src/app/model/match';

@Component({
  selector: 'app-journee',
  templateUrl: './journee.component.html',
  styleUrls: ['./journee.component.css'],
})
export class JourneeComponent implements OnInit {
  journeesObservable!: Observable<Journee[]>;
  nMatchList = new Array();
  nbMatchJournee!: number;
  constructor(private journeeService: JourneeService) {}

  ngOnInit(): void {
    this.journeesObservable = this.journeeService.getAll();

    /* for (let i = 0; i < 3; i++) {
      this.nMatchList.push(i);
    } */
  }

  delete(idTournoi: number) {
    this.journeeService.delete(idTournoi).subscribe((ok) => {
      this.journeesObservable = this.journeeService.getAll();
    });
  }
}
