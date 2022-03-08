package projet.sopra.pjt_tournois_e_sport_boot.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.sopra.pjt_tournois_e_sport_boot.model.Championnat;
import projet.sopra.pjt_tournois_e_sport_boot.model.Etape;
import projet.sopra.pjt_tournois_e_sport_boot.model.Inscription;
import projet.sopra.pjt_tournois_e_sport_boot.model.Journee;
import projet.sopra.pjt_tournois_e_sport_boot.model.Ligue;
import projet.sopra.pjt_tournois_e_sport_boot.model.Match;
import projet.sopra.pjt_tournois_e_sport_boot.model.Poule;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.InscriptionRepository;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.JourneeRepository;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.MatchRepository;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.TournoiRepository;

@Service
public class MatchGenerationService {

	@Autowired
	private TournoiRepository tournoiRepo;
	@Autowired
	private MatchRepository matchRepo;
	@Autowired
	private JourneeRepository journeeRepo;

	@Autowired
	private MatchService matchService;
	@Autowired
	private InscriptionRepository inscriptionRepo;

	/// GESTION LIGUE

	public void generateJourneesLigueDuels(Ligue ligue) {

		////// TO DO : INCLURE LES DATES DE DEBUT/FIN DES MATCHS ET JOURNEES
		int matchRetour;
		if (ligue.isMatchRetour() == true) {
			matchRetour = 2;
		} else {
			matchRetour = 1;
		}
		Set<Journee> journees = new HashSet<Journee>();
		LinkedList<Inscription> inscriptionsLigue = new LinkedList<Inscription>(ligue.getListeInscriptions());
		System.out.println("inscriptions : " + inscriptionsLigue.toString());
		int isPair = (ligue.getListeInscriptions().size() + 1) % 2;

		for (int i = 0; i < (inscriptionsLigue.size() - isPair) * matchRetour; i++) {
			Journee jour = new Journee();
			jour.setTournoi(ligue);
			jour.setEtape(Etape.Ligue);
			jour.setNumero(i + 1);
			journeeRepo.save(jour);
			List<Match> matchsJournee = new ArrayList<Match>();
			for (int j = 0; j < ligue.getListeInscriptions().size() / 2; j++) {
				System.out.println("Match : " + j);
				Match m = new Match();
				m.setJournee(jour);
				m.getInscriptions().add(inscriptionsLigue.get(j));
				m.getInscriptions().add(inscriptionsLigue.get(inscriptionsLigue.size() - (j + 1)));
				for (Inscription x : m.getInscriptions()) {

					System.out.println(x.getId().getJoueur().getId());
				}
				matchsJournee.add(m);
				matchRepo.save(m);
			}
			if (isPair != 1) {
				System.out.println("Solo : " + inscriptionsLigue.get(inscriptionsLigue.size() / 2));
			}
			jour.setMatchsAJouerPourJournee(matchsJournee);
			journeeRepo.save(jour);
			journees.add(jour);
			inscriptionsLigue.add(isPair, inscriptionsLigue.pollLast());
		}
		ligue.setJourneesAJouer(journees);
		matchService.setAllProchainMatch(ligue.getIdTournoi());
		tournoiRepo.save(ligue);
	}

	/// GESTION POULES

	/*
	 * CREATION POULES S'il y avait un nombre infini de participation j'aurais
	 * cherché un moyen d'automatiser mieux tout ça, mais pas la peine pour 8 poules
	 * max
	 */
	public void splitInPoule(Championnat champ) {
		int nb_players = champ.getListeInscriptions().size();
		if (nb_players < 6) {
			System.out.println("Pas assez de joueurs, passez en ligue ?");
		} else if (nb_players < 12) {
			createTwoPoule(champ);
			champ.setProchaineEtape(Etape.Demi);
			System.out.println(nb_players + " joueurs : 2 poules \nLes 2 premiers de chaque poule en demi-finales");
		} else if (nb_players < 24) {
			createFourPoule(champ);
			champ.setProchaineEtape(Etape.Quart);
			System.out
					.println(nb_players + " joueurs : 4 poules \nLes 2 premiers de chaque poule en quarts de finales");
		} else if (nb_players <= 48) {
			createEightPoule(champ);
			champ.setProchaineEtape(Etape.Huitieme);
			System.out.println(
					nb_players + " joueurs : 8 poules \nLes 2 premiers de chaque poule en huitieme de finales");
		} else {
			System.out.println("Trop de joueurs");
		}
	}

