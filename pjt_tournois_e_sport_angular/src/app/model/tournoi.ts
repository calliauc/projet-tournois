export class Tournoi {
  private _idTournoi: number | undefined;
  private _nom: string | undefined;
  private _dateDeCreation: Date | undefined;
  private _dateDeDebut: Date | undefined;
  private _jeu: string | undefined;
  //private _listeInscriptions: //////TO DO
  private _nbParticipantsParMatch: number | undefined;
  private _nbParticipantsTotal: number | undefined;
  //private _organisateur: Utilisateur | undefined;

  constructor(
    idTournoi?: number,
    nom?: string,
    dateDeCreation?: Date,
    dateDeDebut?: Date,
    jeu?: string,
    //listeInscriptions?:
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
