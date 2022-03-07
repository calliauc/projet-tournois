import { AuthService } from 'src/app/service/auth.service';
import {
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private authService: AuthService) {}

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    if (this.authService.isAuthenticated()) {
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
