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
	@JoinColumn(name = "inscription_tournoi_id", foreignKey = @ForeignKey(name = "inscription_tournoi_id_fk"))
	private Tournoi tournoi;
	@ManyToOne
	@JoinColumn(name = "inscription_joueur_id", foreignKey = @ForeignKey(name = "inscription_joueur_id_fk"))
	private Joueur joueur;
	
	public InscriptionKey() {
		
	}

	public InscriptionKey(Tournoi tournoi, Joueur joueur) {
		
		this.tournoi = tournoi;
		this.joueur = joueur;
	}

	public Tournoi getTournoi() {
		return tournoi;
	}

	public void setTournoi(Tournoi tournoi) {
		this.tournoi = tournoi;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
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
