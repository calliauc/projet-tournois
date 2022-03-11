import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Poule } from '../model/poule';

@Injectable({
  providedIn: 'root',
})
export class PouleService {
  static URL: string = 'http://localhost:8080/tournoi_esport/api/tournoi';
  constructor(private http: HttpClient) {}

  getAll(): Observable<Poule[]> {
    return this.http.get<Poule[]>(PouleService.URL);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(PouleService.URL + '/' + id);
  }

  get(id: number): Observable<Poule> {
    return this.http.get<Poule>(PouleService.URL + '/' + id);
  }

  getClassement(id: number): Observable<[]> {
    return this.http.get<[]>(PouleService.URL + '/Poule_classement/' + id);
  }

  update(Poule: Poule): Observable<Poule> {
    return this.http.put<Poule>(
      PouleService.URL + '/Poule_' + Poule.idTournoi,
      Poule
    );
  }

  create(Poule: Poule): Observable<Poule> {
    const tournoiEnJson = {
      type: Poule.type,
      nom: Poule.nom,
      dateDeDebut: Poule.dateDeDebut,
      jeu: Poule.jeu,
      nbParticipantsParMatch: Poule.nbParticipantsParMatch,
      nbParticipantsTotal: Poule.nbParticipantsTotal,
      organisateur: Poule.organisateur,
      isMatchRetour: Poule.isMatchRetour,
    };

    return this.http.post<Poule>(PouleService.URL + '/Poule', tournoiEnJson);
  }
}
