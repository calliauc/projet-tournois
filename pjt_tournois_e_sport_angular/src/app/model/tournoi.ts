import { StatutInscriptions } from './statutInscriptions.enum';
import { StatutTemps } from './statutTemps.enum';
export abstract class Tournoi {
  protected _type: string | undefined;
  protected _idTournoi: number | undefined;
  protected _nom: string | undefined;
  protected _dateDeCreation: Date | undefined;
  protected _dateDeDebut: Date | undefined;
  protected _jeu: string | undefined;
  protected _statutTemps: StatutTemps | undefined;
  protected _statutInscriptions: StatutInscriptions | undefined;
  //protected _listeInscriptions: //////TO DO
  protected _nbParticipantsParMatch: number | undefined;
  protected _nbParticipantsTotal: number | undefined;
  //protected _organisateur: Utilisateur | undefined;

  constructor(
    type?: string,
    idTournoi?: number,
    nom?: string,
    dateDeCreation?: Date,
    dateDeDebut?: Date,
    jeu?: string,
    //listeInscriptions?:
    statutTemps?: StatutTemps,
    statutInscriptions?: StatutInscriptions,
    nbParticipantsParMatch?: number,
    nbParticipantsTotal?: number
    //organisateur?:
  ) {
    this._idTournoi = idTournoi;
    this._nom = nom;
    this._dateDeCreation = dateDeCreation;
    this._dateDeDebut = dateDeDebut;
    this._jeu = jeu;
    //this._listeInscriptions = listeInscriptions;
    this._nbParticipantsParMatch = nbParticipantsParMatch;
    this._nbParticipantsTotal = nbParticipantsTotal;
    //this._organisateur = organisateur;
  }

  /**
   * Getter idTournoi
   * @return {number }
   */
  public get idTournoi(): number | undefined {
    return this._idTournoi;
  }

  /**
   * Getter type
   * @return {string }
   */
  public get type(): string | undefined {
    return this._type;
  }

  /**
   * Getter nom
   * @return {string }
   */
  public get nom(): string | undefined {
    return this._nom;
  }

  /**
   * Getter dateDeCreation
   * @return {Date }
   */
  public get dateDeCreation(): Date | undefined {
    return this._dateDeCreation;
  }

  /**
   * Getter dateDeDebut
   * @return {Date }
   */
  public get dateDeDebut(): Date | undefined {
    return this._dateDeDebut;
  }

  /**
   * Getter jeu
   * @return {string }
   */
  public get jeu(): string | undefined {
    return this._jeu;
  }
  /**
   * Getter statut temps
   * @return {StatutTemps }
   */
  public get statutTemps(): StatutTemps | undefined {
    return this._statutTemps;
  }

  /**
   * Getter statut inscriptions
   * @return {StatutTemps }
   */
  public get statutInscriptions(): StatutInscriptions | undefined {
    return this._statutInscriptions;
  }

  /**
   * Getter nbParticipantsParMatch
   * @return {number }
   */
  public get nbParticipantsParMatch(): number | undefined {
    return this._nbParticipantsParMatch;
  }

  /**
   * Getter nbParticipantsTotal
   * @return {number }
   */
  public get nbParticipantsTotal(): number | undefined {
    return this._nbParticipantsTotal;
  }

  ///**
  // * Getter organisateur
  // * @return {Utilisateur }
  // */
  //public get organisateur(): Utilisateur | undefined {
  //  return this._organisateur;
  //}

  /**
   * Setter idTournoi
   * @param {string } value
   */
  public set type(value: string | undefined) {
    this._type = value;
  }

  /**
   * Setter idTournoi
   * @param {number } value
   */
  public set idTournoi(value: number | undefined) {
    this._idTournoi = value;
  }

  /**
   * Setter nom
   * @param {string } value
   */
  public set nom(value: string | undefined) {
    this._nom = value;
  }

  /**
   * Setter dateDeCreation
   * @param {Date } value
   */
  public set dateDeCreation(value: Date | undefined) {
    this._dateDeCreation = value;
  }

  /**
   * Setter dateDeDebut
   * @param {Date } value
   */
  public set dateDeDebut(value: Date | undefined) {
    this._dateDeDebut = value;
  }

  /**
   * Setter jeu
   * @param {string } value
   */
  public set jeu(value: string | undefined) {
    this._jeu = value;
  }

  /**
   * Setter statut temps
   * @param {StatutTemps} value
   */
  public set statutTemps(value: StatutTemps | undefined) {
    this._statutTemps = value;
  }

  /**
   * Setter statut temps
   * @param {StatutInscriptions} value
   */
  public set statutInscriptions(value: StatutInscriptions | undefined) {
    this._statutInscriptions = value;
  }

  /**
   * Setter nbParticipantsParMatch
   * @param {number } value
   */
  public set nbParticipantsParMatch(value: number | undefined) {
    this._nbParticipantsParMatch = value;
  }

  /**
   * Setter nbParticipantsTotal
   * @param {number } value
   */
  public set nbParticipantsTotal(value: number | undefined) {
    this._nbParticipantsTotal = value;
  }

  ///**
  // * Setter organisateur
  // * @param {Utilisateur } value
  // */
  //public set organisateur(value: Utilisateur | undefined) {
  //  this._organisateur = value;
  //}
}
