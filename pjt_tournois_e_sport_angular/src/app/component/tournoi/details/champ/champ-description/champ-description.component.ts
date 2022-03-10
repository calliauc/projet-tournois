import { Component, Input, OnInit } from '@angular/core';
import { Championnat } from 'src/app/model/championnat';

@Component({
  selector: 'app-champ-description',
  templateUrl: './champ-description.component.html',
  styleUrls: ['./champ-description.component.css'],
})
export class ChampDescriptionComponent implements OnInit {
  @Input()
  champ: Championnat = new Championnat();

  constructor() {}

  ngOnInit(): void {}
}
