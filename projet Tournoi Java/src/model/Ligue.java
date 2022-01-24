package model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Ligue extends Tournoi {

	/// ATTRIBUTES
	
	private boolean isPoule ; 
	private LinkedList<Journee> journees = new LinkedList() ; 
	
	
	/// CONSTRUCTOR
	
	public Ligue(String nom, LocalDate dateDeCreation, LocalDate dateDeDebut, String jeu,
			LinkedList<Joueur> listeJoueurs, boolean isPoule, LinkedList<Journee> journees) {
		
		super(nom, dateDeCreation, dateDeDebut, jeu, listeJoueurs);
		this.isPoule = isPoule;
		this.journees = journees;
	}

	/// GETTERS
	
	public boolean isPoule() {
		return isPoule;
	}

	
	/// SETTERS
	
	public void setPoule(boolean isPoule) {
		this.isPoule = isPoule;
	}
	
	/// METHODS
	
	private void setScoreFinal()
	{
		
	}
	
	
}
