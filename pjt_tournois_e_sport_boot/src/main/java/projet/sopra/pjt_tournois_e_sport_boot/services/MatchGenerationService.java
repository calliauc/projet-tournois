package projet.sopra.pjt_tournois_e_sport_boot.services;

import java.util.ArrayList;
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
	private InscriptionRepository inscriptionRepo;

	public void generateJourneesLigueDuels(Ligue ligue) {

		////// TO DO : INCLURE LES DATES DE DEBUT/FIN DES MATCHS ET JOURNEES

		Set<Journee> journees = new HashSet<Journee>();
		LinkedList<Inscription> inscriptionsLigue = new LinkedList<Inscription>(ligue.getListeInscriptions());
		int isPair = (ligue.getListeInscriptions().size() + 1) % 2;

		for (int i = 0; i < inscriptionsLigue.size() - isPair; i++) {
			Journee jour = new Journee();
			jour.setTournoi(ligue);
			jour.setEtape(Etape.Ligue);
			jour.setNumero(i + 1);
			journeeRepo.save(jour);
			List<Match> matchsJournee = new ArrayList<Match>();
			for (int j = 0; j < ligue.getListeInscriptions().size() / 2; j++) {
				Match m = new Match();
				m.setJournee(jour);
				m.getInscriptions().add(inscriptionsLigue.get(j));
				m.getInscriptions().add(inscriptionsLigue.get(inscriptionsLigue.size() / 2 - (j + 1)));
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
		tournoiRepo.save(ligue);
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
		}
		// "increment" de l'etape
		champ.getProchaineEtape().next();
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
		}
		champ.getProchaineEtape().next();
	}

}
