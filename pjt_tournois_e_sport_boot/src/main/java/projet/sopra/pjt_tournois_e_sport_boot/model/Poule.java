package projet.sopra.pjt_tournois_e_sport_boot.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "poule")
public class Poule extends Ligue {

	@ManyToOne
	@JoinColumn(name = "poule_championnat", foreignKey = @ForeignKey(name = "poule_championnat_fk"))
	private Championnat championnat;

	public Poule() {
		super();
	}

	public Poule(String nom, LocalDate dateDeDebut, String jeu, Set<Inscription> listeInscriptions, boolean isPoule,
			int nbPhase, Championnat championnat) {
		super(nom, dateDeDebut, jeu, listeInscriptions, isPoule, nbPhase);
		this.championnat = championnat;
	}

	public Championnat getChampionnat() {
		return championnat;
	}

	public void setChampionnat(Championnat championnat) {
		this.championnat = championnat;
	}

	@Override
	public String toString() {
		return "Poule [championnat=" + championnat + ", idTournoi=" + idTournoi + ", nom=" + nom + "]";
	}

}
