import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Utilisateur } from '../model/utilisateur';

@Injectable({
  providedIn: 'root',
})
export class UtilisateurService {
  private static URL = 'http://localhost:8080/boot/api/utilisateur';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Utilisateur[]> {
    return this.httpClient.get<Utilisateur[]>(UtilisateurService.URL);
  }

  public get(id: number): Observable<Utilisateur> {
    return this.httpClient.get<Utilisateur>(UtilisateurService.URL + '/{id}');
  }

  public create(utilisateur: Utilisateur): Observable<Utilisateur> {
    return this.httpClient.post<Utilisateur>(
      UtilisateurService.URL,
      this.utilisateurToJson(utilisateur)
    );
  }

  public update(utilisateur: Utilisateur): Observable<Utilisateur> {
    return this.httpClient.put<Utilisateur>(
      UtilisateurService.URL + '/{id}',
      this.utilisateurToJson(utilisateur)
    );
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(UtilisateurService.URL + '/{id}');
  }

  private utilisateurToJson(utilisateur: Utilisateur): any {
    const obj = {
      id: utilisateur.id,
      username: utilisateur.username,
      mail: utilisateur.mail,
      password: utilisateur.password,
      roles: utilisateur.roles,
    };
    return obj;
  }
}
