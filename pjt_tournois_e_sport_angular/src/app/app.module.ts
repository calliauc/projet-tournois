import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AuthInterceptor } from './interceptor/auth-interceptor';
import { AppComponent } from './app.component';
import { routes } from './routes';
import { TournoiComponent } from './component/tournoi/tournoi.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { LoginComponent } from './component/login/login.component';
import { AccueilComponent } from './component/accueil/accueil.component';

@NgModule({
  declarations: [
    AppComponent,
    TournoiComponent,
    InscriptionComponent,
    LoginComponent,
    AccueilComponent,
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
