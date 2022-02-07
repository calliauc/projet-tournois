package pjt_tournois_e_sport;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.NoResultException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import pjt_tournois_e_sport.config.AppConfig;
import pjt_tournois_e_sport.model.Organisateur;
import pjt_tournois_e_sport.repositories.OrganisateurRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class })
class OrganisateurRepositoryTest {
	
	@Autowired
	OrganisateurRepository orgaRepo;

	@Test
	@Disabled
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void testFindByPseudo()
	{
		Organisateur org = new Organisateur("org","org","org");
		orgaRepo.save(org);
		System.out.println(orgaRepo.findByPseudo("org"));
		org.setMail("orgMail");
		orgaRepo.save(org);
		assertThrows(NoResultException.class, () -> orgaRepo.findById(101L).orElseThrow(NoResultException::new));
		assertTrue(orgaRepo.findById(100L).orElseThrow(NoResultException::new) instanceof Organisateur);
	}
	
	
	@Test
	@Disabled
	void testFindByIdWithTournois()
	{
		// A tester avec un tournoi
	}


}
