import { Inscription } from './inscription';
import { Utilisateur } from './utilisateur';
export class Classement {
  private _joueurs: Utilisateur[] | undefined;
  private _inscriptions: Inscription[] | undefined;

  constructor(joueurs?: Utilisateur[], inscriptions?: Inscription[]) {
    (this._joueurs = joueurs), (this._inscriptions = inscriptions);
  }

  public get joueurs(): Utilisateur[] | undefined {
    return this._joueurs;
  }
  public set joueurs(value: Utilisateur[] | undefined) {
    this._joueurs = value;
  }
  public get inscriptions(): Inscription[] | undefined {
    return this._inscriptions;
  }
  public set inscriptions(value: Inscription[] | undefined) {
    this._inscriptions = value;
  }
}
