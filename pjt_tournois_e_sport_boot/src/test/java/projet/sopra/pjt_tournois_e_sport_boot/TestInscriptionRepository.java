package projet.sopra.pjt_tournois_e_sport_boot;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import projet.sopra.pjt_tournois_e_sport_boot.model.Inscription;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.InscriptionRepository;

@SpringBootTest
public class TestInscriptionRepository {

	@Autowired
	private InscriptionRepository inscriptionRepo;
	
	@Test
	@Transactional
	public void testFindByScoreBetween() {
		Inscription inscription1 = new Inscription();
		Inscription inscription2 = new Inscription();
		Inscription inscription3 = new Inscription();
		inscription1.setScore(10);
		inscription2.setScore(200);
		inscription3.setScore(3000);
		inscriptionRepo.save(inscription1);
		inscriptionRepo.save(inscription2);
		inscriptionRepo.save(inscription3);
		int minTest =100;
		int maxTest = 4000;
		inscriptionRepo.findByScoreBetween(minTest, maxTest).forEach(i -> {
			assertTrue(i.getScore()>=minTest && i.getScore()<=maxTest);
		});
	}
}
