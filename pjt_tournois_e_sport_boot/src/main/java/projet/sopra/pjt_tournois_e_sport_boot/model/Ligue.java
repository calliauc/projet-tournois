package projet.sopra.pjt_tournois_e_sport_boot.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ligue")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Ligue extends Tournoi {

	/// ATTRIBUTES

	@Column(name = "isPoule")
	private boolean isPoule;
	@Column(name = "nbPhase")
	private int nbPhase;
	@OneToMany(mappedBy = "tournoi")
	private Set<Journee> JourneesAJouer;

	/// CONSTRUCTORS

	public Ligue() {

	}
<<<<<<< Updated upstream
	

	
	public Ligue(String nom, LocalDate dateDeDebut, String jeu,
=======

	public Ligue(String nom, LocalDate dateDeCreation, LocalDate dateDeDebut, String jeu,
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
	/// Affichage
	
	public void displayLigue() {
		System.out.println("Ligue " + this.idTournoi + " (" + this.listeInscriptions.size() + " players) :");
		for (Inscription i: this.listeInscriptions) {
			System.out.println(i);
		}

=======
	//// METHODS

	public Set<Journee> generateJourneesLigue2PPM() {
		Set<Journee> journees = new HashSet<Journee>();
		for (int i = 0; i < listeInscriptions.size() - 1; i++) {

			Set<Match> matchsJournee = new HashSet<Match>();
			for (int j = 0; j < listeInscriptions.size() / nbParticipantsParMatch; j++) {
				Match m = new Match();
				for (int k = 0; k < nbParticipantsParMatch - 1; k++) {

				}
			}
		}
//		for (int i=0 ; i < participants.size()-1 ;  i++)
//		{
//			LinkedList<Match> liste_Match = new LinkedList() ;
//			for(int j=0 ; j < participants.size()/2; j++)
//			{
//				Match m = new Match(participants.get(j).getIdCompte() , participants.get(j+participants.size()/2).getIdCompte(), i, idTournoi ) ;
//				liste_Match.add(m);
//			}
//			
//			Journee j = new Journee(i, idTournoi, liste_Match) ;
//			matchs_ligue.add(j);
//			
//			participants.add(1,participants.pollLast() ); 
//			System.out.println(participants);
//		}
//		System.out.println(matchs_ligue);
		return journees;
	}

	public Set<Journee> generateJourneesLigueMorePPM() {
				
		Set<Journee> journees = new HashSet<Journee>();
		
		for (int i = 0; i < listeInscriptions.size() - 1; i++) {

			Set<Match> matchsJournee = new HashSet<Match>();
			for (int j = 0; j < listeInscriptions.size() / nbParticipantsParMatch; j++) {
				Match m = new Match();
				
				/// on cree une copie de listeInscription pour la manipuler et la tordre
				List<Inscription> inscriptionsLigue = new ArrayList<Inscription>(listeInscriptions);
				while (checkIfMatchUnique(m, journees)==false) {
					for (int k = 0; k < nbParticipantsParMatch - 1; k++) {
						
							//// on prend des nombres au hasard dans les inscriptions
							int rand = new Random().nextInt(inscriptionsLigue.size() - k);
							m.getInscriptions().add(inscriptionsLigue.get(rand)); 
							inscriptionsLigue.remove(rand);
					}
					
				}

			}
		}
		return journees;
>>>>>>> Stashed changes
	}
	
	public boolean checkIfMatchUnique(Match m, Set<Journee> journees) {
		
		for (Journee j : journees) {
			for( Match mPrevu : j.getMatchsAJouerPourJournee() ) {
				if (m.getInscriptions().containsAll(mPrevu.getInscriptions())) {
					return false; 
				}
				
			}
		}
	
		
		return true;
	}

}
