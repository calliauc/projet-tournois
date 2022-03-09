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

  public create(inscription: Inscription): Observable<Inscription> {
    return this.httpClient.post<Inscription>(
      InscriptionService.URL,
      this.inscriptionToJsonCreate(inscription)
    );
  }

  public update(inscription: Inscription): Observable<Inscription> {
    console.log(inscription);
    return this.httpClient.put<Inscription>(
      `${InscriptionService.URL}/${inscription.id?.joueur?.id}&${inscription.id?.tournoi?.idTournoi}`,
      this.inscriptionToJsonUpdate(inscription)
    );
  }

  //METHODS CRUD
  private inscriptionToJsonUpdate(inscription: Inscription): any {
    const obj = {
      id: {
        idJoueur: inscription.id?.joueur?.id,
        idTournoi: inscription.id?.tournoi?.idTournoi,
      },
      position: inscription.position,
      score: inscription.score,
    };
    return obj;
  }

  private inscriptionToJsonCreate(inscription: Inscription): any {
    const obj = {
      idJoueur: inscription.idJoueur,
      idTournoi: inscription.idTournoi,
    };
    return obj;
  }
}
