package projet.sopra.pjt_tournois_e_sport_boot.dto;

import java.util.List;

import projet.sopra.pjt_tournois_e_sport_boot.model.Journee;

public class MatchDto {
	private Long id;
	private List<InscriptionDto> inscriptions;
	private Journee journee;
	
	public MatchDto() {
	}

	public MatchDto(Long id, List<InscriptionDto> inscriptions, Journee journee) {
		super();
		this.id = id;
		this.inscriptions = inscriptions;
		this.journee = journee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<InscriptionDto> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(List<InscriptionDto> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public Journee getJournee() {
		return journee;
	}

	public void setJournee(Journee journee) {
		this.journee = journee;
	}

	
	

}
