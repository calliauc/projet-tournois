import { identifierName } from '@angular/compiler';
import { Etape } from './etape.enum';
import { Tournoi } from './tournoi';
import { Match } from './match';
export class Journee {
  private _id: number | undefined;
  private _tournoi: Tournoi | undefined;
  private _matchsAJouerPourJournee: Match[] | undefined;
  private _etape: Etape | undefined;
  private _numero: number | undefined;

  constructor(
    id?: number,
    tournoi?: Tournoi,
    matchsAJouerPourJournee?: Match[],
    etape?: Etape,
    numero?: number
  ) {
    this._id = id;
    this._tournoi = tournoi;
    this._matchsAJouerPourJournee = matchsAJouerPourJournee;
    this._etape = etape;
    this._numero = numero;
  }

  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }

  public get tournoi(): Tournoi | undefined {
    return this._tournoi;
  }
  public set tournoi(value: Tournoi | undefined) {
    this._tournoi = value;
  }

  public get matchsAJouerPourJournee(): Match[] | undefined {
    return this._matchsAJouerPourJournee;
  }
  public set matchsAJouerPourJournee(value: Match[] | undefined) {
    this._matchsAJouerPourJournee = value;
  }

  public get etape(): Etape | undefined {
    return this._etape;
  }
  public set etape(value: Etape | undefined) {
    this._etape = value;
  }

  public get numero(): number | undefined {
    return this._numero;
  }
  public set numero(value: number | undefined) {
    this._numero = value;
  }
}
