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
import { EditTournoiComponent } from './component/tournoi-edit/tournoi-edit.component';
import { BlackWhiteTextDirective } from './directive/black-white-text.directive';
import { UtilisateurComponent } from './component/utilisateur/utilisateur/utilisateur.component';

@NgModule({
  declarations: [
    AppComponent,
    TournoiComponent,
    CreationCompteComponent,
    LoginComponent,
    AccueilComponent,
    EditTournoiComponent,
    BlackWhiteTextDirective,
    UtilisateurComponent,
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
