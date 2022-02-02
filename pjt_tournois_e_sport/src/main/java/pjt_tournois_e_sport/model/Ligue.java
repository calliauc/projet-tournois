package pjt_tournois_e_sport.model;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="ligue")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Ligue extends Tournoi {

	/// ATTRIBUTES
	
	@Column(name = "isPoule")
	private boolean isPoule ; 
	@Column(name = "nbPhase")
	private int nbPhase;
	@Column(name = "matchsAJouerPourPhase")
	private Set<Match> matchsAJouerPourPhase = new HashSet(); 
	
	
	/// CONSTRUCTORS
	
	public Ligue() {

	}
	
	public Ligue(String nom, LocalDate dateDeCreation, LocalDate dateDeDebut, String jeu,
			Set<Inscription> listeInscriptions, boolean isPoule, int nbPhase, Set<Match> matchsAJouerPourPhase) {
		super(nom, dateDeCreation, dateDeDebut, jeu, listeInscriptions);
		this.isPoule = isPoule;
		this.nbPhase = nbPhase;
		this.matchsAJouerPourPhase = matchsAJouerPourPhase;
	}

	
	/// GETTERS
	
	public boolean isPoule() {
		return isPoule;
	}

	public int getNbPhase() {
		return nbPhase;
	}

	public Set<Match> getMatchsAJouerPourPhase() {
		return matchsAJouerPourPhase;
	}

	
	/// SETTERS
	
	public void setPoule(boolean isPoule) {
		this.isPoule = isPoule;
	}

	public void setNbPhase(int nbPhase) {
		this.nbPhase = nbPhase;
	}
	
	public void setMatchsAJouerPourPhase(Set<Match> matchsAJouerPourPhase) {
		this.matchsAJouerPourPhase = matchsAJouerPourPhase;
	}


	
}
