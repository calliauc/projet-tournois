package projet.sopra.pjt_tournois_e_sport_boot.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "Match")
@SequenceGenerator(name = "seqMatch", sequenceName = "seq_match", initialValue = 100, allocationSize = 1)
public class Match {

	/// ATTRIBUTES
	@Id
	@Column(name = "match_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMatch")
	@JsonView({ Views.Match.class, Views.ResultatWithInscriptionAndMatch.class,
			Views.JourneeWithTournoiAndMatch.class, Views.TournoiWithInscriptions.class })
	private Long id;

	@ManyToMany(mappedBy="matchs")
	@JsonView({Views.MatchWithIncriptions.class, Views.JourneeWithTournoiAndMatch.class, Views.TournoiWithInscriptions.class})
	private List<Inscription> inscriptions = new ArrayList<Inscription>();
	
	@OneToMany(mappedBy = "prochainMatch")
	@JsonView({Views.MatchWithIncriptions.class, Views.JourneeWithTournoiAndMatch.class})
	private List<Inscription> inscriptionsProchainMatch = new ArrayList<Inscription>();

	@Column(name = "match_is_fini")
	@JsonView({Views.Match.class, Views.TournoiWithInscriptions.class})
	private boolean isFini = false;
	
	@ManyToOne
	@JoinColumn(name = "match_journee_id", foreignKey = @ForeignKey(name = "inscription_prochain_match_fk"))
	@JsonView(Views.Match.class)
	private Journee journee;

	@OneToMany(mappedBy = "match")
	@JsonView({Views.Match.class, Views.TournoiWithInscriptions.class})
	private List<Resultat> resultats;

	/// CONSTRUCTOR
	public Match() {
	}

	public Match(List<Inscription> inscriptions, Journee journee, List<Resultat> resultats) {
		super();
		this.inscriptions = inscriptions;
		this.journee = journee;
		this.resultats = resultats;
	}

	/// GETTERS

	public Long getId() {
		return id;
	}

	public List<Inscription> getInscriptions() {
		return inscriptions;
	}

	public Journee getJournee() {
		return journee;
	}

	public List<Resultat> getResultats() {
		return resultats;
	}
	
	public List<Inscription> getInscriptionsProchainMatch() {
		return inscriptionsProchainMatch;
	}

	public boolean isFini() {
		return this.isFini;
	}


	/// SETTERS

	public void setResultats(List<Resultat> resultats) {
		this.resultats = resultats;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public void setJournee(Journee journee) {
		this.journee = journee;
	}
	
	public void setInscriptionsProchainMatch(List<Inscription> inscriptionsProchainMatch) {
		this.inscriptionsProchainMatch = inscriptionsProchainMatch;
	}

	public void setIsFini(boolean isFini) {
		this.isFini = isFini;
	}
	
	/// METHODS

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Match other = (Match) obj;
		return Objects.equals(id, other.id);
	}

	/// GESTION CUSTOM

	/*
	 * TODO récupérer le premier selon la liste de resultats
	 */

	public Inscription getPremier() {
		Inscription w = new Inscription(); // Pour pas que ça plante
		return w;
	}

}
