import { Tournoi } from './../model/tournoi';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TournoiService {
  static URL: string = 'http://localhost:8080/tournoi_esport/api/tournoi';
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

  public checkId(id: number): Observable<boolean> {
    return this.http.get<boolean>(`${TournoiService.URL}/searchById/${id}`);
  }
}
