package pjt_tournois_e_sport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import pjt_tournois_e_sport.config.AppConfig;
import pjt_tournois_e_sport.model.Journee;
import pjt_tournois_e_sport.model.Match;
import pjt_tournois_e_sport.repositories.JourneeRepository;
import pjt_tournois_e_sport.repositories.MatchRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {AppConfig.class})
class MatchRepositoryTest {
	
	@Autowired
	private MatchRepository matchRepo;
	@Autowired
	private JourneeRepository journeeRepo;
	
	@Test
	@Transactional
	@Disabled
	public void findAllTest() {
		
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
	public void findByDateWithJourneeTest() {
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
		assertTrue(matchsJournee.equals(matchRepo.findByDateWithJournees(LocalDateTime.of(LocalDate.of(2022, 15, 2),LocalTime.of(8, 0)))));
	}
	
}
