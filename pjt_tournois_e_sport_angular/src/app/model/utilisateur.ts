import { Inscription } from './inscription';
import { Role } from './role';
import { Tournoi } from './tournoi';
export class Utilisateur {
  private _id: number | undefined;
  private _username: string | undefined;
  private _mail: string | undefined;
  private _password: string | undefined;
  private _roles: Role[] | undefined;
  private _inscriptions: Inscription[] | undefined;
  private _tournois: Tournoi[] | undefined;

  constructor(
    id?: number,
    username?: string,
    mail?: string,
    password?: string,
    roles?: Role[],
    inscriptions?: Inscription[],
    tournois?: Tournoi[]
  ) {
    this._id = id;
    this._username = username;
    this._mail = mail;
    this._password = password;
    this._roles = roles;
    this._inscriptions = inscriptions;
    this._tournois = tournois;
  }

  /**
   * Getter inscriptions
   * @return {Inscription[] }
   */
  public get inscriptions(): Inscription[] | undefined {
    return this._inscriptions;
  }

  /**
   * Setter inscriptions
   * @param {Inscription[] } value
   */
  public set inscriptions(value: Inscription[] | undefined) {
    this._inscriptions = value;
  }

  /**
   * Getter tournois
   * @return {Tournoi[] }
   */
  public get tournois(): Tournoi[] | undefined {
    return this._tournois;
  }

  /**
   * Setter tournois
   * @param {Tournoi[] } value
   */
  public set tournois(value: Tournoi[] | undefined) {
    this._tournois = value;
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
  /**
   * Getter username
   * @return {string }
   */
  public get username(): string | undefined {
    return this._username;
  }

  /**
   * Setter username
   * @param {string } value
   */
  public set username(value: string | undefined) {
    this._username = value;
  }

  /**
   * Getter mail
   * @return {string }
   */
  public get mail(): string | undefined {
    return this._mail;
  }

  /**
   * Setter mail
   * @param {string } value
   */
  public set mail(value: string | undefined) {
    this._mail = value;
  }

  /**
   * Getter password
   * @return {string }
   */
  public get password(): string | undefined {
    return this._password;
  }

  /**
   * Setter password
   * @param {string } value
   */
  public set password(value: string | undefined) {
    this._password = value;
  }

  /**
   * Getter roles
   * @return {Role }
   */
  public get roles(): Role[] | undefined {
    return this._roles;
  }

  /**
   * Setter roles
   * @param {Role } value
   */
  public set roles(value: Role[] | undefined) {
    this._roles = value;
  }
}
