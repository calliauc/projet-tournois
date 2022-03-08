import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Championnat } from '../model/championnat';
@Injectable({
  providedIn: 'root',
})
export class ChampionnatService {
  static URL: string = 'http://localhost:8080/tournoi_esport/api/tournoi';
  constructor(private http: HttpClient) {}

  getAll(): Observable<Championnat[]> {
    return this.http.get<Championnat[]>(ChampionnatService.URL);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(ChampionnatService.URL + '/' + id);
  }

  get(id: number): Observable<Championnat> {
    return this.http.get<Championnat>(ChampionnatService.URL + '/' + id);
  }

  update(tournoi: Championnat): Observable<Championnat> {
    return this.http.put<Championnat>(
      ChampionnatService.URL + '/championnat_' + tournoi.idTournoi,
      tournoi
    );
  }

  create(tournoi: Championnat): Observable<Championnat> {
    const championnatEnJson = {
      type: tournoi.type,
      nom: tournoi.nom,
      dateDeDebut: tournoi.dateDeDebut,
      jeu: tournoi.jeu,
      nbParticipantsParMatch: tournoi.nbParticipantsParMatch,
      nbParticipantsTotal: tournoi.nbParticipantsTotal,
      /*       organisateur : ligue.organisateur,  */
    };
    return this.http.post<Championnat>(
      ChampionnatService.URL + '/championnat',
      championnatEnJson
    );
  }
}
