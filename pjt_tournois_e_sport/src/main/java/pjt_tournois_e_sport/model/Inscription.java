package pjt_tournois_e_sport.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="inscription")

public class Inscription {
	
	/// ATTRIBUTES
	@Column(name="position")
	private int position ;
	@Column(name="score")
	private int score ;
	@EmbeddedId
	private InscriptionKey id;
	@ManyToOne
	@JoinColumn(name = "inscription_prochain_match_id", foreignKey = @ForeignKey(name="inscription_prochain_match_fk"))
	private Match prochainMatch;
	
	
	/// CONSTRUCTOR
	public Inscription() {
		
	}
	public Inscription(int position, int score) {

		this.position = position;
		this.score = score;
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
	/// SETTERS
	

	
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
