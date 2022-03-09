package projet.sopra.pjt_tournois_e_sport_boot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import projet.sopra.pjt_tournois_e_sport_boot.services.InscriptionService;
import projet.sopra.pjt_tournois_e_sport_boot.services.MatchGenerationService;
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
	@Autowired
	private MatchGenerationService matchGenService;

	@Test
	@Transactional
	@Commit
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
		

		LOGGER.debug("Creation users & inscription");
		List<Utilisateur> users = new ArrayList<Utilisateur>();
		Set<Inscription> inscrits = new HashSet<Inscription>();
		for (int i = 0; i < 8; i++) {
			Utilisateur u = new Utilisateur("User"+ i, "u"+i+"@b.c", "toto" + i);
			users.add(u);
		}
		 
		LOGGER.debug("Generation des inscriptions a partir des users");
		for (Utilisateur u : users) {
			Inscription i = new Inscription();
			i.setId(new InscriptionKey(u, champ));
			inscrits.add(i);
			utilisateurService.save(u);
			inscriptionService.createOrUpdate(i);
		}
		LOGGER.debug("Inscrits sauvegardés");
		
		LOGGER.debug("Inscrits dans le tournoi");
		champ.setListeInscriptions(inscrits);
		champ.setNbParticipantsTotal(tournoiService.getNbInscriptionTournoi(champ));
		tournoiService.createOrUpdate(champ);
		LOGGER.debug("Tournoi sauvegardé");
		
		matchGenService.initChampionnat(champ);

	}

}
