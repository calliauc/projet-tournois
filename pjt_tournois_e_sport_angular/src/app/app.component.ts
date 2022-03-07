import { Component } from '@angular/core';
import { AuthService } from 'src/app/service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'pjt_tournois_e_sport_angular';

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
