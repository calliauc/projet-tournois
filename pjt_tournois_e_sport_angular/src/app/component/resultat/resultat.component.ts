import { Observable } from 'rxjs';
import { ResultatService } from './../../service/resultat.service';
import { Component, OnInit } from '@angular/core';
import { Resultat } from 'src/app/model/resultat';

@Component({
  selector: 'app-resultat',
  templateUrl: './resultat.component.html',
  styleUrls: ['./resultat.component.css'],
})
export class ResultatComponent implements OnInit {
  resultatsObservable!: Observable<Resultat[]>;

  constructor(private resultatService: ResultatService) {}

  ngOnInit(): void {
    this.resultatsObservable = this.resultatService.getAll();
  }

  delete(id: number) {
    this.resultatService.delete(id).subscribe((ok) => {
      this.resultatsObservable = this.resultatService.getAll();
    });
  }
}
