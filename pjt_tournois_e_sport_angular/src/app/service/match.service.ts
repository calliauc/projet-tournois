import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Match } from '../model/match';

@Injectable({
  providedIn: 'root',
})
export class MatchService {
  static URL: string = 'http://localhost:8080/tournoi_esport/api/match';
  constructor(private http: HttpClient) {}

  getAll(): Observable<Match[]> {
    return this.http.get<Match[]>(MatchService.URL);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(MatchService.URL + '/' + id);
  }

  get(id: number): Observable<Match> {
    return this.http.get<Match>(MatchService.URL + '/' + id);
  }

  update(match: Match): Observable<Match> {
    return this.http.put<Match>(MatchService.URL + '/' + match.id, match);
  }

  create(match: Match): Observable<Match> {
    const matchEnJson = {
      id: match.id,
      inscriptions: match.inscriptions,
      journee: match.journee,
    };

    return this.http.post<Match>(MatchService.URL + '/', matchEnJson);
  }
}
