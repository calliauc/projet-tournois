package projet.sopra.pjt_tournois_e_sport_boot.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author theoc
 *
 */
@Entity
@Table(name = "inscription")

public class Inscription {

	/// ATTRIBUTES
	@EmbeddedId
	@JsonView({ Views.InscriptionWithId.class, Views.ResultatWithInscriptionAndMatch.class,
			Views.TournoiWithInscriptions.class, Views.UserWithIncriptions.class, Views.Match.class, Views.Classement.class, Views.JourneeWithTournoiAndMatch.class})
	private InscriptionKey id;
	@JsonView({Views.InscriptionWithId.class, Views.Classement.class})
	@Column(name = "position")
	@PositiveOrZero
	private int position;
	@JsonView({Views.InscriptionWithId.class, Views.Classement.class})
	@Column(name = "score")
	@PositiveOrZero
	private int score;
	/// somme des differences de scores de chaque match -- > sigma (score_joueur -
	/// score_adversaire) /!\ ne marche que pour les duels
	@JsonView({Views.InscriptionWithId.class, Views.Classement.class})
	@Column(name = "score_difference")
	private int scoreDifference;
	@JsonView(Views.InscriptionWithId.class)
	@ManyToOne
	@JoinColumn(name = "inscription_prochain_match_id", foreignKey = @ForeignKey(name = "inscription_prochain_match_fk"))
	private Match prochainMatch;
	@ManyToMany
	private List<Match> matchs = new ArrayList<Match>();
	
	
	@OneToMany(mappedBy = "participant", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonView(Views.InscriptionWithId.class)
	private List<Resultat> resultats;

	/// CONSTRUCTOR
	public Inscription() {

	}
	
	

	public Inscription(InscriptionKey id) {
		this.id = id;
	}



	public Inscription(int position, int score, Match prochainMatch) {
		super();
		this.position = position;
		this.score = score;
		this.prochainMatch = prochainMatch;
	}
	
	

	public Inscription(InscriptionKey id, @PositiveOrZero int position, @PositiveOrZero int score, int scoreDifference,
			Match prochainMatch) {
		this.id = id;
		this.position = position;
		this.score = score;
		this.scoreDifference = scoreDifference;
		this.prochainMatch = prochainMatch;
	}



	/// GETTERS
	
	public int getPosition() {
		return position;
	}

	public List<Match> getMatchs() {
		return matchs;
	}

	public void setMatchs(List<Match> matchs) {
		this.matchs = matchs;
	}

	public int getScore() {
		return score;
	}

	public InscriptionKey getId() {
		return id;
	}

	public Match getProchainMatch() {
		return prochainMatch;
	}

	public int getScoreDifference() {
		return scoreDifference;
	}

	/// SETTERS

	public void setProchainMatch(Match prochainMatch) {
		this.prochainMatch = prochainMatch;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setId(InscriptionKey id) {
		this.id = id;
	}

	public void setScoreDifference(int score_difference) {
		this.scoreDifference = score_difference;
	}
	

	public List<Resultat> getResultats() {
		return resultats;
	}



	public void setResultats(List<Resultat> resultats) {
		this.resultats = resultats;
	}



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
		Inscription other = (Inscription) obj;
		return Objects.equals(id, other.id);
	}

	//// COMPARATEURS POUR LA GENERATION DU CLASSEMENT (TRI PAR SCORES...)
	public static Comparator<Inscription> ComparatorScore = new Comparator<Inscription>() {

		@Override
		public int compare(Inscription e1, Inscription e2) {
			return (int) (e2.getScore() - e1.getScore());
		}
	};

	public static Comparator<Inscription> ComparatorScoreDiff = new Comparator<Inscription>() {

		@Override
		public int compare(Inscription e1, Inscription e2) {
			return (int) (e2.getScoreDifference() - e1.getScoreDifference());
		}
	};

	

}
