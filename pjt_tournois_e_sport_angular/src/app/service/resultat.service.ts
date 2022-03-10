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
    console.log(this.resultatToJsonToCreate(resultat));
    return this.httpClient.post<Resultat>(
      ResultatService.URL,
      this.resultatToJsonToCreate(resultat)
    );
  }

  public update(resultat: Resultat): Observable<Resultat> {
    console.log(this.resultatToJsonToUpdate(resultat));
    return this.httpClient.put<Resultat>(
      `${ResultatService.URL}/${resultat.id}`,
      this.resultatToJsonToUpdate(resultat)
    );
  }

  private resultatToJsonToUpdate(resultat: Resultat): any {
    const obj = {
      id: resultat.id,
      positionMatch: resultat.positionMatch,
      scoreMatch: resultat.scoreMatch,
    };

    if (resultat.match) {
      Object.assign(obj, {
        match: {
          id: resultat.match.id,
        },
      });
    }

    if (resultat.participant) {
      Object.assign(obj, {
        participant: {
          id: {
            joueur: {
              id: resultat.participant?.id?.joueur?.id,
            },
            tournoi: {
              type: resultat.participant?.id?.tournoi?.type,
              idTournoi: resultat.participant?.id?.tournoi?.idTournoi,
            },
          },
        },
      });
    }
    return obj;
  }

  private resultatToJsonToCreate(resultat: Resultat): any {
    const obj = {
      positionMatch: resultat.positionMatch,
      scoreMatch: resultat.scoreMatch,
      participant: resultat.participant,
    };

    if (resultat.match) {
      Object.assign(obj, {
        match: {
          id: resultat.match.id,
        },
      });
    }

    return obj;
  }
}
