import { Component, Input, OnInit } from '@angular/core';
import { Ligue } from 'src/app/model/ligue';

@Component({
  selector: 'app-ligue-description',
  templateUrl: './ligue-description.component.html',
  styleUrls: ['./ligue-description.component.css'],
})
export class LigueDescriptionComponent implements OnInit {
  @Input()
  ligue: Ligue = new Ligue();

  constructor() {}

  ngOnInit(): void {}
}
