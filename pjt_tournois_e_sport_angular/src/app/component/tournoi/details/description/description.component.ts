import { Component, Input, OnInit } from '@angular/core';
import { Championnat } from 'src/app/model/championnat';
import { Tournoi } from 'src/app/model/tournoi';

@Component({
  selector: 'app-description',
  templateUrl: './description.component.html',
  styleUrls: ['./description.component.css'],
})
export class DescriptionComponent implements OnInit {
  @Input()
  tournoi: Tournoi = new Championnat();

  constructor() {}

  ngOnInit(): void {}
}
