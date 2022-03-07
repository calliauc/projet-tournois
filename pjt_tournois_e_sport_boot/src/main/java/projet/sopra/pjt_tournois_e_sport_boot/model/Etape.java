package projet.sopra.pjt_tournois_e_sport_boot.model;

public enum Etape {
	
	Finale(1), Demi(2), Quart(4), Huitieme(8), Poule(0), Ligue(0);

	private int nbMatches;
	
	Etape(int nbMatches) {
		this.nbMatches = nbMatches;
	} 

	public int getNbMatches() {
		return this.nbMatches;
	}
}
