package pjt_tournois_e_sport.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="journee")
@SequenceGenerator(name="seqJournee", sequenceName="seq_journee", initialValue=100, allocationSize=1)

public class Journee {
	
	/// ATTRIBUTES
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqJournee" )
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "journee_tournoi", foreignKey = @ForeignKey(name = "journee_tournoi_fk"))
	private Tournoi tournoi; 
	
	@OneToMany(mappedBy = "journee")
	private Set<Match> MatchsAJouerPourJournee;
	
	@Column(name="journee_date_debut")
	private LocalDateTime DateDebutJournee;
	
	@Column(name="journee_date_fin")
	private LocalDateTime DateFinJournee; 
	
	/// CONSTRUCTOR
	
	public Journee() {
		
	}

	public Journee(Tournoi tournoi, LocalDateTime dateDebutJournee, LocalDateTime dateFinJournee) {
		super();
		this.tournoi = tournoi;
		DateDebutJournee = dateDebutJournee;
		DateFinJournee = dateFinJournee;
	}

	
	
	

	/// GETTERS

	public Long getIdJournee() {
		return id;
	}

	public Tournoi getTournoi() {
		return tournoi;
	}

	public Set<Match> getMatchsAJouerPourJournee() {
		return MatchsAJouerPourJournee;
	}

	public LocalDateTime getDateDebutJournee() {
		return DateDebutJournee;
	}

	public LocalDateTime getDateFinJournee() {
		return DateFinJournee;
	}

	


	/// SETTERS

	public void setIdJournee(Long idJournee) {
		this.id = idJournee;
	}

	public void setTournoi(Tournoi tournoi) {
		this.tournoi = tournoi;
	}

	public void setMatchsAJouerPourJournee(Set<Match> matchsAJouerPourJournee) {
		MatchsAJouerPourJournee = matchsAJouerPourJournee;
	}

	public void setDateDebutJournee(LocalDateTime dateDebutJournee) {
		DateDebutJournee = dateDebutJournee;
	}

	public void setDateFinJournee(LocalDateTime dateFinJournee) {
		DateFinJournee = dateFinJournee;
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
