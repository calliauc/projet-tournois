import { Component, Input, OnInit } from '@angular/core';
import { Ligue } from 'src/app/model/ligue';

@Component({
  selector: 'app-ligue-matchs-next',
  templateUrl: './ligue-matchs-next.component.html',
  styleUrls: ['./ligue-matchs-next.component.css'],
})
export class LigueMatchsNextComponent implements OnInit {
  @Input()
  ligue: Ligue = new Ligue();

  constructor() {}

  ngOnInit(): void {}
}
