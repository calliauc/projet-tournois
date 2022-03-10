import { Component, OnInit } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Utilisateur } from 'src/app/model/utilisateur';
import { UtilisateurService } from 'src/app/service/utilisateur.service';
import { Role } from 'src/app/model/role';
import { Tournoi } from 'src/app/model/tournoi';

@Component({
  selector: 'app-utilisateur-compte',
  templateUrl: './utilisateur-compte.component.html',
  styleUrls: ['./utilisateur-compte.component.css'],
})
export class UtilisateurCompteComponent implements OnInit {
  userObservable!: Observable<Utilisateur>;
  user: Utilisateur = new Utilisateur();
  roles = Role;
  tournois: Tournoi[] = [];

  constructor(private userService: UtilisateurService) {}

  ngOnInit(): void {
    console.log(localStorage.getItem('login'));
    this.userService
      .getByUsername(localStorage.getItem('login')!)
      .subscribe((result) => {
        this.user = result;

        console.log(
          'mon compte : ' +
            this.user.id +
            this.user.username +
            this.user.mail +
            this.user.roles
        );
        console.log('mes tournois (orga) : ' + this.user.tournois);
        console.log('mes tournois (inscriptions) : ' + this.user.inscriptions);
      });
  }

  get Tournois(): Tournoi[] {
    // this.userService.getTournoisOfUser(this.user.id!).subscribe((result) => {
    //   this.user = result;
    // });
    console.log('mes tournois (orga) : ' + this.user.tournois);
    let tournoi: Tournoi[] = [];
    for (let t of this.user.tournois!) {
      console.log('idTournoi = ' + t.idTournoi);
      tournoi.push(t!);
    }

    return tournoi;
  }

  getInscriptions() {
    this.userService
      .getInscriptionsOfUser(this.user.id!)
      .subscribe((result) => {
        this.user = result;
      });
  }

  isAdmin(role: Role): boolean {
    return role == Role.Admin ? true : false;
  }
  isPlayer(role: Role): boolean {
    return role == Role.Joueur ? true : false;
  }
  isOrga(role: Role): boolean {
    return role == Role.Organisateur ? true : false;
  }
}
