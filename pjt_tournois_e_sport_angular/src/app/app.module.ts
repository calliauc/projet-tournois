import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { routes } from './routes';
import { TournoiComponent } from './component/tournoi/tournoi.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

@NgModule({
  declarations: [AppComponent, TournoiComponent],
  imports: [BrowserModule, RouterModule.forRoot(routes), HttpClientModule],

  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
