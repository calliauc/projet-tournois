import { Observable } from 'rxjs';
import { UtilisateurService } from './../../../service/utilisateur.service';
import { Component, OnInit } from '@angular/core';
import { Utilisateur } from 'src/app/model/utilisateur';

@Component({
  selector: 'app-utilisateur',
  templateUrl: './utilisateur.component.html',
  styleUrls: ['./utilisateur.component.css'],
})
export class UtilisateurComponent implements OnInit {
  uObservable!: Observable<Utilisateur[]>;

  constructor(private uService: UtilisateurService) {}

  ngOnInit(): void {
    this.uObservable = this.uService.getAll();
  }
}
