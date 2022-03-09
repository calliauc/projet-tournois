import { InscriptionKey } from './inscription-key';
import { Utilisateur } from './utilisateur';
export class PositionLigue {
  private _id: InscriptionKey | undefined;
  private _position: number | undefined;
  private _score: number | undefined;
  private _scoreDifference: number | undefined;
  constructor(
    id?: InscriptionKey,
    position?: number,
    score?: number,
    scoreDifference?: number
  ) {
    (this._id = id),
      (this._position = position),
      (this._score = score),
      (this._scoreDifference = scoreDifference);
  }

  public get id(): InscriptionKey | undefined {
    return this._id;
  }
  public set id(value: InscriptionKey | undefined) {
    this._id = value;
  }

  public get position(): number | undefined {
    return this._position;
  }
  public set position(value: number | undefined) {
    this._position = value;
  }

  public get score(): number | undefined {
    return this._score;
  }
  public set score(value: number | undefined) {
    this._score = value;
  }

  public get scoreDifference(): number | undefined {
    return this._scoreDifference;
  }
  public set scoreDifference(value: number | undefined) {
    this._scoreDifference = value;
  }
}