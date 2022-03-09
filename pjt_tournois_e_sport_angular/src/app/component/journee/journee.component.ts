import { Journee } from './../../model/journee';
import { Component, OnInit } from '@angular/core';
import { JourneeService } from 'src/app/service/journee.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-journee',
  templateUrl: './journee.component.html',
  styleUrls: ['./journee.component.css'],
})
export class JourneeComponent implements OnInit {
  journeesObservable!: Observable<Journee[]>;

  constructor(private journeeService: JourneeService) {}

  ngOnInit(): void {
    this.journeesObservable = this.journeeService.getAll();
  }

  delete(idTournoi: number) {
    this.journeeService.delete(idTournoi).subscribe((ok) => {
      this.journeesObservable = this.journeeService.getAll();
    });
  }
}
