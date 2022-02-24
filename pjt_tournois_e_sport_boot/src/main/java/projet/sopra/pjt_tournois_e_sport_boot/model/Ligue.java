package projet.sopra.pjt_tournois_e_sport_boot.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
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
	protected boolean isPoule;
	@Column(name = "nbPhase")
	protected int nbPhase;
	@OneToMany(mappedBy = "tournoi")
	protected Set<Journee> JourneesAJouer;

	/*
	 * TODO gestion classement
	 */


	/// CONSTRUCTORS

	public Ligue() {

	}

	public Ligue(String nom, LocalDate dateDeDebut, String jeu, Set<Inscription> listeInscriptions, boolean isPoule,
			int nbPhase) {
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

	//// METHODS

	/// Affichage

	public void displayLigue() {
		System.out.println("Ligue " + this.idTournoi + " (" + this.listeInscriptions.size() + " players) :");
		for (Inscription i : this.listeInscriptions) {
			System.out.println(i);
		}
	}

//	public Set<Journee> generateJourneesLigueDuels() {
//
//		////// TO DO INCLURE LES DATES DE DEBUT/FIN DES MATCHS ET JOURNEES
//
//		Set<Journee> journees = new HashSet<Journee>();
//		LinkedList<Inscription> inscriptionsLigue = new LinkedList<Inscription>(listeInscriptions);
//		int isPair = (listeInscriptions.size() + 1) % 2;
//
//		for (int i = 0; i < inscriptionsLigue.size() - isPair; i++) {
//			Journee jour = new Journee();
//			jour.setEtape(Etape.Ligue);
//			Set<Match> matchsJournee = new HashSet<Match>();
//			for (int j = 0; j < listeInscriptions.size() / 2; j++) {
//				Match m = new Match();
//				m.getInscriptions().add(inscriptionsLigue.get(j));
//				m.getInscriptions().add(inscriptionsLigue.get(inscriptionsLigue.size() / 2 - (j + 1)));
//				matchsJournee.add(m);
//			}
//			if (isPair != 1) {
//				System.out.println("Solo : " + inscriptionsLigue.get(inscriptionsLigue.size() / 2));
//			}
//			jour.setMatchsAJouerPourJournee(matchsJournee);
//			journees.add(jour);
//
//			inscriptionsLigue.add(isPair, inscriptionsLigue.pollLast());
//		}
//		System.out.println(journees.toString());
//		return journees;
//	}

	public void initMatchs() {

	}

	public Set<Journee> generateJourneesLigueMelee() {
		//// METHODE PAS HYPER UTILE MAIS A FINIR POUR LE FUN
		Set<Journee> journees = new HashSet<Journee>();

		for (int i = 0; i < listeInscriptions.size() - 1; i++) {

			Set<Match> matchsJournee = new HashSet<Match>();
			for (int j = 0; j < listeInscriptions.size() / nbParticipantsParMatch; j++) {
				Match m = new Match();

				/// on cree une copie de listeInscription pour la manipuler et la tordre
				List<Inscription> inscriptionsLigue = new ArrayList<Inscription>(listeInscriptions);
				while (checkIfMatchUnique(m, journees) == false) {
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

	}

	public boolean checkIfMatchUnique(Match m, Set<Journee> journees) {

		for (Journee j : journees) {
			for (Match mPrevu : j.getMatchsAJouerPourJournee()) {
				if (m.getInscriptions().containsAll(mPrevu.getInscriptions())) {
					return false;
				}

			}
		}

		return true;
	}

}
