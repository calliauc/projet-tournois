import { Component, Input, OnInit } from '@angular/core';
import { Championnat } from 'src/app/model/championnat';

@Component({
  selector: 'app-champ-arbre-finales',
  templateUrl: './champ-arbre-finales.component.html',
  styleUrls: ['./champ-arbre-finales.component.css'],
})
export class ChampArbreFinalesComponent implements OnInit {
  @Input()
  champ: Championnat = new Championnat();

  constructor() {}

  ngOnInit(): void {}
}
