package pjt_tournois_e_sport.model;

import java.util.LinkedList;
import pjt_tournois_e_sport.model.Match;


public class Journee {
	
	/// ATTRIBUTES
	
	protected int idJournée ; 
	protected int idTournoi ; 
	protected LinkedList<Match> matchs_journee = new LinkedList() ;
	
	/// CONSTRUCTOR

	public Journee(int idJournée, int idTournoi, LinkedList<Match> matchs_journee) {
		this.idJournée = idJournée;
		this.idTournoi = idTournoi;
		this.matchs_journee = matchs_journee;
	}

	/// GETTERS

	public int getIdJournée() {
		return idJournée;
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

	public void setIdJournée(int idJournée) {
			this.idJournée = idJournée;
	}


	public void setMatchs_journee(LinkedList<Match> matchs_journee) {
		this.matchs_journee = matchs_journee;
	}

	

	/// METHODS
	
	@Override
	public String toString() {
		return "Journee [idJournée=" + idJournée + ", idTournoi=" + idTournoi + ", matchs_journee=" + matchs_journee
				+ "]";
	}













	
	
}
