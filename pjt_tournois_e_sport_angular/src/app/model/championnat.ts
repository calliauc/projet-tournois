import { Etape } from './etape.enum';
import { Journee } from './journee';
import { Poule } from './poule';
import { Tournoi } from './tournoi';

export class Championnat extends Tournoi {
  private _journeesAJouerPoules?: Journee[] | undefined;
  private _journeesAJouerFinales?: Journee[] | undefined;
  private _poules?: Poule[] | undefined;
  private _prochaineEtape?: Etape | undefined;

  constructor(
    journeesAJouerPoules?: Journee[],
    journeesAJouerFinales?: Journee[],
    poules?: Poule[],
    prochaineEtape?: Etape
  ) {
    super();

    this._journeesAJouerPoules = journeesAJouerPoules;
    this._journeesAJouerFinales = journeesAJouerFinales;
    this._poules = poules;
    this._prochaineEtape = prochaineEtape;
  }

  /**
   * Getter journeesAJouerPoules
   * @return {Journee[]}
   */

  public get journeesAJouerPoules(): Journee[] | undefined {
    return this._journeesAJouerPoules;
  }

  /**
   * Getter journeesAJouerFinales
   * @return {Journee[]}
   */

  public get journeesAJouerFinales(): Journee[] | undefined {
    return this._journeesAJouerFinales;
  }

  /**
   * Getter poules
   * @return {Poule[]}
   */

  public get poules(): Poule[] | undefined {
    return this._poules;
  }

  /**
   * Getter prochaineEtape
   * @return {Etape}
   */

  public get prochaineEtape(): Etape | undefined {
    return this._prochaineEtape;
  }

  /**
   * Setter journeesAJouerPoules
   * @param {Journee[]} value
   */
  public set journeesAJouerPoules(value: Journee[] | undefined) {
    this._journeesAJouerPoules = value;
  }

  /**
   * Setter journeesAJouerFinales
   * @param {Journee[]} value
   */
  public set journeesAJouerFinales(value: Journee[] | undefined) {
    this._journeesAJouerFinales = value;
  }

  /**
   * Setter poules
   * @param {Poule[]} value
   */
  public set poules(value: Poule[] | undefined) {
    this._poules = value;
  }

  /**
   * Setter prochaineEtape
   * @param {Etape} value
   */
  public set prochaineEtape(value: Etape | undefined) {
    this._prochaineEtape = value;
  }
}
