//code pour le test de resultat, match avec seulement un id!!!!
//reste à faire tous les autres attributs, etc!!!!!

export class Match {
  private _id: number | undefined;

  constructor(id?: number) {
    this._id = id;
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
}
