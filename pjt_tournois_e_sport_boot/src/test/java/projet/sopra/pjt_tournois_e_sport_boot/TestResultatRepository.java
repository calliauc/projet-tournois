package projet.sopra.pjt_tournois_e_sport_boot;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import projet.sopra.pjt_tournois_e_sport_boot.model.Resultat;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.ResultatRepository;

@SpringBootTest
public class TestResultatRepository {
	
	@Autowired
	private ResultatRepository resultatRepo;
	
	@Test
	//@Transactional
	//@Disabled
	public void testCreateAndFindAll() {
		
		Resultat resultatTest1 = new Resultat(null, null, 1,1);
		resultatRepo.save(resultatTest1);
		assertEquals(resultatRepo.findAll().size(),resultatRepo.count());
		
	}
	
	@Test
	//@Transactional
	//@Disabled
	public void testFindById2() {
		System.out.println(resultatRepo.findById(100L));
	}
	
}
