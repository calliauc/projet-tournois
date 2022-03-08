import { ChampionnatEditComponent } from './component/tournoi/championnat-edit/championnat-edit.component';
import { LigueEditComponent } from './component/tournoi/ligue-edit/ligue-edit.component';
import { UtilisateurComponent } from './component/utilisateur/utilisateur/utilisateur.component';
import { Routes } from '@angular/router';
import { TournoiComponent } from './component/tournoi/tournoi.component';
import { EditTournoiComponent } from './component/tournoi-edit/tournoi-edit.component';
import { CreationCompteComponent } from './component/creation-compte/creation-compte.component';
import { LoginComponent } from './component/login/login.component';
import { AccueilComponent } from './component/accueil/accueil.component';

export const routes: Routes = [
  { path: 'accueil', component: AccueilComponent },

  { path: 'tournoi', component: TournoiComponent },

  { path: 'tournoi/edit', component: EditTournoiComponent },

  { path: 'ligue/edit', component: LigueEditComponent },

  { path: 'championnat/edit', component: ChampionnatEditComponent },

  { path: 'signup', component: CreationCompteComponent },

  { path: 'login', component: LoginComponent },

  { path: '', redirectTo: 'accueil', pathMatch: 'full' },

  { path: 'utilisateur', component: UtilisateurComponent },
];
