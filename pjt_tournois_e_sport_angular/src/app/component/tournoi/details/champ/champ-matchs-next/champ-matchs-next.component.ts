import { Component, Input, OnInit } from '@angular/core';
import { Championnat } from 'src/app/model/championnat';

@Component({
  selector: 'app-champ-matchs-next',
  templateUrl: './champ-matchs-next.component.html',
  styleUrls: ['./champ-matchs-next.component.css'],
})
export class ChampMatchsNextComponent implements OnInit {
  @Input()
  champ: Championnat = new Championnat();

  constructor() {}

  ngOnInit(): void {}
}
