package pjt_tournois_e_sport.model;

public class Classement {
	
	/// ATTRIBUTES
	
	private int idCompte ; 
	public int idTournoi ; 
	private int position ; 
	private int score ;
	
	
	/// CONSTRUCTOR
	
	public Classement( int idTournoi, int position, int score) {
		this.idTournoi = idTournoi;
		this.position = position;
		this.score = score;
	}

	/// GETTERS
	
	public int getIdCompte() {
		return idCompte;
	}

	public int getIdTournoi() {
		return idTournoi;
	}

	public int getPosition() {
		return position;
	}

	public int getScore() {
		return score;
	}

	/// SETTERS
	
	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public void setIdTournoi(int idTournoi) {
		this.idTournoi = idTournoi;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void setScore(int score) {
		this.score = score;
	} 
	
	

}
