import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ligue } from '../model/ligue';

@Injectable({
  providedIn: 'root',
})
export class LigueService {
  static URL: string = 'http://localhost:8080/tournoi_esport/api/tournoi';
  constructor(private http: HttpClient) {}

  getAll(): Observable<Ligue[]> {
    return this.http.get<Ligue[]>(LigueService.URL);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(LigueService.URL + '/' + id);
  }

  get(id: number): Observable<Ligue> {
    return this.http.get<Ligue>(LigueService.URL + '/' + id);
  }

  update(ligue: Ligue): Observable<Ligue> {
    return this.http.put<Ligue>(
      LigueService.URL + '/ligue_' + ligue.idTournoi,
      ligue
    );
  }

  create(ligue: Ligue): Observable<Ligue> {
    const tournoiEnJson = { type: ligue.type, nom: ligue.nom };

    return this.http.post<Ligue>(LigueService.URL + '/ligue', tournoiEnJson);
  }
}
