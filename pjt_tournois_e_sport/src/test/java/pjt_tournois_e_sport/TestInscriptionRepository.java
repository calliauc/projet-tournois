package pjt_tournois_e_sport;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import pjt_tournois_e_sport.config.AppConfig;
import pjt_tournois_e_sport.model.Inscription;
import pjt_tournois_e_sport.repositories.InscriptionRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {AppConfig.class})
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
