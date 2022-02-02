package pjt_tournois_e_sport.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tournoi {

	/// ATTRIBUTES
	
	protected int idTournoi ; 
	protected String nom; 
	protected LocalDate dateDeCreation ; 
	protected LocalDate dateDeDebut ; 
	protected String Jeu ; 
	protected LinkedList<Joueur> listeJoueurs = new LinkedList() ; 
	protected int nbJoueurs ; 
	protected List<Tournoi> listeTournois = new ArrayList();
	
	/// CONSTRUCTOR
	
	public Tournoi(String nom, LocalDate dateDeCreation, LocalDate dateDeDebut, String jeu, LinkedList<Joueur> listeJoueurs) {
		
		listeTournois.add(this); 
		this.idTournoi = listeTournois.size() ; 
		this.nom = nom;
		this.dateDeDebut = dateDeDebut;
		this.dateDeCreation = dateDeCreation; 
		this.Jeu = jeu;
		this.listeJoueurs = listeJoueurs;
		this.nbJoueurs = listeJoueurs.size(); 
	}

	/// GETTERS
	
	public int getIdTournoi() {
		return idTournoi;
	}

	public String getNom() {
		return nom;
	}

	public int getNbJoueurs() {
		return nbJoueurs;
	}

	public LocalDate getDateDeCreation() {
		return dateDeCreation;
	}

	public LocalDate getDateDeDebut() {
		return dateDeDebut;
	}

	public String getJeu() {
		return Jeu;
	}

	public LinkedList<Joueur> getListeJoueurs() {
		return listeJoueurs;
	}

	public List<Tournoi> getListeTournois() {
		return listeTournois;
	}

	
	/// SETTERS
	
	public void setIdTournoi(int idTournoi) {
		this.idTournoi = idTournoi;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setNbJoueurs(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}

	public void setDateDeCreation(LocalDate dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public void setDateDeDebut(LocalDate dateDeDebut) {
		this.dateDeDebut = dateDeDebut;
	}

	public void setJeu(String jeu) {
		Jeu = jeu;
	}

	public void setListeJoueurs(LinkedList<Joueur> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}

	public void setListeTournois(List<Tournoi> listeTournois) {
		this.listeTournois = listeTournois;
	} 
	
	
	
	
}
