package projet.sopra.pjt_tournois_e_sport_boot.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "championnat")
public class Championnat extends Tournoi {

	/// ATTRIBUTES
	@OneToMany(mappedBy = "tournoi")
	private Set<Journee> JourneesAJouerPoules;
	@OneToMany(mappedBy="id")
	private Set<Journee> JourneesAJouerFinales;
	@Transient
	private Set<Poule> poules = new HashSet<Poule>();

	/*
	 * TODO gestion classement
	 */
	
	/// CONSTRUCTORS

	public Championnat() {

	}

	public Championnat(String nom, LocalDate dateDeDebut, String jeu, Set<Inscription> listeInscriptions) {
		super(nom, dateDeDebut, jeu, listeInscriptions);

	}

	/// GETTERS

	/// SETTERS

	/// GESTION POULES

	
	/*	CREATION POULES
	 * S'il y avait un nombre infini de participation j'aurais cherché un moyen d'automatiser mieux tout ça, mais pas la peine pour 8 poules max
	 */
	public void splitInPoule() {
		int nb_players = this.listeInscriptions.size();
		if (nb_players < 6) {
			System.out.println("Pas assez de joueurs, passez en ligue ?");
		} else if (nb_players < 12) {
			createTwoPoule();
			System.out.println(nb_players + " joueurs : 2 poules \nLes 2 premiers de chaque poule en demi-finales");
		} else if (nb_players < 24) {
			createFourPoule();
			System.out
					.println(nb_players + " joueurs : 4 poules \nLes 2 premiers de chaque poule en quarts de finales");
		} else if (nb_players <= 48) {
			createEightPoule();
			System.out.println(
					nb_players + " joueurs : 8 poules \nLes 2 premiers de chaque poule en huiti�me de finales");
		} else {
			System.out.println("Trop de joueurs");
		}
//		displayFinalScores();
	}
	

	
	private void createTwoPoule() {
		List<Inscription> players = new ArrayList<Inscription>(this.listeInscriptions);
		Collections.shuffle(players);

		Set<Inscription> tempA = Set.copyOf(players.subList(0 * players.size() / 2, 1 * players.size() / 2));
		Set<Inscription> tempB = Set.copyOf(players.subList(1 * players.size() / 2, 2 * players.size() / 2));

		Poule pouleA = new Poule("PouleA", LocalDate.now(), jeu, tempA, true, nbParticipantsParMatch, this);
		Poule pouleB = new Poule("PouleB", LocalDate.now(), jeu, tempB, true, nbParticipantsParMatch, this);

		Collections.addAll(poules, pouleA, pouleB);
	}

	private void createFourPoule() {
		List<Inscription> players = new ArrayList<Inscription>(this.listeInscriptions);
		Collections.shuffle(players);

		Set<Inscription> tempA = Set.copyOf(players.subList(0 * players.size() / 4, 1 * players.size() / 4));
		Set<Inscription> tempB = Set.copyOf(players.subList(1 * players.size() / 4, 2 * players.size() / 4));
		Set<Inscription> tempC = Set.copyOf(players.subList(2 * players.size() / 4, 3 * players.size() / 4));
		Set<Inscription> tempD = Set.copyOf(players.subList(3 * players.size() / 4, 4 * players.size() / 4));

		Poule pouleA = new Poule("PouleA", LocalDate.now(), jeu, tempA, true, nbParticipantsParMatch, this);
		Poule pouleB = new Poule("PouleB", LocalDate.now(), jeu, tempB, true, nbParticipantsParMatch, this);
		Poule pouleC = new Poule("PouleC", LocalDate.now(), jeu, tempC, true, nbParticipantsParMatch, this);
		Poule pouleD = new Poule("PouleD", LocalDate.now(), jeu, tempD, true, nbParticipantsParMatch, this);

		Collections.addAll(poules, pouleA, pouleB, pouleC, pouleD);
	}

	private void createEightPoule() {
		List<Inscription> players = new ArrayList<Inscription>(this.listeInscriptions);
		Collections.shuffle(players);

		Set<Inscription> tempA = Set.copyOf(players.subList(0 * players.size() / 8, 1 * players.size() / 8));
		Set<Inscription> tempB = Set.copyOf(players.subList(1 * players.size() / 8, 2 * players.size() / 8));
		Set<Inscription> tempC = Set.copyOf(players.subList(2 * players.size() / 8, 3 * players.size() / 8));
		Set<Inscription> tempD = Set.copyOf(players.subList(3 * players.size() / 8, 4 * players.size() / 8));
		Set<Inscription> tempE = Set.copyOf(players.subList(4 * players.size() / 8, 5 * players.size() / 8));
		Set<Inscription> tempF = Set.copyOf(players.subList(5 * players.size() / 8, 6 * players.size() / 8));
		Set<Inscription> tempG = Set.copyOf(players.subList(6 * players.size() / 8, 7 * players.size() / 8));
		Set<Inscription> tempH = Set.copyOf(players.subList(7 * players.size() / 8, 8 * players.size() / 8));

		Poule pouleA = new Poule("PouleA", LocalDate.now(), jeu, tempA, true, nbParticipantsParMatch, this);
		Poule pouleB = new Poule("PouleB", LocalDate.now(), jeu, tempB, true, nbParticipantsParMatch, this);
		Poule pouleC = new Poule("PouleC", LocalDate.now(), jeu, tempC, true, nbParticipantsParMatch, this);
		Poule pouleD = new Poule("PouleD", LocalDate.now(), jeu, tempD, true, nbParticipantsParMatch, this);
		Poule pouleE = new Poule("PouleE", LocalDate.now(), jeu, tempE, true, nbParticipantsParMatch, this);
		Poule pouleF = new Poule("PouleF", LocalDate.now(), jeu, tempF, true, nbParticipantsParMatch, this);
		Poule pouleG = new Poule("PouleG", LocalDate.now(), jeu, tempG, true, nbParticipantsParMatch, this);
		Poule pouleH = new Poule("PouleH", LocalDate.now(), jeu, tempH, true, nbParticipantsParMatch, this);

		Collections.addAll(poules, pouleA, pouleB, pouleC, pouleD, pouleE, pouleF, pouleG, pouleH);

	}

	
}