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
	

	
	public Ligue(String nom, LocalDate dateDeDebut, String jeu,
			Set<Inscription> listeInscriptions, boolean isPoule, int nbPhase) {
		super(nom, dateDeDebut, jeu, listeInscriptions);
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

	/// Affichage
	
	public void displayLigue() {
		System.out.println("Ligue " + this.idTournoi + " (" + this.listeInscriptions.size() + " players) :");
		for (Inscription i: this.listeInscriptions) {
			System.out.println(i);
		}

	}
	
	
	/// Creation match de pools
	
	// @formatter:off
	/*
	 * Génération des matches de poule (opti sans doublon)
	 * 
	 * Pour une pool de 3 joueurs :
	 * J1 : A/B, C repos
	 * J2 : A/C, B repos
	 * J3 : B/C, A repos
	 * 
	 * 
	 * Pour une pool de 4 joueurs :
	 * J1 : A/B, C/D
	 * J2 : A/C, B/D
	 * J3 : A/D, B/C
	 * 
	 * 
	 * Pour une pool de 5 joueurs :
	 * J1 : A/B, C/D, E repos
	 * J2 : A/C, B/E, D repos
	 * J3 : A/D, C/E, B repos
	 * J4 : A/E, B/D, C repos
	 * J5 : B/C, D/E, A repos
	 * 
	 * 
	 * Pour une pool de 6 joueurs :
	 * J1 : A/B, C/D, E/F
	 * J2 : A/C, B/F, D/E
	 * J3 : A/D, B/E, C/F
	 * J4 : A/E, B/C, D/F
	 * J5 : A/F, B/D, C/E
	 */
	// @formatter:on
	
	public void initMatchs() {
		
	}
	
	
}
