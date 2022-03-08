package projet.sopra.pjt_tournois_e_sport_boot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import projet.sopra.pjt_tournois_e_sport_boot.model.Inscription;
import projet.sopra.pjt_tournois_e_sport_boot.model.InscriptionKey;
import projet.sopra.pjt_tournois_e_sport_boot.model.Journee;
import projet.sopra.pjt_tournois_e_sport_boot.model.Ligue;
import projet.sopra.pjt_tournois_e_sport_boot.model.Match;
import projet.sopra.pjt_tournois_e_sport_boot.model.Resultat;
import projet.sopra.pjt_tournois_e_sport_boot.model.Utilisateur;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.InscriptionRepository;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.MatchRepository;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.ResultatRepository;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.TournoiRepository;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.UtilisateurRepository;
import projet.sopra.pjt_tournois_e_sport_boot.services.MatchGenerationService;
import projet.sopra.pjt_tournois_e_sport_boot.services.MatchService;
import projet.sopra.pjt_tournois_e_sport_boot.services.SetClassementTournoiService;

@SpringBootTest
public class MatchAndClassementLigueTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(MatchAndClassementLigueTest.class);

	@Autowired
	private InscriptionRepository inscriptionRepo;
	@Autowired
	private UtilisateurRepository userRepo;
	@Autowired
	private TournoiRepository tournoiRepo;	
	@Autowired
	private MatchRepository matchRepo;
	@Autowired
	private ResultatRepository resultatRepo;
	
	@Autowired
	private MatchGenerationService matchGenerationService;
	@Autowired
	private SetClassementTournoiService setClassementTournoiService;
	@Autowired
	private MatchService matchService;

	public Utilisateur CreationUser(String username, String mail, String password) {
		Utilisateur user = new Utilisateur(username, mail, password);
		userRepo.save(user);
		return user;
	}

	public Ligue CreationTournoi() {
		LOGGER.info("Creation de la ligue");
		// Creation du tournoi = ligue dans la base
		Ligue ligueTest = new Ligue();
		LOGGER.info("Remplissage des attributs de la ligue");
		ligueTest.setNom("ligueTest");
		ligueTest.setDateDeCreation(LocalDate.of(2022, 2, 18));
		ligueTest.setDateDeDebut(LocalDate.of(2022, 2, 20));
		ligueTest.setJeu("Mariokart");
		ligueTest.setNbParticipantsParMatch(2);
		LOGGER.info("Fin du remplissage");

		LOGGER.info("Sauvegarde en base");
		tournoiRepo.save(ligueTest);
		LOGGER.info("Fin de la sauvegarde en base");
		return ligueTest;
	}

	public Inscription CreationInscription(Utilisateur user, Ligue ligue) {
		Inscription inscription = new Inscription();
		inscription.setId(new InscriptionKey(user, ligue));
		ligue.getListeInscriptions().add(inscription);
		inscriptionRepo.save(inscription);
		tournoiRepo.save(ligue);
		return inscription;

	}

	public void CreationResultat(Match match, int score1, int score2) {
		LOGGER.info("score : "+score1+" - "+score2);
		int position1;
		int position2;
		List<Resultat> resultats = new ArrayList();
		if (score1 > score2) {
			position1 = 1;
			position2 = 2;
		} else if (score2 > score1) {
			position1 = 2;
			position2 = 1;
		} else {
			position1 = 1;
			position2 = 1;
		}
		Resultat resultat1 = new Resultat(match, match.getInscriptions().get(0), position1, score1);
		resultats.add(resultat1);
		resultatRepo.save(resultat1);

		Resultat resultat2 = new Resultat(match, match.getInscriptions().get(1), position2, score2);
		resultats.add(resultat2);
		resultatRepo.save(resultat2);

		match.setResultats(resultats);
		matchRepo.save(match);
	}

	@Test
	@Transactional
	@Commit
//	@Disabled
	public void testGenerateMatchsPair() {
		LOGGER.info("Debut du test");

		LOGGER.info("Creation des users");
		Utilisateur user1 = CreationUser("user1", "u1@u1", "user1");
		Utilisateur user2 = CreationUser("user2", "u2@u2", "user2");
		Utilisateur user3 = CreationUser("user3", "u3@u3", "user3");
		Utilisateur user4 = CreationUser("user4", "u3@u4", "user4");
		LOGGER.info("Users créés");

		Ligue ligueTest = CreationTournoi();

		LOGGER.info("Creation des inscriptions");
		Inscription inscription1 = CreationInscription(user1, ligueTest);
		Inscription inscription2 = CreationInscription(user2, ligueTest);
		Inscription inscription3 = CreationInscription(user3, ligueTest);
		Inscription inscription5 = CreationInscription(user4, ligueTest);
		LOGGER.info("Fin de la creation des inscriptions");

		LOGGER.info("Generation des matches");
		matchGenerationService.generateJourneesLigueDuels(ligueTest);
		LOGGER.info("Fin de la generation des matches");

		LOGGER.info("Creation des résultats d'une journée");
		for (Journee j : ligueTest.getJourneesAJouer()) {
			LOGGER.info("journée: " + j.getId());
			for (Match m : j.getMatchsAJouerPourJournee()) {
				LOGGER.info("match: " + m.getId());
				CreationResultat(m, new Random().nextInt(10), new Random().nextInt(10));
				setClassementTournoiService.setScoreClassementDuel(m);
				LOGGER.info("match: " + m.getId() + " terminé");
			}
			setClassementTournoiService.SetClassementPasFacile(ligueTest);
			LOGGER.info("journée: " + j.getId() + " terminée");
		}
		LOGGER.info("Fin de la création des resultats et du classement");
		LOGGER.info("FIN DE LA LIGUE");
		matchService.setAllProchainMatch(ligueTest.getIdTournoi());
		LOGGER.info(inscriptionRepo.getClassementLigue(ligueTest.getIdTournoi()).toString());
		
		
		
		
	}

}
