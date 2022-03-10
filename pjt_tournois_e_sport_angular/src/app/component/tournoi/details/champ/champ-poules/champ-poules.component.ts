import { Component, Input, OnInit } from '@angular/core';
import { Championnat } from 'src/app/model/championnat';

@Component({
  selector: 'app-champ-poules',
  templateUrl: './champ-poules.component.html',
  styleUrls: ['./champ-poules.component.css'],
})
export class ChampPoulesComponent implements OnInit {
  @Input()
  champ: Championnat = new Championnat();

  constructor() {}

  ngOnInit(): void {}
}
