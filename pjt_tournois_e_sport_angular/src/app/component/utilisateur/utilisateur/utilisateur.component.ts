import { map, Observable } from 'rxjs';
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
  user: Utilisateur = new Utilisateur();

  constructor(private uService: UtilisateurService) {}

  ngOnInit(): void {
    this.uObservable = this.uService.getAll();
  }

  delete(id: number) {
    this.uService.delete(id).subscribe((ok) => {
      this.uObservable = this.uService.getAll();
    });
  }

  // checkAuth(): boolean {
  //   const authUser = this.uService.getByUsername(localStorage.getItem('login')!).pipe(map((auth) => this.user= auth));
  //   console.log(authUser);
  //   if(authUser.roles)
  // }
}