	private void createTwoPoule(Championnat champ) {
		List<Inscription> players = new ArrayList<Inscription>(champ.getListeInscriptions());
		Collections.shuffle(players);

		Set<Inscription> tempA = Set.copyOf(players.subList(0 * players.size() / 2, 1 * players.size() / 2));
		Set<Inscription> tempB = Set.copyOf(players.subList(1 * players.size() / 2, 2 * players.size() / 2));

		Poule pouleA = new Poule("PouleA", LocalDate.now(), champ.getJeu(), tempA, true,
				champ.getNbParticipantsParMatch(), champ);
		Poule pouleB = new Poule("PouleB", LocalDate.now(), champ.getJeu(), tempB, true,
				champ.getNbParticipantsParMatch(), champ);

		Collections.addAll(champ.getPoules(), pouleA, pouleB);
	}

	private void createFourPoule(Championnat champ) {
		List<Inscription> players = new ArrayList<Inscription>(champ.getListeInscriptions());
		Collections.shuffle(players);

		Set<Inscription> tempA = Set.copyOf(players.subList(0 * players.size() / 4, 1 * players.size() / 4));
		Set<Inscription> tempB = Set.copyOf(players.subList(1 * players.size() / 4, 2 * players.size() / 4));
		Set<Inscription> tempC = Set.copyOf(players.subList(2 * players.size() / 4, 3 * players.size() / 4));
		Set<Inscription> tempD = Set.copyOf(players.subList(3 * players.size() / 4, 4 * players.size() / 4));

		Poule pouleA = new Poule("PouleA", LocalDate.now(), champ.getJeu(), tempA, true,
				champ.getNbParticipantsParMatch(), champ);
		Poule pouleB = new Poule("PouleB", LocalDate.now(), champ.getJeu(), tempB, true,
				champ.getNbParticipantsParMatch(), champ);
		Poule pouleC = new Poule("PouleC", LocalDate.now(), champ.getJeu(), tempC, true,
				champ.getNbParticipantsParMatch(), champ);
		Poule pouleD = new Poule("PouleD", LocalDate.now(), champ.getJeu(), tempD, true,
				champ.getNbParticipantsParMatch(), champ);

		Collections.addAll(champ.getPoules(), pouleA, pouleB, pouleC, pouleD);
	}

	private void createEightPoule(Championnat champ) {
		List<Inscription> players = new ArrayList<Inscription>(champ.getListeInscriptions());
		Collections.shuffle(players);

		Set<Inscription> tempA = Set.copyOf(players.subList(0 * players.size() / 8, 1 * players.size() / 8));
		Set<Inscription> tempB = Set.copyOf(players.subList(1 * players.size() / 8, 2 * players.size() / 8));
		Set<Inscription> tempC = Set.copyOf(players.subList(2 * players.size() / 8, 3 * players.size() / 8));
		Set<Inscription> tempD = Set.copyOf(players.subList(3 * players.size() / 8, 4 * players.size() / 8));
		Set<Inscription> tempE = Set.copyOf(players.subList(4 * players.size() / 8, 5 * players.size() / 8));
		Set<Inscription> tempF = Set.copyOf(players.subList(5 * players.size() / 8, 6 * players.size() / 8));
		Set<Inscription> tempG = Set.copyOf(players.subList(6 * players.size() / 8, 7 * players.size() / 8));
		Set<Inscription> tempH = Set.copyOf(players.subList(7 * players.size() / 8, 8 * players.size() / 8));

		Poule pouleA = new Poule("PouleA", LocalDate.now(), champ.getJeu(), tempA, true,
				champ.getNbParticipantsParMatch(), champ);
		Poule pouleB = new Poule("PouleB", LocalDate.now(), champ.getJeu(), tempB, true,
				champ.getNbParticipantsParMatch(), champ);
		Poule pouleC = new Poule("PouleC", LocalDate.now(), champ.getJeu(), tempC, true,
				champ.getNbParticipantsParMatch(), champ);
		Poule pouleD = new Poule("PouleD", LocalDate.now(), champ.getJeu(), tempD, true,
				champ.getNbParticipantsParMatch(), champ);
		Poule pouleE = new Poule("PouleE", LocalDate.now(), champ.getJeu(), tempE, true,
				champ.getNbParticipantsParMatch(), champ);
		Poule pouleF = new Poule("PouleF", LocalDate.now(), champ.getJeu(), tempF, true,
				champ.getNbParticipantsParMatch(), champ);
		Poule pouleG = new Poule("PouleG", LocalDate.now(), champ.getJeu(), tempG, true,
				champ.getNbParticipantsParMatch(), champ);
		Poule pouleH = new Poule("PouleH", LocalDate.now(), champ.getJeu(), tempH, true,
				champ.getNbParticipantsParMatch(), champ);

		Collections.addAll(champ.getPoules(), pouleA, pouleB, pouleC, pouleD, pouleE, pouleF, pouleG, pouleH);

	}

