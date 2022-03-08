import { Role } from './role';
export class Utilisateur {
  private _id: number | undefined;
  private _username: string | undefined;
  private _mail: string | undefined;
  private _password: string | undefined;
  private _roles: Role | undefined;

  constructor(
    id?: number,
    username?: string,
    mail?: string,
    password?: string,
    roles?: Role
  ) {
    this._id = id;
    this._username = username;
    this._mail = mail;
    this._password = password;
    this._roles = roles;
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
  public get roles(): Role | undefined {
    return this._roles;
  }

  /**
   * Setter roles
   * @param {Role } value
   */
  public set roles(value: Role | undefined) {
    this._roles = value;
  }
}
