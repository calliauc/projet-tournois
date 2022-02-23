package projet.sopra.pjt_tournois_e_sport_boot;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.NoResultException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//import pjt_tournois_e_sport.config.AppConfig;
import projet.sopra.pjt_tournois_e_sport_boot.exceptions.UtilisateurException;
import projet.sopra.pjt_tournois_e_sport_boot.model.Utilisateur;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.UtilisateurRepository;
import projet.sopra.pjt_tournois_e_sport_boot.services.UtilisateurService;

@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = { AppConfig.class })
class UtilisateurRepositoryTest {

	@Autowired
	UtilisateurRepository userRepo;
	@Autowired
	UtilisateurService userService;

	@Test
	@Commit
	public void testCreate() {
		Utilisateur user1 = new Utilisateur("Jaxx", "jaxx@mail.com", "mdp");
		Utilisateur user2 = new Utilisateur("Gotaga", "gotaga@mail.com", "gota");
		Utilisateur user3 = new Utilisateur("Ponce", "ponce@mail.com", "ponpon");
		userService.save(user1);
		userService.save(user2);
		userService.save(user3);
	}

	@Test
	public void testGetAll() {
		System.out.println(userService.getAll());
	}

	@Test
	public void testGetById() {
		System.out.println(userService.getById(100L));
		System.out.println(userService.getById(101L));
		System.out.println(userService.getById(102L));
		assertThrows(UtilisateurException.class, () -> userService.getById(103L));
	}

	@Test
	public void testUpdate() {
		Utilisateur user = userService.getById(101L);
		user.setUsername("Domingo");
		user.setMail("domingo@mail.com");
		user.setPassword("Silmi");
		userService.save(user);
	}

	@Test
	@Disabled
	void testFindByPseudo() {
		Utilisateur user = new Utilisateur("Jaxx", "jaxx@mail.com", "mdp");
		userRepo.save(user);
		System.out.println(userRepo.findByUsername("user"));
		user.setMail("userMail");
		userRepo.save(user);
		assertThrows(NoResultException.class, () -> userRepo.findById(101L).orElseThrow(NoResultException::new));
		assertTrue(userRepo.findById(100L).orElseThrow(NoResultException::new) instanceof Utilisateur);
	}

	@Test
	@Disabled
	void testFindByIdWithTournois() {
		// A tester avec un tournoi
	}

}
