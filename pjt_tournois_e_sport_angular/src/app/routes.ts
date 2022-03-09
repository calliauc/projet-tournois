import { InscriptionEditComponent } from './component/inscription-edit/inscription-edit.component';
import { UtilisateurEditComponent } from './component/utilisateur/utilisateur-edit/utilisateur-edit.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { ChampionnatEditComponent } from './component/tournoi/championnat-edit/championnat-edit.component';
import { LigueEditComponent } from './component/tournoi/ligue-edit/ligue-edit.component';
import { UtilisateurComponent } from './component/utilisateur/utilisateur/utilisateur.component';
import { Routes } from '@angular/router';
import { TournoiComponent } from './component/tournoi/tournoi.component';
import { CreationCompteComponent } from './component/creation-compte/creation-compte.component';
import { LoginComponent } from './component/login/login.component';
import { AccueilComponent } from './component/accueil/accueil.component';
import { ResultatComponent } from './component/resultat/resultat.component';
import { ResultatEditComponent } from './component/resultat-edit/resultat-edit.component';
import { LigueClassementComponent } from './component/tournoi/ligue-classement/ligue-classement.component';

export const routes: Routes = [
  { path: 'accueil', component: AccueilComponent },

  { path: 'tournoi', component: TournoiComponent },

  { path: 'ligue/edit', component: LigueEditComponent },

  { path: 'ligue/edit/:idTournoi', component: LigueEditComponent },

  { path: 'championnat/edit', component: ChampionnatEditComponent },

  { path: 'championnat/edit/:idTournoi', component: ChampionnatEditComponent },

  { path: 'resultat', component: ResultatComponent },

  { path: 'resultat/edit', component: ResultatEditComponent },

  { path: 'signup', component: CreationCompteComponent },

  { path: 'login', component: LoginComponent },

  { path: '', redirectTo: 'accueil', pathMatch: 'full' },

  { path: 'utilisateur', component: UtilisateurComponent },

  { path: 'ligue/classement/:idTournoi', component: LigueClassementComponent },

  { path: 'inscription', component: InscriptionComponent },

  { path: 'inscription/edit', component: InscriptionEditComponent },

  {
    path: 'inscription/edit/:idJoueur&:idTournoi',
    component: InscriptionEditComponent,
  },

  { path: 'utilisateur/utilisateur-edit', component: UtilisateurEditComponent },
];
