package pjt_tournois_e_sport.model;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="championnat")
public class Championnat extends Tournoi {
	
	/// ATTRIBUTES
	@OneToMany(mappedBy="id.tournoi")
	private Set<Journee> JourneesAJouerPoules;
	@OneToMany(mappedBy="id.tournoi")
	private Set<Journee> JourneesAJouerFinales;
	
	

	/// CONSTRUCTORS
	
	public Championnat() {
		
	}
	
	public Championnat(String nom, LocalDate dateDeCreation, LocalDate dateDeDebut, String jeu,
			Set<Inscription> listeInscriptions) {
		super(nom, dateDeCreation, dateDeDebut, jeu, listeInscriptions);

	}

		
	/// GETTERS


	
	/// SETTERS

	
	

}
