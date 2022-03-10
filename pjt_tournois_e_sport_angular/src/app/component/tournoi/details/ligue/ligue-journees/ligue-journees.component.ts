import { Component, Input, OnInit } from '@angular/core';
import { Championnat } from 'src/app/model/championnat';
import { Ligue } from 'src/app/model/ligue';
import { Tournoi } from 'src/app/model/tournoi';

@Component({
  selector: 'app-ligue-journees',
  templateUrl: './ligue-journees.component.html',
  styleUrls: ['./ligue-journees.component.css'],
})
export class LigueJourneesComponent implements OnInit {
  @Input()
  ligue: Ligue = new Ligue();

  constructor() {}

  ngOnInit(): void {}
}
