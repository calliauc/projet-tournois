import { UtilisateurService } from 'src/app/service/utilisateur.service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
})
export class MenuComponent {
  constructor(
    private utilisateurService: UtilisateurService,
    private router: Router
  ) {}

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
}
