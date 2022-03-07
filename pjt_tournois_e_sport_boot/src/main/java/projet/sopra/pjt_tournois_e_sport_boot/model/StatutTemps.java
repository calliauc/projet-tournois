package projet.sopra.pjt_tournois_e_sport_boot.model;

public enum StatutTemps {
	
	A_venir("A venir"), En_cours("En cours"), Termine("Terminé") ; 
	
	private String etiquette;

	private StatutTemps(String etiquette) {
		this.etiquette = etiquette;
	}

	public String getEtiquette() {
		return etiquette;
	}

}
