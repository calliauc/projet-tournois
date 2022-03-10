import { InscriptionKey } from './inscription-key';
export class Inscription {
  private _id: InscriptionKey | undefined;
  private _idJoueur: number | undefined;
  private _idTournoi: number | undefined;
  private _position: number | undefined;
  private _score: number | undefined;
  // private _scoreDifference: number | undefined;
  //private _prochainMatch: Match | undefined;
  //private _matchs:
  //private _resultats:

  constructor(
    id?: InscriptionKey | undefined,
    idJoueur?: number | undefined,
    idTournoi?: number | undefined,
    position?: number | undefined,
    score?: number | undefined
  ) {
    this._id = id;
    this._idJoueur = idJoueur;
    this._idTournoi = idTournoi;
    this._position = position;
    this._score = score;
  }

  /**
   * Getter id
   * @return {InscriptionKey }
   */
  public get id(): InscriptionKey | undefined {
    return this._id;
  }

  /**
   * Getter idJoueur
   * @return {number }
   */
  public get idJoueur(): number | undefined {
    return this._idJoueur;
  }

  /**
   * Getter idTournoi
   * @return {number }
   */
  public get idTournoi(): number | undefined {
    return this._idTournoi;
  }

  /**
   * Getter position
   * @return {number }
   */
  public get position(): number | undefined {
    return this._position;
  }

  /**
   * Getter score
   * @return {number }
   */
  public get score(): number | undefined {
    return this._score;
  }

  /**
   * Setter id
   * @param {InscriptionKey } value
   */
  public set id(value: InscriptionKey | undefined) {
    this._id = value;
  }

  /**
   * Setter idJoueur
   * @param {number } value
   */
  public set idJoueur(value: number | undefined) {
    this._idJoueur = value;
  }

  /**
   * Setter idTournoi
   * @param {number } value
   */
  public set idTournoi(value: number | undefined) {
    this._idTournoi = value;
  }

  /**
   * Setter position
   * @param {number } value
   */
  public set position(value: number | undefined) {
    this._position = value;
  }

  /**
   * Setter score
   * @param {number } value
   */
  public set score(value: number | undefined) {
    this._score = value;
  }
}
