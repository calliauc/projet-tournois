package projet.sopra.pjt_tournois_e_sport_boot.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "championnat")
public class Championnat extends Tournoi {

	/// ATTRIBUTES
	@OneToMany(mappedBy = "tournoi")
	private List<Journee> JourneesAJouerPoules = new ArrayList<Journee>();
	@OneToMany(mappedBy = "id")
	private List<Journee> JourneesAJouerFinales = new ArrayList<Journee>();
	@Transient
	private List<Poule> poules = new ArrayList<Poule>();
	@Column(name = "prochaine_etape_finale")
	private Etape prochaineEtape;

//	private int nbPoules = 0; remplace par prochaineEtape.getNbMatches();

	/// CONSTRUCTORS

	public Championnat() {

	}

	public Championnat(String nom, LocalDate dateDeDebut, String jeu, Set<Inscription> listeInscriptions) {
		super(nom, dateDeDebut, jeu, listeInscriptions);

	}

	/// GETTERS

	public List<Journee> getJourneesAJouerPoules() {
		return JourneesAJouerPoules;
	}

	public List<Journee> getJourneesAJouerFinales() {
		return JourneesAJouerFinales;
	}

	public List<Poule> getPoules() {
		return poules;
	}

	public Etape getProchaineEtape() {
		return prochaineEtape;
	}

//	public int getNbPoules() {
//		return nbPoules;
//	}
	/// SETTERS

	public void setJourneesAJouerPoules(List<Journee> journeesAJouerPoules) {
		JourneesAJouerPoules = journeesAJouerPoules;
	}

	public void setJourneesAJouerFinales(List<Journee> journeesAJouerFinales) {
		JourneesAJouerFinales = journeesAJouerFinales;
	}

	public void setPoules(List<Poule> poules) {
		this.poules = poules;
	}

	public void setProchaineEtape(Etape prochaineEtape) {
		this.prochaineEtape = prochaineEtape;
	}

//	public void setNbPoules(int nbPoules) {
//		this.nbPoules = nbPoules;
//	}

	
	

}
