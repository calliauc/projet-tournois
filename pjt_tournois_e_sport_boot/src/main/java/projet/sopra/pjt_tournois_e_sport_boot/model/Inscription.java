package projet.sopra.pjt_tournois_e_sport_boot.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="inscription")

public class Inscription {
	
	/// ATTRIBUTES
	@EmbeddedId
	private InscriptionKey id;
	@Column(name="position")
	private int position ;
	@Column(name="score")
	private int score ;
	@ManyToOne
	@JoinColumn(name = "inscription_prochain_match_id", foreignKey = @ForeignKey(name="inscription_prochain_match_fk"))
	private Match prochainMatch;
	
	/// CONSTRUCTOR
	public Inscription() {
		
	}
	


	public Inscription(int position, int score, Match prochainMatch) {
		super();
		this.position = position;
		this.score = score;
		this.prochainMatch = prochainMatch;
	}

	/// GETTERS
	public int getPosition() {
		return position;
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
	
	
 
}
