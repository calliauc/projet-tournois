package projet.sopra.pjt_tournois_e_sport_boot;

import java.time.LocalDate;

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
	
	
	
	@Test
	public void testGenerateMatchs() {
		//Creation des utilisateurs dans base
		Utilisateur user1 = new Utilisateur("user1","u1@u1","user1");
		userRepo.save(user1);
		Utilisateur user2 = new Utilisateur("user2","u2@u2","user2");
		userRepo.save(user2);
		Utilisateur user3 = new Utilisateur("user3","u3@u3","user3");
		userRepo.save(user3);
		Utilisateur user4 = new Utilisateur("user4","u4@u4","user4");
		userRepo.save(user4);
		
		//Creation du tournoi = ligue dans la base
		Ligue ligueTest = new Ligue();
		ligueTest.setNom("ligueTest");
		ligueTest.setDateDeCreation(LocalDate.of(2022, 2, 18));
		ligueTest.setDateDeDebut(LocalDate.of(2022, 2, 20));
		ligueTest.setJeu("Mariokart");
		ligueTest.setNbParticipantsParMatch(2);
		tournoiRepo.save(ligueTest);
		
		//Inscriptions des 4 joueurs à la ligue
		Inscription inscription1 = new Inscription();
		inscription1.setId(new InscriptionKey(user1,ligueTest));

		Inscription inscription2 = new Inscription();
		inscription2.setId(new InscriptionKey(user2,ligueTest));

		Inscription inscription3 = new Inscription();
		inscription3.setId(new InscriptionKey(user3,ligueTest));

		Inscription inscription4 = new Inscription();
		inscription4.setId(new InscriptionKey(user4,ligueTest));

		inscriptionRepo.save(inscription1);
		inscriptionRepo.save(inscription2);
		inscriptionRepo.save(inscription3);
		inscriptionRepo.save(inscription4);
		
		ligueTest.generateJourneesLigueDuels(); 
		
	}
}