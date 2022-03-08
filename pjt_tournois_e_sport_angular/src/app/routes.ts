import { UtilisateurComponent } from './component/utilisateur/utilisateur/utilisateur.component';
import { Routes } from '@angular/router';
import { TournoiComponent } from './component/tournoi/tournoi.component';
import { EditTournoiComponent } from './component/tournoi-edit/tournoi-edit.component';
import { CreationCompteComponent } from './component/creation-compte/creation-compte.component';
import { LoginComponent } from './component/login/login.component';
import { AccueilComponent } from './component/accueil/accueil.component';
import { ResultatComponent } from './component/resultat/resultat.component';

export const routes: Routes = [
  { path: 'accueil', component: AccueilComponent },

  { path: 'tournoi', component: TournoiComponent },

  { path: 'tournoi/edit', component: EditTournoiComponent },

  { path: 'resultat', component: ResultatComponent },

  { path: 'signup', component: CreationCompteComponent },

  { path: 'login', component: LoginComponent },

  { path: '', redirectTo: 'accueil', pathMatch: 'full' },

  { path: 'utilisateur', component: UtilisateurComponent },
];
