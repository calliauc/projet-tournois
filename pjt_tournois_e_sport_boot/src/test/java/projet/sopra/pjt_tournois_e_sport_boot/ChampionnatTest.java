package projet.sopra.pjt_tournois_e_sport_boot;

import java.time.LocalDate;
import java.util.Formatter;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import projet.sopra.pjt_tournois_e_sport_boot.model.Championnat;
import projet.sopra.pjt_tournois_e_sport_boot.model.Inscription;
import projet.sopra.pjt_tournois_e_sport_boot.model.InscriptionKey;
import projet.sopra.pjt_tournois_e_sport_boot.model.Utilisateur;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.InscriptionRepository;
import projet.sopra.pjt_tournois_e_sport_boot.services.InscriptionService;
import projet.sopra.pjt_tournois_e_sport_boot.services.TournoiService;
import projet.sopra.pjt_tournois_e_sport_boot.services.UtilisateurService;

@SpringBootTest
class ChampionnatTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(GenerateMatchLigueTest.class);

	@Autowired
	private InscriptionService inscriptionService;
	@Autowired
	private TournoiService tournoiService;
	@Autowired
	private UtilisateurService utilisateurService;

	@Test
	@Transactional
//	@Commit
	void testChamp() {

		/* @formatter:off
		 * TODO:
		 * Creer championnat
		 * Set liste inscriptions
		 * Creer toutes les étapes Poules et Finales
		 * Simuler les résultats poules
		 * Passer aux phases finales
		 * Simuler resultats finales
		 * @formatter:on
		 */
		LOGGER.debug("Debut des tests");

		LOGGER.debug("Creation du champ");
		Championnat champ = new Championnat();
		champ.setNom("Tournoi 1");
		champ.setJeu("Smash Bros");
		champ.setDateDeCreation(LocalDate.now());
		LOGGER.debug("Champ créée");

		LOGGER.debug("Debut de la sauvegarde");
		tournoiService.createOrUpdate(champ);
		LOGGER.debug("Sauvegarde finie");
		

		LOGGER.debug("Creation user");
		Utilisateur u1 = new Utilisateur("toto", "a@b.c", "toto");
		Inscription p1 = new Inscription();
		p1.setId(new InscriptionKey(u1, champ));

		LOGGER.debug("Debut de la sauvegarde");
		utilisateurService.save(u1);
		inscriptionService.createOrUpdate(p1);
		LOGGER.debug("Sauvegarde finie");

	}

}
