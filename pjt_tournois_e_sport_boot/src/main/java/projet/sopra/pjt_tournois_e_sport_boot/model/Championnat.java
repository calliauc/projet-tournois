package projet.sopra.pjt_tournois_e_sport_boot.model;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="championnat")
public class Championnat extends Tournoi {
	
	/// ATTRIBUTES
	@OneToMany(mappedBy="tournoi")
	private Set<Journee> JourneesAJouerPoules;
//	@OneToMany(mappedBy="id")
//	private Set<Journee> JourneesAJouerFinales;
	
	

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
