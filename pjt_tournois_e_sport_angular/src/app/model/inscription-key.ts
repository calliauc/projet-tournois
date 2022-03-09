import { Tournoi } from './tournoi';
import { Utilisateur } from './utilisateur';
export class InscriptionKey {
  private _joueur: Utilisateur;
  private _tournoi: Tournoi;

  constructor(joueur: Utilisateur, tournoi: Tournoi) {
    this._joueur = joueur;
    this._tournoi = tournoi;
  }

  /**
   * Getter joueur
   * @return {Utilisateur }
   */
  public get joueur(): Utilisateur {
    return this._joueur;
  }

  /**
   * Getter tournoi
   * @return {Tournoi }
   */
  public get tournoi(): Tournoi {
    return this._tournoi;
  }

  /**
   * Setter joueur
   * @param {Utilisateur } value
   */
  public set joueur(value: Utilisateur) {
    this._joueur = value;
  }

  /**
   * Setter tournoi
   * @param {Tournoi } value
   */
  public set tournoi(value: Tournoi) {
    this._tournoi = value;
  }
}
