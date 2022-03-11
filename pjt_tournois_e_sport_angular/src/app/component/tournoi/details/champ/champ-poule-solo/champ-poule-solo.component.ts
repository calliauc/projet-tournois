import { Component, Input, OnInit } from '@angular/core';
import { Inscription } from 'src/app/model/inscription';
import { Poule } from 'src/app/model/poule';
import { InscriptionService } from 'src/app/service/inscription.service';
import { PouleService } from 'src/app/service/poule.service';

@Component({
  selector: 'app-champ-poule-solo',
  templateUrl: './champ-poule-solo.component.html',
  styleUrls: ['./champ-poule-solo.component.css'],
})
export class ChampPouleSoloComponent implements OnInit {
  @Input()
  idPoule: number | undefined = 0;

  inscrits: Inscription[] = [];
  poule: Poule = new Poule();

  constructor(
    private pouleService: PouleService,
    private inscriptionService: InscriptionService
  ) {}

  ngOnInit(): void {
    this.pouleService
      .get(this.idPoule as number)
      .subscribe((result) => (this.poule = result));
    this.inscriptionService
      .getByTournoi(this.idPoule as number)
      .subscribe((result) => (this.inscrits = result));
  }
}
