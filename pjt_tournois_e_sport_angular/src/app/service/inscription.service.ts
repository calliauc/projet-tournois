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

  //CRUD
  public getAll(): Observable<Inscription[]> {
    return this.httpClient.get<Inscription[]>(InscriptionService.URL);
  }

  public get(idJoueur: number, idTournoi: number): Observable<Inscription> {
    return this.httpClient.get<Inscription>(
      `${InscriptionService.URL}/${idJoueur}&${idTournoi}`
    );
  }

  public delete(idJoueur: number, idTournoi: number): Observable<void> {
    return this.httpClient.delete<void>(
      `${InscriptionService.URL}/${idJoueur}&${idTournoi}`
    );
  }

  public create(inscrition: Inscription): Observable<Inscription> {
    return this.httpClient.post<Inscription>(
      InscriptionService.URL,
      this.inscriptionToJson(inscrition)
    );
  }

  public update(inscription: Inscription): Observable<Inscription> {
    return this.httpClient.put<Inscription>(
      `${InscriptionService.URL}/${inscription.id!.joueur!.id}&${
        inscription.id!.tournoi!.idTournoi
      }`,
      this.inscriptionToJson(inscription)
    );
  }

  //METHODS
  private inscriptionToJson(inscription: Inscription): any {
    const obj = {
      id: {
        joueur: {
          id: inscription.id!.joueur!.id,
        },
        tournoi: {
          id: inscription.id!.tournoi!.idTournoi,
        },
      },
      position: inscription.position,
      score: inscription.score,
    };
    return obj;
  }
}
