package projet.sopra.pjt_tournois_e_sport_boot;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
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

	@Autowired
	private InscriptionRepository inscriptionRepo;
	@Autowired 
	private UtilisateurRepository userRepo;
	@Autowired
	private TournoiRepository tournoiRepo;
	
	@Test
	@Transactional
	@Disabled
	public void testFindByScoreBetween() {
		Utilisateur user1 = new Utilisateur();
		user1.setUsername("user1");
		userRepo.save(user1);
		Utilisateur user2 = new Utilisateur();
		user2.setUsername("user2");
		userRepo.save(user2);
		Utilisateur user3 = new Utilisateur();
		user3.setUsername("user3");
		userRepo.save(user3);
		Utilisateur user4 = new Utilisateur();
		user4.setUsername("user4");
		userRepo.save(user4);
		
		Ligue ligueTest = new Ligue();
		ligueTest.setNom("ligueTest");
		tournoiRepo.save(ligueTest);
		
		Inscription inscription1 = new Inscription();
		inscription1.setId(new InscriptionKey(user1,ligueTest));
		inscription1.setScore(10);
		
		Inscription inscription2 = new Inscription();
		inscription2.setId(new InscriptionKey(user2,ligueTest));
		inscription2.setScore(200);
		Inscription inscription3 = new Inscription();
		inscription3.setId(new InscriptionKey(user3,ligueTest));
		inscription3.setScore(3000);
		Inscription inscription4 = new Inscription();
		inscription4.setId(new InscriptionKey(user4,ligueTest));
		inscription4.setScore(40000);
		inscriptionRepo.save(inscription1);
		inscriptionRepo.save(inscription2);
		inscriptionRepo.save(inscription3);
		inscriptionRepo.save(inscription4);
		int minTest =100;
		int maxTest = 4000;
		inscriptionRepo.findByScoreBetween(minTest, maxTest).forEach(i -> {
			assertTrue(i.getScore()>=minTest && i.getScore()<=maxTest);
		});
	}
}
