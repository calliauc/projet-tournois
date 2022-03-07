package projet.sopra.pjt_tournois_e_sport_boot.model;

public enum Etape {

	Ligue(0), Poule(0), Huitieme(8), Quart(4), Demi(2), Finale(1){
        @Override
        public Etape next() {
            // Renvoie null car il n'y a rien après la finale
            return null;
        };
    };

	private int nbMatches;

	Etape(int nbMatches) {
		this.nbMatches = nbMatches;
	}

	public int getNbMatches() {
		return this.nbMatches;
	}

	public Etape next() {
		// Permet de passer, automatiquement à l'étape suivante pour les phases finales
		return values()[ordinal() + 1];
	}
}
