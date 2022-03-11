import { Role } from 'src/app/model/role';
import { Utilisateur } from 'src/app/model/utilisateur';
import { UtilisateurService } from 'src/app/service/utilisateur.service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
})
export class MenuComponent {
  utilisateur: Utilisateur = new Utilisateur();

  constructor(
    private utilisateurService: UtilisateurService,
    private router: Router
  ) {}

  ngOnInit() {
    this.utilisateurService
      .getByUsername(localStorage.getItem('login')!)
      .subscribe((result) => {
        this.utilisateur = result;
      });
  }

  get authenticated() {
    return this.utilisateurService.isAuthenticated();
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('/accueil');
  }

  get login() {
    return localStorage.getItem('login');
  }

  isAdmin(role: Role): boolean {
    return role == Role.Admin ? true : false;
  }
  isPlayer(role: Role): boolean {
    return role == Role.Joueur ? true : false;
  }
  isOrga(role: Role): boolean {
    return role == Role.Organisateur ? true : false;
  }
}
