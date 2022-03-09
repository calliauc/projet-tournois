import { Resultat } from './resultat';
import { Journee } from './journee';
//code pour le test de resultat, match avec seulement un id!!!!
//reste à faire tous les autres attributs, etc!!!!!

import { Inscription } from './inscription';

export class Match {
  private _id: number | undefined;
  private _inscriptions: Inscription[] | undefined;
  private _journee: Journee | undefined;
  private _resultats: Resultat[] | undefined;
  constructor(
    id?: number,
    inscriptions?: Inscription[],
    journee?: Journee,
    resultats?: Resultat[]
  ) {
    this._id = id;
    this._inscriptions = inscriptions;
    this._journee = journee;
    this._resultats = resultats;
  }

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number | undefined {
    return this._id;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  public get inscriptions(): Inscription[] | undefined {
    return this._inscriptions;
  }
  public set inscriptions(value: Inscription[] | undefined) {
    this._inscriptions = value;
  }

  public get journee(): Journee | undefined {
    return this._journee;
  }
  public set journee(value: Journee | undefined) {
    this._journee = value;
  }

  public get resultats(): Resultat[] | undefined {
    return this._resultats;
  }
  public set resultats(value: Resultat[] | undefined) {
    this._resultats = value;
  }
}
