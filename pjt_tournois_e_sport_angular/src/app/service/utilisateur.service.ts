import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Utilisateur } from '../model/utilisateur';

@Injectable({
  providedIn: 'root',
})
export class UtilisateurService {
  private static URL = 'http://localhost:8080/tournoi_esport/api/utilisateur';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Utilisateur[]> {
    return this.httpClient.get<Utilisateur[]>(
      UtilisateurService.URL + '/membres'
    );
  }

  public get(id: number): Observable<Utilisateur> {
    return this.httpClient.get<Utilisateur>(`${UtilisateurService.URL}/${id}`);
  }

  public create(utilisateur: Utilisateur): Observable<Utilisateur> {
    console.log(utilisateur);
    return this.httpClient.post<Utilisateur>(
      UtilisateurService.URL + '/signup',
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

  public authentication(login: string, password: string): Observable<void> {
    let headers = new HttpHeaders({
      Authorization: 'Basic ' + btoa(login + ':' + password),
    });
    return this.httpClient.get<void>(
      UtilisateurService.URL + '/authentification',
      {
        headers: headers,
      }
    );
  }

  public isAuthenticated(): string | null {
    return localStorage.getItem('token');
  }

  public checkUsername(username: string): Observable<boolean> {
    return this.httpClient.get<boolean>(
      UtilisateurService.URL + '/searchByLogin/' + username
    );
  }
  public checkMail(mail: string): Observable<boolean> {
    return this.httpClient.get<boolean>(
      UtilisateurService.URL + '/searchByMail/' + mail
    );
  }

  public checkId(id: number): Observable<boolean> {
    return this.httpClient.get<boolean>(
      `${UtilisateurService.URL}/searchById/${id}`
    );
  }

  public utilisateurToJson(utilisateur: Utilisateur): any {
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
