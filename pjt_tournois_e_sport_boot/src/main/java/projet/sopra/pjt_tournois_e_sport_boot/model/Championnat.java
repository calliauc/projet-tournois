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

@Entity
@Table(name = "championnat")
public class Championnat extends Tournoi {

	/// ATTRIBUTES
	@OneToMany(mappedBy = "tournoi")
	private Set<Journee> JourneesAJouerPoules;
//	@OneToMany(mappedBy="id")
//	private Set<Journee> JourneesAJouerFinales;
	private Set<Poule> poules = new HashSet<Poule>();

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
	public void splitInPool() {
		int nb_players = this.listeInscriptions.size();
		if (nb_players < 6) {
			System.out.println("Pas assez de joueurs, passez en ligue ?");
		} else if (nb_players < 12) {
			createTwoPool();
			System.out.println(nb_players + " joueurs : 2 poules \nLes 2 premiers de chaque poule en demi-finales");
		} else if (nb_players < 24) {
			createFourPool();
			System.out
					.println(nb_players + " joueurs : 4 poules \nLes 2 premiers de chaque poule en quarts de finales");
		} else if (nb_players <= 48) {
			createEightPool();
			System.out.println(
					nb_players + " joueurs : 8 poules \nLes 2 premiers de chaque poule en huiti�me de finales");
		} else {
			System.out.println("Trop de joueurs");
		}
//		displayFinalScores();
	}
	

	
	private void createTwoPool() {
		List<Inscription> players = new ArrayList<Inscription>(this.listeInscriptions);
		Collections.shuffle(players);

		Set<Inscription> tempA = Set.copyOf(players.subList(0 * players.size() / 2, 1 * players.size() / 2));
		Set<Inscription> tempB = Set.copyOf(players.subList(1 * players.size() / 2, 2 * players.size() / 2));

		Poule poolA = new Poule("PoolA", LocalDate.now(), jeu, tempA, true, nbParticipantsParMatch, this);
		Poule poolB = new Poule("PoolB", LocalDate.now(), jeu, tempB, true, nbParticipantsParMatch, this);

		Collections.addAll(poules, poolA, poolB);
	}

	private void createFourPool() {
		List<Inscription> players = new ArrayList<Inscription>(this.listeInscriptions);
		Collections.shuffle(players);

		Set<Inscription> tempA = Set.copyOf(players.subList(0 * players.size() / 4, 1 * players.size() / 4));
		Set<Inscription> tempB = Set.copyOf(players.subList(1 * players.size() / 4, 2 * players.size() / 4));
		Set<Inscription> tempC = Set.copyOf(players.subList(2 * players.size() / 4, 3 * players.size() / 4));
		Set<Inscription> tempD = Set.copyOf(players.subList(3 * players.size() / 4, 4 * players.size() / 4));

		Poule poolA = new Poule("PoolA", LocalDate.now(), jeu, tempA, true, nbParticipantsParMatch, this);
		Poule poolB = new Poule("PoolB", LocalDate.now(), jeu, tempB, true, nbParticipantsParMatch, this);
		Poule poolC = new Poule("PoolC", LocalDate.now(), jeu, tempC, true, nbParticipantsParMatch, this);
		Poule poolD = new Poule("PoolD", LocalDate.now(), jeu, tempD, true, nbParticipantsParMatch, this);

		Collections.addAll(poules, poolA, poolB, poolC, poolD);
	}

	private void createEightPool() {
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

		Poule poolA = new Poule("PoolA", LocalDate.now(), jeu, tempA, true, nbParticipantsParMatch, this);
		Poule poolB = new Poule("PoolB", LocalDate.now(), jeu, tempB, true, nbParticipantsParMatch, this);
		Poule poolC = new Poule("PoolC", LocalDate.now(), jeu, tempC, true, nbParticipantsParMatch, this);
		Poule poolD = new Poule("PoolD", LocalDate.now(), jeu, tempD, true, nbParticipantsParMatch, this);
		Poule poolE = new Poule("PoolE", LocalDate.now(), jeu, tempE, true, nbParticipantsParMatch, this);
		Poule poolF = new Poule("PoolF", LocalDate.now(), jeu, tempF, true, nbParticipantsParMatch, this);
		Poule poolG = new Poule("PoolG", LocalDate.now(), jeu, tempG, true, nbParticipantsParMatch, this);
		Poule poolH = new Poule("PoolH", LocalDate.now(), jeu, tempH, true, nbParticipantsParMatch, this);

		Collections.addAll(poules, poolA, poolB, poolC, poolD, poolE, poolF, poolG, poolH);

	}

	
}
