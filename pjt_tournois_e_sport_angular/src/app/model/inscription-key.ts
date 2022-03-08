import { Tournoi } from './tournoi';
import { Utilisateur } from './utilisateur';
export class InscriptionKey {
  private _joueur: Utilisateur | undefined;
  private _tournoi: Tournoi | undefined;

  constructor(joueur?: Utilisateur, tournoi?: Tournoi) {
    this._joueur = joueur;
    this._tournoi = tournoi;
  }

  /**
   * Getter joueur
   * @return {Utilisateur }
   */
  public get joueur(): Utilisateur | undefined {
    return this._joueur;
  }

  /**
   * Getter tournoi
   * @return {Tournoi }
   */
  public get tournoi(): Tournoi | undefined {
    return this._tournoi;
  }

  /**
   * Setter joueur
   * @param {Utilisateur } value
   */
  public set joueur(value: Utilisateur | undefined) {
    this._joueur = value;
  }

  /**
   * Setter tournoi
   * @param {Tournoi } value
   */
  public set tournoi(value: Tournoi | undefined) {
    this._tournoi = value;
  }
}
