package projet.sopra.pjt_tournois_e_sport_boot.dto;

public class InscriptionKeyDto {
	private Long idJoueur;
	private Long idTournoi;
	
	public InscriptionKeyDto() {
	}

	public InscriptionKeyDto(Long idJoueur, Long idTournoi) {
		super();
		this.idJoueur = idJoueur;
		this.idTournoi = idTournoi;
	}

	public Long getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(Long idJoueur) {
		this.idJoueur = idJoueur;
	}

	public Long getIdTournoi() {
		return idTournoi;
	}

	public void setIdTournoi(Long idTournoi) {
		this.idTournoi = idTournoi;
	}
	
	
	
}
