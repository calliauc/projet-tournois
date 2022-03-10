import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AuthInterceptor } from './interceptor/auth-interceptor';
import { AppComponent } from './app.component';
import { routes } from './routes';
import { registerLocaleData } from '@angular/common';
import localeFr from '@angular/common/locales/fr';
import { TournoiComponent } from './component/tournoi/tournoi.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AccueilComponent } from './component/accueil/accueil.component';
import { BlackWhiteTextDirective } from './directive/black-white-text.directive';
import { ResultatComponent } from './component/resultat/resultat.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { UtilisateurComponent } from './component/utilisateur/utilisateur/utilisateur.component';
import { LigueEditComponent } from './component/tournoi/ligue-edit/ligue-edit.component';
import { ChampionnatEditComponent } from './component/tournoi/championnat-edit/championnat-edit.component';
import { ResultatEditComponent } from './component/resultat-edit/resultat-edit.component';
import { LigueClassementComponent } from './component/tournoi/ligue-classement/ligue-classement.component';
import { InscriptionEditComponent } from './component/inscription-edit/inscription-edit.component';
import { MenuComponent } from './component/menu/menu.component';
import { UtilisateurEditComponent } from './component/utilisateur/utilisateur-edit/utilisateur-edit.component';
import { UtilisateurLoginComponent } from './component/utilisateur/utilisateur-login/utilisateur-login.component';
import { JourneeComponent } from './component/journee/journee.component';
import { JourneeDetailComponent } from './component/journee/journee-detail/journee-detail.component';
import { JourneeEditComponent } from './component/journee/journee-edit/journee-edit.component';
import { TournoiResumeComponent } from './component/tournoi/tournoi-resume/tournoi-resume.component';
import { TournoiDetailsComponent } from './component/tournoi/tournoi-details/tournoi-details.component';
import { MatchComponent } from './component/match/match.component';
import { MatchsNextComponent } from './component/tournoi/details/matchs-next/matchs-next.component';
import { MatchEditComponent } from './component/match/match-edit/match-edit.component';
import { MatchResultatEditComponent } from './component/match/match-resultat-edit/match-resultat-edit.component';
import { ChampArbreFinalesComponent } from './component/tournoi/details/champ/champ-arbre-finales/champ-arbre-finales.component';
import { ChampDescriptionComponent } from './component/tournoi/details/champ/champ-description/champ-description.component';
import { ChampPoulesComponent } from './component/tournoi/details/champ/champ-poules/champ-poules.component';
import { LigueDescriptionComponent } from './component/tournoi/details/ligue/ligue-description/ligue-description.component';
import { LigueJourneesComponent } from './component/tournoi/details/ligue/ligue-journees/ligue-journees.component';

@NgModule({
  declarations: [
    AppComponent,
    TournoiComponent,
    AccueilComponent,
    BlackWhiteTextDirective,
    ResultatComponent,
    InscriptionComponent,
    UtilisateurComponent,
    UtilisateurEditComponent,
    UtilisateurLoginComponent,
    LigueEditComponent,
    ChampionnatEditComponent,
    ResultatEditComponent,
    LigueClassementComponent,
    InscriptionEditComponent,
    MenuComponent,
    JourneeComponent,
    JourneeDetailComponent,
    JourneeEditComponent,
    TournoiResumeComponent,
    TournoiDetailsComponent,
    MatchComponent,
    MatchsNextComponent,
    MatchEditComponent,
    MatchResultatEditComponent,
    ChampArbreFinalesComponent,
    ChampDescriptionComponent,
    ChampPoulesComponent,
    LigueDescriptionComponent,
    LigueJourneesComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],

  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
