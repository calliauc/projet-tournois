import { Inscription } from './../../model/inscription';
import { InscriptionService } from './../../service/inscription.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  inscriptionsObservable!: Observable<Inscription[]>;
  constructor(private inscriptionService: InscriptionService) {}

  ngOnInit(): void {
    this.inscriptionsObservable = this.inscriptionService.getAll();
  }

  delete(idJoueur: number, idTournoi: number) {
    this.inscriptionService.delete(idJoueur, idTournoi).subscribe((ok) => {
      this.inscriptionsObservable = this.inscriptionService.getAll();
    });
  }
}
