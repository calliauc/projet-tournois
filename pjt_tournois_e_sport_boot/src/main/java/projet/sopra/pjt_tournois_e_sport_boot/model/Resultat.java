package projet.sopra.pjt_tournois_e_sport_boot.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Resultat")
@SequenceGenerator(name="seqResultat", sequenceName = "seq_resultat",initialValue=100,allocationSize = 1)
public class Resultat {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqResultat")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "resultat_match_id", foreignKey = @ForeignKey(name="resultat_match_fk"))
	private Match match;
	
	@OneToOne
	@JoinColumns(
			{@JoinColumn(name = "resultat_participant_id", foreignKey = @ForeignKey(name="resultat_participant_fk")),
			@JoinColumn(name="resultat_tournoi_id",  foreignKey = @ForeignKey(name="resultat_tournoi_fk"))})
	private Inscription participant;
	
	@Column(name="position_match")
	private int positionMatch;
	
	@Column(name="score_match")
	private int scoreMatch;

	public Resultat() {
	}

	public Resultat(Match match, Inscription participant, int positionMatch, int scoreMatch) {
		super();
		this.match = match;
		this.participant = participant;
		this.positionMatch = positionMatch;
		this.scoreMatch = scoreMatch;
	}

	public Long getId() {
		return id;
	}

	public Match getMatch() {
		return match;
	}

	public Inscription getParticipant() {
		return participant;
	}

	public int getPositionMatch() {
		return positionMatch;
	}

	public int getScoreMatch() {
		return scoreMatch;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public void setParticipant(Inscription participant) {
		this.participant = participant;
	}

	public void setPositionMatch(int positionMatch) {
		this.positionMatch = positionMatch;
	}

	public void setScoreMatch(int scoreMatch) {
		this.scoreMatch = scoreMatch;
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
		Resultat other = (Resultat) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}