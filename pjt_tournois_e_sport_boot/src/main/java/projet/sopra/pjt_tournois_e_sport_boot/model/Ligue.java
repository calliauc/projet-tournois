package projet.sopra.pjt_tournois_e_sport_boot.model;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
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
	@OneToMany(mappedBy="tournoi")
	private Set<Journee> JourneesAJouer; 
	

	
	
	/// CONSTRUCTORS
	
	public Ligue() {

	}
	
	public Ligue(String nom, LocalDate dateDeCreation, LocalDate dateDeDebut, String jeu,
			Set<Inscription> listeInscriptions, boolean isPoule, int nbPhase) {
		super(nom, dateDeCreation, dateDeDebut, jeu, listeInscriptions);
		this.isPoule = isPoule;
		this.nbPhase = nbPhase;
	}

	
	/// GETTERS
	
	public boolean isPoule() {
		return isPoule;
	}

	public int getNbPhase() {
		return nbPhase;
	}

	
	
	/// SETTERS
	
	public void setPoule(boolean isPoule) {
		this.isPoule = isPoule;
	}

	public void setNbPhase(int nbPhase) {
		this.nbPhase = nbPhase;
	}

	
}
