package projet.sopra.pjt_tournois_e_sport_boot;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import projet.sopra.pjt_tournois_e_sport_boot.model.Inscription;
import projet.sopra.pjt_tournois_e_sport_boot.model.InscriptionKey;
import projet.sopra.pjt_tournois_e_sport_boot.model.Ligue;
import projet.sopra.pjt_tournois_e_sport_boot.model.Utilisateur;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.InscriptionRepository;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.TournoiRepository;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.UtilisateurRepository;
import projet.sopra.pjt_tournois_e_sport_boot.services.MatchGenerationService;
import projet.sopra.pjt_tournois_e_sport_boot.services.MatchService;

@SpringBootTest
public class GenerateMatchLigueTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(GenerateMatchLigueTest.class);
	/*
	 * TODO mettre des logs pour trouver le bug
	 */
	
	@Autowired
	private InscriptionRepository inscriptionRepo;
	@Autowired 
	private UtilisateurRepository userRepo;
	@Autowired
	private TournoiRepository tournoiRepo;
	@Autowired
	private MatchGenerationService matchGenerationService;
	@Autowired
	private MatchService matchService;
	
	
	@Test
	@Transactional
	@Commit
	@Disabled
	public void testGenerateMatchsPair() {
		LOGGER.info("Debut du test");
		//Creation des utilisateurs dans base
		LOGGER.info("Creation des users");
		Utilisateur user1 = new Utilisateur("user1","u1@u1","user1");
		userRepo.save(user1);
		Utilisateur user2 = new Utilisateur("user2","u2@u2","user2");
		userRepo.save(user2);
		Utilisateur user3 = new Utilisateur("user3","u3@u3","user3");
		userRepo.save(user3);
		Utilisateur user4 = new Utilisateur("user4","u4@u4","user4");
		userRepo.save(user4);
		LOGGER.info("Users créés");

		LOGGER.info("Creation de la ligue");
		//Creation du tournoi = ligue dans la base
		Ligue ligueTest = new Ligue();
		LOGGER.info("Remplissage des attributs de la ligue");
		ligueTest.setNom("ligueTest");
		ligueTest.setDateDeCreation(LocalDate.of(2022, 2, 18));
		ligueTest.setDateDeDebut(LocalDate.of(2022, 2, 20));
		ligueTest.setJeu("Mariokart");
		ligueTest.setNbParticipantsParMatch(2);
		ligueTest.setMatchRetour(true);
		LOGGER.info("Fin du remplissage");
		
		LOGGER.info("Sauvegarde en base");
		tournoiRepo.save(ligueTest);
		LOGGER.info("Fin de la sauvegarde en base");
		
		
		LOGGER.info("Creation des inscriptions");
		//Inscriptions des 4 joueurs à la ligue
		Inscription inscription1 = new Inscription();
		inscription1.setId(new InscriptionKey(user1,ligueTest));
		ligueTest.getListeInscriptions().add(inscription1);
		
		Inscription inscription2 = new Inscription();
		inscription2.setId(new InscriptionKey(user2,ligueTest));
		ligueTest.getListeInscriptions().add(inscription2);
		
		Inscription inscription3 = new Inscription();
		inscription3.setId(new InscriptionKey(user3,ligueTest));
		ligueTest.getListeInscriptions().add(inscription3);
		
		Inscription inscription4 = new Inscription();
		inscription4.setId(new InscriptionKey(user4,ligueTest));
		ligueTest.getListeInscriptions().add(inscription4);
		
		LOGGER.info("Fin de la creation des inscriptions");

		
		
		LOGGER.info("Sauvegarde des inscriptions");
		inscriptionRepo.save(inscription1);
		inscriptionRepo.save(inscription2);
		inscriptionRepo.save(inscription3);
		inscriptionRepo.save(inscription4);
		LOGGER.info("Fin de la sauvegarde des inscriptions");
		
		LOGGER.info("Sauvegarde en base");
		tournoiRepo.save(ligueTest);
		LOGGER.info("Fin de la sauvegarde en base");

		LOGGER.info("Generation des matches");
//		ligueTest.generateJourneesLigueDuels(); 
		matchGenerationService.generateJourneesLigueDuels(ligueTest);
		LOGGER.info("Fin de la generation des matches");
		LOGGER.info("Get prochains matches");
		matchService.setAllProchainMatch(ligueTest.getIdTournoi());
	}
	
	@Test
	@Transactional
	@Commit