	/// GESTION PHASES FINALES

	public void generatePhaseFinale(Championnat champ) {
		initEtape(champ, Etape.Huitieme);
		initEtape(champ, Etape.Quart);
		initEtape(champ, Etape.Demi);
		initEtape(champ, Etape.Finale);
	}

	private void initEtape(Championnat champ, Etape etape) {
		Journee j = new Journee(champ, null, null, etape);
		for (int i = 0; i < etape.getNbMatchs(); i++) {
			Match m = new Match();
			m.setJournee(j);
			j.getMatchsAJouerPourJournee().add(m);
		}
		champ.getJourneesAJouerFinales().add(j);
	}

	/* @formatter:off
	 * Boucle sur le nombre de matchs de l'étape à venir
	 * Ajout des premiers de chaque poule dans l'odre
	 * Ajout des seconds de chaque poule dans l'odre inverse
	 * @formatter:on
	 */
	public void initChampionatFinales(Championnat champ) {
		// Creation d'une liste de listes avec les 2 premiers de chaque poule
		List<List<Inscription>> topsOfPoules = new ArrayList<List<Inscription>>();
		for (Poule poule : champ.getPoules()) {
			topsOfPoules.add(inscriptionRepo.getClassementLigue(poule.getIdTournoi()).subList(0, 1));
		}
		Journee nextDay = champ.getJourneesAJouerFinales().get(champ.getProchaineEtape().getIndex());
		int nbMatchs = champ.getProchaineEtape().getNbMatchs();
		for (int i = 0; i < nbMatchs; i++) {
			List<Inscription> inscriptionsMatch = new ArrayList<Inscription>();
			inscriptionsMatch.add(topsOfPoules.get(i).get(0));
			inscriptionsMatch.add(topsOfPoules.get(nbMatchs - i).get(1));
			nextDay.getMatchsAJouerPourJournee().get(i).setInscriptions(inscriptionsMatch);
			matchRepo.save(nextDay.getMatchsAJouerPourJournee().get(i));
		}
		journeeRepo.save(nextDay);
		// "increment" de l'etape
		champ.getProchaineEtape().next();
//		champ.setProchaineEtape(champ.getProchaineEtape().next());
		tournoiRepo.save(champ);
	}

	/* @formatter:off
	 * Boucle sur le nombre de matchs de l'étape à venir
	 * Ajoute les gagnants des matchs de l'étape précédante
	 * @formatter:on
	 */
	public void etapeSuivanteChampionnat(Championnat champ) {
		Journee nextDay = champ.getJourneesAJouerFinales().get(champ.getProchaineEtape().getIndex());
		Journee pastDay = champ.getJourneesAJouerFinales().get(champ.getProchaineEtape().getIndex() - 1);
		int nbMatchs = champ.getProchaineEtape().getNbMatchs();
		for (int i = 0; i < nbMatchs; i++) {
			List<Inscription> inscriptionsMatch = new ArrayList<Inscription>();
			inscriptionsMatch.add(pastDay.getMatchsAJouerPourJournee().get(2 * i).getPremier()); // win 1
			inscriptionsMatch.add(pastDay.getMatchsAJouerPourJournee().get((2 * i) + 1).getPremier()); // win 2
			nextDay.getMatchsAJouerPourJournee().get(i).setInscriptions(inscriptionsMatch);
			matchRepo.save(nextDay.getMatchsAJouerPourJournee().get(i));
		}
		journeeRepo.save(nextDay);
		champ.getProchaineEtape().next();
//		champ.setProchaineEtape(champ.getProchaineEtape().next());
		tournoiRepo.save(champ);
	}

}
