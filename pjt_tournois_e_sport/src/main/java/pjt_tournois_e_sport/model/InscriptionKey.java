package pjt_tournois_e_sport.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class InscriptionKey implements Serializable {
	
	@ManyToOne
	@JoinColumn(name="joueur_inscription_id" , foreignKey= @ForeignKey(name="joueur_inscription__id_fk"))
	private Joueur joueur;
	@ManyToOne
	@JoinColumn(name="tournoi_inscription_id" , foreignKey= @ForeignKey(name="tournoi_inscription__id_fk"))
	private Tournoi tournoi;
	
	public InscriptionKey() {
		
	}
	
	public InscriptionKey(Joueur joueur, Tournoi tournoi) {
		super();
		this.joueur = joueur;
		this.tournoi = tournoi;
	}

	

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public Tournoi getTournoi() {
		return tournoi;
	}

	public void setTournoi(Tournoi tournoi) {
		this.tournoi = tournoi;
	}

	@Override
	public int hashCode() {
		return Objects.hash(joueur, tournoi);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InscriptionKey other = (InscriptionKey) obj;
		return Objects.equals(joueur, other.joueur) && Objects.equals(tournoi, other.tournoi);
	}

	
	
	
}
