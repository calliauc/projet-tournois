package pjt_tournois_e_sport.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="inscription")
public class Inscription {
	
	@EmbeddedId
	private InscriptionKey id; 
	@Column(name="inscription_position")
	private String position; 
	@Column(name="inscription_score")
	private int score;
	
	public Inscription() {
		
	}

	public InscriptionKey getId() {
		return id;
	}

	public void setId(InscriptionKey id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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
