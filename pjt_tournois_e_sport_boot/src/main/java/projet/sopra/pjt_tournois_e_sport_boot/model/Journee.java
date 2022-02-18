package projet.sopra.pjt_tournois_e_sport_boot.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;

@Entity
@Table(name = "journee")
@SequenceGenerator(name = "seqJournee", sequenceName = "seq_journee", initialValue = 100, allocationSize = 1)

public class Journee {

	/// ATTRIBUTES

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqJournee")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "journee_tournoi", foreignKey = @ForeignKey(name = "journee_tournoi_fk"))
	private Tournoi tournoi;

	@OneToMany(mappedBy = "journee")
	private Set<Match> matchsAJouerPourJournee;
	@FutureOrPresent
	@Column(name = "journee_date_debut")
	private LocalDateTime dateDebutJournee;
	@Future
	@Column(name = "journee_date_fin")
	private LocalDateTime dateFinJournee;
	@Enumerated(EnumType.STRING)
	@Column(name = "journee_etape")
	private Etape etape;

	/// CONSTRUCTOR

	public Journee() {

	}

	public Journee(Tournoi tournoi, LocalDateTime dateDebutJournee, LocalDateTime dateFinJournee, Etape etape) {
		super();
		this.tournoi = tournoi;
		this.dateDebutJournee = dateDebutJournee;
		this.dateFinJournee = dateFinJournee;
		this.etape = etape;
	}

	/// GETTERS

	public Long getId() {
		return id;
	}

	public Tournoi getTournoi() {
		return tournoi;
	}

	public Set<Match> getMatchsAJouerPourJournee() {
		return matchsAJouerPourJournee;
	}

	public LocalDateTime getDateDebutJournee() {
		return dateDebutJournee;
	}

	public LocalDateTime getDateFinJournee() {
		return dateFinJournee;
	}

	public Etape getEtape() {
		return etape;
	}

	/// SETTERS

	public void setId(Long idJournee) {
		this.id = idJournee;
	}

	public void setTournoi(Tournoi tournoi) {
		this.tournoi = tournoi;
	}

	public void setMatchsAJouerPourJournee(Set<Match> matchsAJouerPourJournee) {
		this.matchsAJouerPourJournee = matchsAJouerPourJournee;
	}

	public void setDateDebutJournee(LocalDateTime dateDebutJournee) {
		this.dateDebutJournee = dateDebutJournee;
	}

	public void setDateFinJournee(LocalDateTime dateFinJournee) {
		this.dateFinJournee = dateFinJournee;
	}

	public void setEtape(Etape etape) {
		this.etape = etape;
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
		Journee other = (Journee) obj;
		return Objects.equals(id, other.id);
	}


}
