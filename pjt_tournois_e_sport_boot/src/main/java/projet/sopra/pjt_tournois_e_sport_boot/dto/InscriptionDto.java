package projet.sopra.pjt_tournois_e_sport_boot.dto;

import projet.sopra.pjt_tournois_e_sport_boot.model.Match;

public class InscriptionDto {

	private InscriptionKeyDto id;
	private int position;
	private int score;
	private int scoreDifference; 
	private Match prochainMatch;
	
	public InscriptionDto() {
	}

	public InscriptionDto(InscriptionKeyDto id, int position, int score, int scoreDifference, Match prochainMatch) {
		super();
		this.id = id;
		this.position = position;
		this.score = score;
		this.scoreDifference = scoreDifference;
		this.prochainMatch = prochainMatch;
	}

	public InscriptionKeyDto getId() {
		return id;
	}

	public void setId(InscriptionKeyDto id) {
		this.id = id;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Match getProchainMatch() {
		return prochainMatch;
	}

	public void setProchainMatch(Match prochainMatch) {
		this.prochainMatch = prochainMatch;
	}

	public int getScoreDifference() {
		return scoreDifference;
	}

	public void setScoreDifference(int scoreDifference) {
		this.scoreDifference = scoreDifference;
	}
	
	

}
