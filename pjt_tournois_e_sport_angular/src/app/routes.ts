import { Routes } from '@angular/router';
import { TournoiComponent } from './component/tournoi/tournoi.component';
import { EditTournoiComponent } from './component/tournoi-edit/tournoi-edit.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { LoginComponent } from './component/login/login.component';
import { AccueilComponent } from './component/accueil/accueil.component';

export const routes: Routes = [
  { path: 'accueil', component: AccueilComponent },

  { path: 'tournoi', component: TournoiComponent },

  { path: 'tournoi/edit', component: EditTournoiComponent },

  { path: 'inscription', component: InscriptionComponent },

  { path: 'login', component: LoginComponent },

  { path: '', redirectTo: 'accueil', pathMatch: 'full' },
];
