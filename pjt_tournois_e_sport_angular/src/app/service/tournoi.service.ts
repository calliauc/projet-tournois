import { Tournoi } from './../model/tournoi';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TournoiService {
  static URL: string = 'http://localhost:8080/boot/api/tournoi';
  constructor(private http: HttpClient) {}

  getAll(): Observable<Tournoi[]> {
    return this.http.get<Tournoi[]>(TournoiService.URL);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(TournoiService.URL + '/' + id);
  }

  get(id: number): Observable<Tournoi> {
    return this.http.get<Tournoi>(TournoiService.URL + '/' + id);
  }

  update(tournoi: Tournoi): Observable<Tournoi> {
    return this.http.put<Tournoi>(
      TournoiService.URL + '/' + tournoi.idTournoi,
      tournoi
    );
  }

  create(tournoi: Tournoi): Observable<Tournoi> {
    const tournoiEnJson = { nom: tournoi.nom };
    return this.http.post<Tournoi>(TournoiService.URL, tournoiEnJson);
  }
}
