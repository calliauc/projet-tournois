package pjt_tournois_e_sport.model;

import java.util.LinkedList;
import pjt_tournois_e_sport.model.Match;


public class Journee {
	
	/// ATTRIBUTES
	
	protected int idJourn�e ; 
	protected int idTournoi ; 
	protected LinkedList<Match> matchs_journee = new LinkedList() ;
	
	/// CONSTRUCTOR

	public Journee(int idJourn�e, int idTournoi, LinkedList<Match> matchs_journee) {
		this.idJourn�e = idJourn�e;
		this.idTournoi = idTournoi;
		this.matchs_journee = matchs_journee;
	}

	/// GETTERS

	public int getIdJourn�e() {
		return idJourn�e;
	}

	public LinkedList<Match> getMatchs_journee() {
		return matchs_journee;
	}


	public int getIdTournoi() {
		return idTournoi;
	}


	/// SETTERS

	public void setIdTournoi(int idTournoi) {
		this.idTournoi = idTournoi;
	}

	public void setIdJourn�e(int idJourn�e) {
			this.idJourn�e = idJourn�e;
	}


	public void setMatchs_journee(LinkedList<Match> matchs_journee) {
		this.matchs_journee = matchs_journee;
	}

	

	/// METHODS
	
	@Override
	public String toString() {
		return "Journee [idJourn�e=" + idJourn�e + ", idTournoi=" + idTournoi + ", matchs_journee=" + matchs_journee
				+ "]";
	}













	
	
}
