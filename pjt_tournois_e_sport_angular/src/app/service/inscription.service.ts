import { Inscription } from './../model/inscription';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class InscriptionService {
  private static URL = 'http://localhost:8080/tournoi_esport/api/inscription';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Inscription[]> {
    return this.httpClient.get<Inscription[]>(InscriptionService.URL);
  }

  public get(idJoueur: number, idTournoi: number): Observable<Inscription> {
    return this.httpClient.get<Inscription>(
      `${InscriptionService.URL}/${idJoueur}/${idTournoi}`
    );
  }

  public delete(idJoueur: number, idTournoi: number): Observable<void> {
    return this.httpClient.delete<void>(
      `${InscriptionService.URL}/${idJoueur}/${idTournoi}`
    );
  }

  // public create(): Observable<Inscription> {
  //   return this.httpClient.post<>
  // }
}
