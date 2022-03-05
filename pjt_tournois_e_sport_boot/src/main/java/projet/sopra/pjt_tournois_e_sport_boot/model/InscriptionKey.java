package projet.sopra.pjt_tournois_e_sport_boot.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
public class InscriptionKey implements Serializable {
	
	@ManyToOne
	@JoinColumn(name="joueur_inscription_id" , foreignKey= @ForeignKey(name="joueur_inscription__id_fk"))
	@JsonView({Views.InscriptionWithId.class,Views.ResultatWithInscriptionAndMatch.class,Views.TournoiWithInscriptions.class})
	private Utilisateur joueur;
	@ManyToOne
	@JoinColumn(name="tournoi_inscription_id" , foreignKey= @ForeignKey(name="tournoi_inscription__id_fk"))
	@JsonView({Views.InscriptionWithId.class,Views.ResultatWithInscriptionAndMatch.class})
	private Tournoi tournoi;
	
	public InscriptionKey() {
		
	}
	
	public InscriptionKey(Utilisateur joueur, Tournoi tournoi) {
		super();
		this.joueur = joueur;
		this.tournoi = tournoi;
	}

	

	public Utilisateur getJoueur() {
		return joueur;
	}

	public void setJoueur(Utilisateur joueur) {
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

	@Override
	public String toString() {
		return "InscriptionKey [joueur=" + joueur.getId() + ", tournoi=" + tournoi.getIdTournoi() + "]";
	}

		
	
	
}
