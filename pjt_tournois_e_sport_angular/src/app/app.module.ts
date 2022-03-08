import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AuthInterceptor } from './interceptor/auth-interceptor';
import { AppComponent } from './app.component';
import { routes } from './routes';
import { TournoiComponent } from './component/tournoi/tournoi.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { CreationCompteComponent } from './component/creation-compte/creation-compte.component';
import { LoginComponent } from './component/login/login.component';
import { AccueilComponent } from './component/accueil/accueil.component';
import { BlackWhiteTextDirective } from './directive/black-white-text.directive';
import { ResultatComponent } from './component/resultat/resultat.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { UtilisateurComponent } from './component/utilisateur/utilisateur/utilisateur.component';
import { LigueEditComponent } from './component/tournoi/ligue-edit/ligue-edit.component';
import { ChampionnatEditComponent } from './component/tournoi/championnat-edit/championnat-edit.component';
import { ResultatEditComponent } from './component/resultat-edit/resultat-edit.component';
import { LigueClassementComponent } from './component/tournoi/ligue-classement/ligue-classement.component';
import { MenuComponent } from './component/menu/menu.component';

@NgModule({
  declarations: [
    AppComponent,
    TournoiComponent,
    CreationCompteComponent,
    LoginComponent,
    AccueilComponent,
    BlackWhiteTextDirective,
    ResultatComponent,
    InscriptionComponent,
    UtilisateurComponent,
    LigueEditComponent,
    ChampionnatEditComponent,
    ResultatEditComponent,
    LigueClassementComponent,
    MenuComponent,
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
