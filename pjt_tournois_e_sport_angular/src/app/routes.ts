import { MatchComponent } from './component/match/match.component';
import { JourneeEditComponent } from './component/journee/journee-edit/journee-edit.component';
import { JourneeDetailComponent } from './component/journee/journee-detail/journee-detail.component';
import { JourneeComponent } from './component/journee/journee.component';
import { UtilisateurLoginComponent } from './component/utilisateur/utilisateur-login/utilisateur-login.component';
import { InscriptionEditComponent } from './component/inscription-edit/inscription-edit.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { ChampionnatEditComponent } from './component/tournoi/championnat-edit/championnat-edit.component';
import { LigueEditComponent } from './component/tournoi/ligue-edit/ligue-edit.component';
import { UtilisateurComponent } from './component/utilisateur/utilisateur/utilisateur.component';
import { Routes } from '@angular/router';
import { TournoiComponent } from './component/tournoi/tournoi.component';
import { AccueilComponent } from './component/accueil/accueil.component';
import { ResultatComponent } from './component/resultat/resultat.component';
import { ResultatEditComponent } from './component/resultat-edit/resultat-edit.component';
import { LigueClassementComponent } from './component/tournoi/ligue-classement/ligue-classement.component';
import { UtilisateurEditComponent } from './component/utilisateur/utilisateur-edit/utilisateur-edit.component';
import { TournoiResumeComponent } from './component/tournoi/tournoi-resume/tournoi-resume.component';
import { TournoiDetailsComponent } from './component/tournoi/tournoi-details/tournoi-details.component';
import { ChampDetailsComponent } from './component/tournoi/details/champ/champ-details/champ-details.component';
import { LigueDetailsComponent } from './component/tournoi/details/ligue/ligue-details/ligue-details.component';

export const routes: Routes = [
  { path: 'accueil', component: AccueilComponent },

  { path: 'tournoi', component: TournoiComponent },

  { path: 'tournoi-resume', component: TournoiResumeComponent },

  {
    path: 'tournoi/champ/details/:idTournoi',
    component: ChampDetailsComponent,
  },

  {
    path: 'tournoi/ligue/details/:idTournoi',
    component: LigueDetailsComponent,
  },

  { path: 'ligue/edit', component: LigueEditComponent },

  { path: 'ligue/edit/:idTournoi', component: LigueEditComponent },

  { path: 'championnat/edit', component: ChampionnatEditComponent },

  { path: 'championnat/edit/:idTournoi', component: ChampionnatEditComponent },

  { path: 'resultat', component: ResultatComponent },

  { path: 'resultat/edit', component: ResultatEditComponent },

  { path: 'resultat/edit/:id', component: ResultatEditComponent },

  { path: 'signup', component: UtilisateurEditComponent },

  { path: 'login', component: UtilisateurLoginComponent },

  { path: '', redirectTo: 'accueil', pathMatch: 'full' },

  { path: 'utilisateur', component: UtilisateurComponent },

  { path: 'utilisateur/edit/:id', component: UtilisateurEditComponent },

  { path: 'ligue/classement/:idTournoi', component: LigueClassementComponent },

  { path: 'inscription', component: InscriptionComponent },

  { path: 'inscription/edit', component: InscriptionEditComponent },

  {
    path: 'inscription/edit/:idJoueur/:idTournoi',
    component: InscriptionEditComponent,
  },

  { path: 'utilisateur/utilisateur-edit', component: UtilisateurEditComponent },

  { path: 'journee', component: JourneeComponent },

  { path: 'journee/detail/:id', component: JourneeDetailComponent },

  { path: 'journee/edit', component: JourneeEditComponent },

  { path: 'journee/edit/:id', component: JourneeEditComponent },

  { path: 'match', component: MatchComponent },

  { path: 'match/edit', component: MatchComponent },

  { path: 'match/edit/:id', component: MatchComponent },
];
