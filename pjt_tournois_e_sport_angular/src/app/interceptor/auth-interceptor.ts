import {
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UtilisateurService } from '../service/utilisateur.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private utilisateurService: UtilisateurService) {}

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    if (this.utilisateurService.isAuthenticated()) {
      req = req.clone({
        headers: req.headers.set(
          'Authorization',
          'Basic ' + localStorage.getItem('token')
        ),
      });
    }
    return next.handle(req);
  }
}
