package pjt_tournois_e_sport;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import pjt_tournois_e_sport.config.AppConfig;
import pjt_tournois_e_sport.model.Match;
import pjt_tournois_e_sport.repositories.MatchRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {AppConfig.class})
class MatchRepositoryTest {
	
	@Autowired
	private MatchRepository matchRepo;
	
	@Test
	@Transactional
	void findAllTest() {
		
		Match matchTest1 = new Match();
		Match matchTest2 = new Match();
		Match matchTest3 = new Match();
		matchRepo.save(matchTest1);
		matchRepo.save(matchTest2);
		matchRepo.save(matchTest3);
		assertEquals(matchRepo.findAll().size(),matchRepo.count());
		}

	
}
