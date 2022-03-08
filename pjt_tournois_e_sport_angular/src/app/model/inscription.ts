import { InscriptionKey } from './inscription-key';
export class Inscription {
  private _key: InscriptionKey | undefined;
  private _position: number | undefined;
  private _score: number | undefined;
  private _scoreDifference: number | undefined;
  //private _prochainMatch: Match | undefined;
  //private _matchs:
  //private _resultats:

  constructor(
    key: InscriptionKey,
    position: number,
    score: number,
    scoreDifference: number
  ) {
    this._key = key;
    this._position = position;
    this._score = score;
    this._scoreDifference = scoreDifference;
  }

  /**
   * Getter key
   * @return {InscriptionKey }
   */
  public get key(): InscriptionKey | undefined {
    return this._key;
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
   * Getter scoreDifference
   * @return {number }
   */
  public get scoreDifference(): number | undefined {
    return this._scoreDifference;
  }

  /**
   * Setter key
   * @param {InscriptionKey } value
   */
  public set key(value: InscriptionKey | undefined) {
    this._key = value;
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

  /**
   * Setter scoreDifference
   * @param {number } value
   */
  public set scoreDifference(value: number | undefined) {
    this._scoreDifference = value;
  }
}
