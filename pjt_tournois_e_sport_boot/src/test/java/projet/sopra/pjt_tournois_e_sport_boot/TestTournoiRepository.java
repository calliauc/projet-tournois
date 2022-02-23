package projet.sopra.pjt_tournois_e_sport_boot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import projet.sopra.pjt_tournois_e_sport_boot.model.Ligue;
import projet.sopra.pjt_tournois_e_sport_boot.model.Tournoi;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.TournoiRepository;

@SpringBootTest
public class TestTournoiRepository {
	
	@Autowired
	private TournoiRepository tournoiRepo;
	
	/*
	 * TODO corriger ce test
	 */
	@Test
	@Transactional
	@Disabled
	public void testCreateAndFindAll() {
		
//		Ligue tournoiTest1 = new Ligue("ligue1", LocalDate.now(), LocalDate.now(), "mario", null, true, 1);
//		Ligue tournoiTest2 = new Ligue("ligue2", LocalDate.now(), LocalDate.now(), "mario2", null, true, 1);
//		tournoiRepo.save(tournoiTest1);
//		tournoiRepo.save(tournoiTest2);
//		assertEquals(tournoiRepo.findAll().size(),tournoiRepo.count());
		
	}
	
	@Test
	@Transactional
	@Disabled
	public void testFindByNom() {
		System.out.println(tournoiRepo.findByNom("ligue1"));
	}
	
	@Test
	@Transactional
	@Disabled
	public void testFindByNomContaining() {
		System.out.println(tournoiRepo.findByNomContaining("1"));
	}
}