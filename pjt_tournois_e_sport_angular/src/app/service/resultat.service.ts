import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Resultat } from './../model/resultat';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ResultatService {
  private static URL = 'http://localhost:8080/tournoi_esport/api/resultat';
  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Resultat[]> {
    return this.httpClient.get<Resultat[]>(ResultatService.URL);
  }

  public get(id: number): Observable<Resultat> {
    return this.httpClient.get<Resultat>(`${ResultatService.URL}/${id}`);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${ResultatService.URL}/${id}`);
  }

  public create(resultat: Resultat): Observable<Resultat> {
    return this.httpClient.post<Resultat>(
      ResultatService.URL,
      this.resultatToJson(resultat)
    );
  }

  public update(resultat: Resultat): Observable<Resultat> {
    console.log(this.resultatToJson(resultat));
    return this.httpClient.put<Resultat>(
      `${ResultatService.URL}/${resultat.id}`,
      this.resultatToJson(resultat)
    );
  }

  private resultatToJson(resultat: Resultat): any {
    const obj = {
      id: resultat.id,
      positionMatch: resultat.positionMatch,
      scoreMatch: resultat.scoreMatch,
    };

    if (resultat.match) {
      Object.assign(obj, {
        match: {
          matchId: resultat.match.id,
        },
      });
    }

    //if (resultat.participant) {
    //  Object.assign(obj, {
    //    participant: {
    //      idParticipant: resultat.participant.joueur.id,
    //      idTournoi: resultat.participant.tournoi.idTournoi,
    //    },
    //  });
    //}
    return obj;
  }
}
