package projet.sopra.pjt_tournois_e_sport_boot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import projet.sopra.pjt_tournois_e_sport_boot.model.Championnat;
import projet.sopra.pjt_tournois_e_sport_boot.model.Inscription;

class ChampionnatTest {

	@Test
	void testChamp() {
		/*
		 * TODO:
		 * Creer championnat
		 * Set liste inscriptions
		 * Creer toutes les étapes
		 * 	Poules
		 * 	Finales
		 * Simuler les résultats poules
		 * Passer aux phases finales
		 * Simuler resultats finales
		 */
		
		Championnat champ = new Championnat();
		champ.setNom("Tournoi 1");
		champ.setJeu("Smash Bros");
		
		Inscription p1 = new Inscription();
		
	}

}
