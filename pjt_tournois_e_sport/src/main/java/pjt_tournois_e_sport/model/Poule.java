package pjt_tournois_e_sport.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="poule")
public class Poule extends Ligue{

	public Poule() {

	}
	
	public Poule(String nom, LocalDate dateDeCreation, LocalDate dateDeDebut, String jeu,
			Set<Inscription> listeInscriptions, boolean isPoule, int nbPhase, Set<Match> matchsAJouerPourPhase) {
		super(nom, dateDeCreation, dateDeDebut, jeu, listeInscriptions, isPoule, nbPhase, matchsAJouerPourPhase);
	}
	
}
