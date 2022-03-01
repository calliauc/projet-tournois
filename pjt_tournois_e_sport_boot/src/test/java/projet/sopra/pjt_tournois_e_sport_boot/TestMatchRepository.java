package projet.sopra.pjt_tournois_e_sport_boot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import projet.sopra.pjt_tournois_e_sport_boot.model.Championnat;
import projet.sopra.pjt_tournois_e_sport_boot.model.Etape;
import projet.sopra.pjt_tournois_e_sport_boot.model.Journee;
import projet.sopra.pjt_tournois_e_sport_boot.model.Match;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.JourneeRepository;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.MatchRepository;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.TournoiRepository;

@SpringBootTest
class TestMatchRepository {
	
	@Autowired
	private MatchRepository matchRepo;
	@Autowired
	private JourneeRepository journeeRepo;
	@Autowired
	private TournoiRepository tournoiRepo;
	
	
	@Test
	@Transactional
	@Disabled
	public void testCreateAndFindAll() {
		
		Match matchTest1 = new Match();
		Match matchTest2 = new Match();
		Match matchTest3 = new Match();
		matchRepo.save(matchTest1);
		matchRepo.save(matchTest2);
		matchRepo.save(matchTest3);
		assertEquals(matchRepo.findAll().size(),matchRepo.count());
		}
	
	@Test
	@Transactional
	@Disabled
	public void testFindByDateWithJournee() {
		Match matchTest1 = new Match();
		Match matchTest2 = new Match();
		Journee journeeTest = new Journee();
		journeeTest.setDateDebutJournee(LocalDateTime.of(LocalDate.of(2022, 15, 2),LocalTime.of(8, 0)));
		matchTest1.setJournee(journeeTest);
		matchTest2.setJournee(journeeTest);
		journeeRepo.save(journeeTest);
		matchRepo.save(matchTest1);
		matchRepo.save(matchTest2);
		List<Match> matchsJournee = new ArrayList<Match>();
		matchsJournee.add(matchTest1);
		matchsJournee.add(matchTest2);
		//assertTrue(matchsJournee.equals(matchRepo.findByDateWithJournees(LocalDateTime.of(LocalDate.of(2022, 15, 2),LocalTime.of(8, 0)))));
	}
	
	
	@Test
	@Transactional
	@Commit
	public void testRestControllerMatch() {
		Championnat champTest = new Championnat();
		champTest.setDateDeCreation(LocalDate.of(2022,2,15));
		champTest.setDateDeDebut(LocalDate.of(2022, 3,15));
		champTest.setJeu("Mariokart");
		champTest.setNbParticipantsParMatch(2);
		champTest.setNom("champTest");
		tournoiRepo.save(champTest);
		
		Journee journeeTest = new Journee();
		journeeTest.setTournoi(champTest);
		journeeTest.setEtape(Etape.valueOf("Poule"));
		journeeRepo.save(journeeTest);
		
		Match match1 = new Match();
		Match match2 = new Match();
		Match match3 = new Match();
		match1.setJournee(journeeTest);
		matchRepo.save(match1);
		matchRepo.save(match2);
		matchRepo.save(match3);
	}
}
