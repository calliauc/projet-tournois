package projet.sopra.pjt_tournois_e_sport_boot.services;

import java.util.Arrays;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import projet.sopra.pjt_tournois_e_sport_boot.model.Role;
import projet.sopra.pjt_tournois_e_sport_boot.model.Utilisateur;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.UtilisateurRepository;

@Service
public class ConsoleService implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UtilisateurRepository utilisateurRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleService.class);

	@Override
	public void run(String... args) throws Exception {
		initDataBase();
	}

	private void initDataBase() {
		if (utilisateurRepo.findByUsername("jojo").isEmpty()) {
			Utilisateur jojo = new Utilisateur();
			jojo.setUsername("jojo");
			jojo.setPassword(passwordEncoder.encode("jojo"));
			jojo.setMail("a@a.fr");
			jojo.setRoles(new HashSet<Role>(Arrays.asList(Role.ROLE_ADMIN)));
			utilisateurRepo.save(jojo);
		}

	}

}
