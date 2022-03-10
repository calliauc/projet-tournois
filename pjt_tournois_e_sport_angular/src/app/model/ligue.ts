import { Journee } from './journee';
import { Tournoi } from './tournoi';
export class Ligue extends Tournoi {
  protected _isMatchRetour?: boolean | undefined;
  protected _isPoule?: boolean | undefined;
  protected _nbPhase?: number | undefined;
  protected _journeesAJouer?: Journee[] | undefined;
  constructor(
    isMatchRetour?: boolean,
    isPoule?: boolean,
    nbPhase?: number,
    journeesAJouer?: Journee[]
  ) {
    super();
    this._isMatchRetour = isMatchRetour;
    this._isPoule = isPoule;
    this._nbPhase = nbPhase;
    this._journeesAJouer = journeesAJouer;
  }

  /**
   * Getter isMatchRetour
   * @return {boolean}
   */
  public get isMatchRetour(): boolean | undefined {
    return this._isMatchRetour;
  }
  /**
   * Getter isPoule
   * @return {boolean}
   */
  public get isPoule(): boolean | undefined {
    return this._isPoule;
  }
  /**
   * Getter nbPhase
   * @return {number}
   */
  public get nbPhase(): number | undefined {
    return this._nbPhase;
  }

  /**
   * Getter JourneesAJouer
   * @return {Journee[]}
   */

  public get journeesAJouer(): Journee[] | undefined {
    return this._journeesAJouer;
  }

  /**
   * Setter isMatchRetour
   * @param {boolean} value
   */
  public set isMatchRetour(value: boolean | undefined) {
    this._isMatchRetour = value;
  }

  /**
   * Setter isPoule
   * @param {boolean} value
   */
  public set isPoule(value: boolean | undefined) {
    this._isPoule = value;
  }

  /**
   * Setter nbPhase
   * @param {number} value
   */
  public set nbPhase(value: number | undefined) {
    this._nbPhase = value;
  }

  /**
   * Setter nbPhase
   * @param {Journee[]} value
   */
  public set journeesAJouer(value: Journee[] | undefined) {
    this._journeesAJouer = value;
  }
}