//	@Disabled
	public void testGenerateMatchsImpair() {
		LOGGER.info("Debut du test");
		//Creation des utilisateurs dans base
		LOGGER.info("Creation des users");
		Utilisateur user1 = new Utilisateur("user1","u1@u1","user1");
		userRepo.save(user1);
		Utilisateur user2 = new Utilisateur("user2","u2@u2","user2");
		userRepo.save(user2);
		Utilisateur user3 = new Utilisateur("user3","u3@u3","user3");
		userRepo.save(user3);
		Utilisateur user4 = new Utilisateur("user4","u4@u4","user4");
		userRepo.save(user4);
		Utilisateur user5 = new Utilisateur("user5","u5@u5","user5");
		userRepo.save(user5);
		LOGGER.info("Users créés");

		LOGGER.info("Creation de la ligue");
		//Creation du tournoi = ligue dans la base
		Ligue ligueTest = new Ligue();
		LOGGER.info("Remplissage des attributs de la ligue");
		ligueTest.setNom("ligueTest");
		ligueTest.setDateDeCreation(LocalDate.of(2022, 2, 18));
		ligueTest.setDateDeDebut(LocalDate.of(2022, 2, 20));
		ligueTest.setJeu("Mariokart");
		ligueTest.setNbParticipantsParMatch(2);
		ligueTest.setMatchRetour(true);
		LOGGER.info("Fin du remplissage");
		
		LOGGER.info("Sauvegarde en base");
		tournoiRepo.save(ligueTest);
		LOGGER.info("Fin de la sauvegarde en base");
		
		
		LOGGER.info("Creation des inscriptions");
		//Inscriptions des 5 joueurs à la ligue
		Inscription inscription1 = new Inscription();
		inscription1.setId(new InscriptionKey(user1,ligueTest));
		ligueTest.getListeInscriptions().add(inscription1);
		
		Inscription inscription2 = new Inscription();
		inscription2.setId(new InscriptionKey(user2,ligueTest));
		ligueTest.getListeInscriptions().add(inscription2);
		
		Inscription inscription3 = new Inscription();
		inscription3.setId(new InscriptionKey(user3,ligueTest));
		ligueTest.getListeInscriptions().add(inscription3);
		
		Inscription inscription4 = new Inscription();
		inscription4.setId(new InscriptionKey(user4,ligueTest));
		ligueTest.getListeInscriptions().add(inscription4);
		
		Inscription inscription5 = new Inscription();
		inscription5.setId(new InscriptionKey(user5,ligueTest));
		ligueTest.getListeInscriptions().add(inscription5);
		
		LOGGER.info("Fin de la creation des inscriptions");

		
		
		LOGGER.info("Sauvegarde des inscriptions");
		inscriptionRepo.save(inscription1);
		inscriptionRepo.save(inscription2);
		inscriptionRepo.save(inscription3);
		inscriptionRepo.save(inscription4);
		inscriptionRepo.save(inscription5);
		LOGGER.info("Fin de la sauvegarde des inscriptions");
		
		LOGGER.info("Sauvegarde en base");
		tournoiRepo.save(ligueTest);
		LOGGER.info("Fin de la sauvegarde en base");

		LOGGER.info("Generation des matches");
//		ligueTest.generateJourneesLigueDuels(); 
		matchGenerationService.generateJourneesLigueDuels(ligueTest);
		LOGGER.info("Fin de la generation des matches");
		LOGGER.info("Get prochains matches");
		
		
	}
}