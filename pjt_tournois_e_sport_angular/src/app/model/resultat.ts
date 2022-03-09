import { Match } from './match';
import { Inscription } from './inscription';

export class Resultat {
  private _id: number | undefined;
  private _match: Match | undefined;
  private _participant: Inscription | undefined;
  private _positionMatch: number | undefined;
  private _scoreMatch: number | undefined;

  constructor(
    id?: number,
    match?: Match,
    participant?: Inscription,
    positionMatch?: number,
    scoreMatch?: number
  ) {
    this._id = id;
    this._match = match;
    this._participant = participant;
    this._positionMatch = positionMatch;
    this._scoreMatch = scoreMatch;
  }

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number | undefined {
    return this._id;
  }

  /**
   * Getter match
   * @return {Match }
   */
  public get match(): Match | undefined {
    return this._match;
  }

  /**
   * Getter participant
   * @return {Inscription }
   */
  public get participant(): Inscription | undefined {
    return this._participant;
  }

  /**
   * Getter positionMatch
   * @return {number }
   */
  public get positionMatch(): number | undefined {
    return this._positionMatch;
  }

  /**
   * Getter scoreMatch
   * @return {number }
   */
  public get scoreMatch(): number | undefined {
    return this._scoreMatch;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Setter match
   * @param {Match } value
   */
  public set match(value: Match | undefined) {
    this._match = value;
  }

  /**
   * Setter participant
   * @param {Inscription } value
   */
  public set participant(value: Inscription | undefined) {
    this._participant = value;
  }

  /**
   * Setter positionMatch
   * @param {number } value
   */
  public set positionMatch(value: number | undefined) {
    this._positionMatch = value;
  }

  /**
   * Setter scoreMatch
   * @param {number } value
   */
  public set scoreMatch(value: number | undefined) {
    this._scoreMatch = value;
  }
}
