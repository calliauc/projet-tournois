package projet.sopra.pjt_tournois_e_sport_boot.model;

public enum Etape {

	Ligue(0, 0), Poule(0, 0), Huitieme(8, 0), Quart(4, 1), Demi(2, 2), Finale(1, 3){
        @Override
        public Etape next() {
            // Renvoie null car il n'y a rien après la finale
            return null;
        };
    };

	private int nbMatches;
	private int index;

	Etape(int nbMatches, int index) {
	}

	public int getNbMatches() {
		return this.nbMatches;
	}

	public int getIndex() {
		return this.index;
	}

	public Etape next() {
		// Permet de passer, automatiquement à l'étape suivante pour les phases finales
		return values()[ordinal() + 1];
	}
}
