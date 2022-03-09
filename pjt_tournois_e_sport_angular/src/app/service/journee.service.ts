import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Journee } from '../model/journee';

@Injectable({
  providedIn: 'root',
})
export class JourneeService {
  static URL: string = 'http://localhost:8080/tournoi_esport/api/journee';
  constructor(private http: HttpClient) {}

  getAll(): Observable<Journee[]> {
    return this.http.get<Journee[]>(JourneeService.URL);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(JourneeService.URL + '/' + id);
  }

  get(id: number): Observable<Journee> {
    return this.http.get<Journee>(JourneeService.URL + '/' + id);
  }

  update(journee: Journee): Observable<Journee> {
    return this.http.put<Journee>(
      JourneeService.URL + '/' + journee.id,
      journee
    );
  }

  create(journee: Journee): Observable<Journee> {
    const journeeEnJson = {
      tournoi: journee.tournoi,
      matchsAJouerPourJournee: journee.matchsAJouerPourJournee,
      etape: journee.etape,
      numero: journee.numero,
    };

    return this.http.post<Journee>(JourneeService.URL + '/', journeeEnJson);
  }
}
