package projet.sopra.pjt_tournois_e_sport_boot;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.NoResultException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import pjt_tournois_e_sport.config.AppConfig;
import pjt_tournois_e_sport.model.Organisateur;
import pjt_tournois_e_sport.repositories.OrganisateurRepository;
import pjt_tournois_e_sport.services.OrganisateurService;
import projet.sopra.pjt_tournois_e_sport_boot.exceptions.OrganisateurException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class })
class OrganisateurRepositoryTest {

	@Autowired
	OrganisateurRepository orgaRepo;
	@Autowired
	OrganisateurService orgaService;

	@Test
	@Commit
	public void testCreate() {
		Organisateur org1 = new Organisateur("Jaxx", "mdp", "jaxx@mail.com");
		Organisateur org2 = new Organisateur("Gotaga", "gota", "gotaga@mail.com");
		Organisateur org3 = new Organisateur("Ponce", "ponpon", "ponce@mail.com");
		orgaService.save(org1);
		orgaService.save(org2);
		orgaService.save(org3);
	}

	@Test
	public void testGetAll() {
		System.out.println(orgaService.getAll());
	}

	@Test
	public void testGetById() {
		System.out.println(orgaService.getById(100L));
		System.out.println(orgaService.getById(101L));
		System.out.println(orgaService.getById(102L));
		assertThrows(OrganisateurException.class, () -> orgaService.getById(103L));
	}

	@Test
	public void testUpdate() {
		Organisateur org = orgaService.getById(101L);
		org.setPseudo("Domingo");
		org.setPassword("Silmi");
		org.setMail("domingo@mail.com");
		orgaService.save(org);
	}

	@Test
	@Disabled
	void testFindByPseudo() {
		Organisateur org = new Organisateur("Jaxx", "mdp", "jaxx@mail.com");
		orgaRepo.save(org);
		System.out.println(orgaRepo.findByPseudo("org"));
		org.setMail("orgMail");
		orgaRepo.save(org);
		assertThrows(NoResultException.class, () -> orgaRepo.findById(101L).orElseThrow(NoResultException::new));
		assertTrue(orgaRepo.findById(100L).orElseThrow(NoResultException::new) instanceof Organisateur);
	}

	@Test
	@Disabled
	void testFindByIdWithTournois() {
		// A tester avec un tournoi
	}

}
