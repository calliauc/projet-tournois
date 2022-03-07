package projet.sopra.pjt_tournois_e_sport_boot.services;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.sopra.pjt_tournois_e_sport_boot.model.Etape;
import projet.sopra.pjt_tournois_e_sport_boot.model.Inscription;
import projet.sopra.pjt_tournois_e_sport_boot.model.Journee;
import projet.sopra.pjt_tournois_e_sport_boot.model.Ligue;
import projet.sopra.pjt_tournois_e_sport_boot.model.Match;
import projet.sopra.pjt_tournois_e_sport_boot.model.Tournoi;
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

	public void generateJourneesLigueDuels(Ligue ligue) {

		////// TO DO : INCLURE LES DATES DE DEBUT/FIN DES MATCHS ET JOURNEES


		Set<Journee> journees = new HashSet<Journee>();
		LinkedList<Inscription> inscriptionsLigue = new LinkedList<Inscription>(ligue.getListeInscriptions());
		System.out.println("inscriptions : " + inscriptionsLigue.toString());
		int isPair = (ligue.getListeInscriptions().size() + 1) % 2;

		for (int i = 0; i < inscriptionsLigue.size() - isPair; i++) {
			Journee jour = new Journee();
			jour.setTournoi(ligue);
			jour.setEtape(Etape.Ligue);
			jour.setNumero(i+1);
			journeeRepo.save(jour);
			Set<Match> matchsJournee = new HashSet<Match>();
			for (int j = 0; j < ligue.getListeInscriptions().size() / 2; j++) {
				System.out.println("Match : "+j);
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
		tournoiRepo.save(ligue);
	}

}
