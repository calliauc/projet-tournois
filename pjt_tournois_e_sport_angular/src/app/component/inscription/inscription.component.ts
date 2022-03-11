import { Inscription } from './../../model/inscription';
import { InscriptionService } from './../../service/inscription.service';
import { Component, Input, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  inscriptionsObservable!: Observable<Inscription[]>;
  @Input() title = 'Liste des inscriptions';
  @Input() fromMyProfile = false;
  @Input() inscriptions: Inscription[] = [];

  constructor(private inscriptionService: InscriptionService) {}

  ngOnInit(): void {
    if (!this.fromMyProfile) {
      this.inscriptionService
        .getAll()
        .subscribe((result) => (this.inscriptions = result));
    } else {
      this.inscriptions.forEach((inscr, index) => {
        inscr.idJoueur = this.inscriptions[index].id!.joueur!.id;
        inscr.idTournoi = this.inscriptions[index].id!.tournoi!.idTournoi;
        console.log(inscr.idJoueur);
        console.log(inscr.idTournoi);
        console.log(inscr.position);
        console.log(inscr.score);
      });
    }
    // for(let i in this.inscriptions) {
    //   this.inscriptionsi.idJoueur =
    // }
  }

  // console.log('incriptionsComponent : ' + this.inscriptions[0]);

  delete(idJoueur: number, idTournoi: number) {
    this.inscriptionService.delete(idJoueur!, idTournoi!).subscribe((ok) => {
      this.inscriptionsObservable = this.inscriptionService.getAll();
    });
  }
}
