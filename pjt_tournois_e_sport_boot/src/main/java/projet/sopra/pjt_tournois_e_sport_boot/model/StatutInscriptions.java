package projet.sopra.pjt_tournois_e_sport_boot.model;

public enum StatutInscriptions {
	Inscription_En_Cours("Inscriptions en cours"), Inscriptions_Terminées("Inscriptions terminées");
	
	private String etiquette;

	private StatutInscriptions(String etiquette) {
		this.etiquette = etiquette;
	}

	public String getEtiquette() {
		return etiquette;
	}
}
