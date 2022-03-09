import { Component } from '@angular/core';
import { AuthService } from 'src/app/service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
})
export class MenuComponent {
  constructor(private authService: AuthService, private router: Router) {}

  get authenticated() {
    return this.authService.isAuthenticated();
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('/accueil');
  }

  get login() {
    return localStorage.getItem('login');
  }
}
