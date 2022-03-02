package projet.sopra.pjt_tournois_e_sport_boot;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import projet.sopra.pjt_tournois_e_sport_boot.model.Inscription;
import projet.sopra.pjt_tournois_e_sport_boot.model.InscriptionKey;
import projet.sopra.pjt_tournois_e_sport_boot.model.Ligue;
import projet.sopra.pjt_tournois_e_sport_boot.model.Utilisateur;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.InscriptionRepository;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.TournoiRepository;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.UtilisateurRepository;

@SpringBootTest
public class TestInscriptionRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestInscriptionRepository.class);
	
	@Autowired
	private InscriptionRepository inscriptionRepo;
	@Autowired 
	private UtilisateurRepository userRepo;
	@Autowired
	private TournoiRepository tournoiRepo;
	
	@Test
	@Transactional
	public void testFindByScoreBetween() {
		
		LOGGER.info("DEBUT TEST");
		
		//Creation des utilisateurs dans base
		LOGGER.info("DEBUT CREATION USER");
		Utilisateur user1 = new Utilisateur("user1","u1@u1","user1");
		userRepo.save(user1);
		Utilisateur user2 = new Utilisateur("user2","u2@u2","user2");
		userRepo.save(user2);
		Utilisateur user3 = new Utilisateur("user3","u3@u3","user3");
		userRepo.save(user3);
		Utilisateur user4 = new Utilisateur("user4","u4@u4","user4");
		userRepo.save(user4);
		LOGGER.info("FIN CREATION USER");
		
		
		//Creation du tournoi = ligue dans la base
		LOGGER.info("DEBUT CREATION LIGUE");
		Ligue ligueTest = new Ligue();
		ligueTest.setNom("ligueTest");
		ligueTest.setDateDeCreation(LocalDate.of(2022, 2, 18));
		ligueTest.setDateDeDebut(LocalDate.of(2022, 2, 20));
		ligueTest.setJeu("Mariokart");
		ligueTest.setNbParticipantsParMatch(4);
		tournoiRepo.save(ligueTest);
		LOGGER.info("FIN CREATION LIGUE");
		
		//Inscriptions des 4 joueurs à la ligue
		LOGGER.info("DEBUT CREATION INSCRIPTION");
		Inscription inscription1 = new Inscription();
		inscription1.setId(new InscriptionKey(user1,ligueTest));
		inscription1.setScore(10);
		inscription1.setScoreDifference(12);
		Inscription inscription2 = new Inscription();
		inscription2.setId(new InscriptionKey(user2,ligueTest));
		inscription2.setScore(10);
		inscription2.setScoreDifference(13);
		Inscription inscription3 = new Inscription();
		inscription3.setId(new InscriptionKey(user3,ligueTest));
		inscription3.setScore(3000);
		inscription3.setScoreDifference(13);
		Inscription inscription4 = new Inscription();
		inscription4.setId(new InscriptionKey(user4,ligueTest));
		inscription4.setScore(40000);
		inscription4.setScoreDifference(13);
		inscriptionRepo.save(inscription1);
		inscriptionRepo.save(inscription2);
		inscriptionRepo.save(inscription3);
		inscriptionRepo.save(inscription4);
		LOGGER.info("FIN CREATION INSCRIPTIONS");
		//Parametrage test
		int minTest =100;
		int maxTest = 4000;
		
		//Test
		
		inscriptionRepo.findByScoreBetween(minTest, maxTest).forEach(i -> {
			assertTrue(i.getScore()>=minTest && i.getScore()<=maxTest);
		});
		
		LOGGER.info(inscriptionRepo.getClassementLigue(ligueTest.getIdTournoi()).toString());
		LOGGER.info("FIN TEST");
	}
}
