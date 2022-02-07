package pjt_tournois_e_sport.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
@Table(name="Match")
@SequenceGenerator(name="seqMatch", sequenceName = "seq_match",initialValue=100,allocationSize = 1)
public class Match {

	/// ATTRIBUTES
	@Id
	@Column(name="match_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMatch")
	private Long id;
	
	@OneToMany(mappedBy = "prochainMatch")
	private List<Inscription> inscriptions;
	
	@ManyToOne
	@JoinColumn(name = "match_journee_id", foreignKey = @ForeignKey(name="inscription_prochain_match_fk"))
	private Journee journee;
	
//	@Column(name="resultat")
//	private Map<Inscription,Integer> resultat = new HashMap<Inscription, Integer>();
	
	/// CONSTRUCTOR
	public Match() {
	}

	public Match(List<Inscription> inscriptions, Journee journee) {
		super();
		this.inscriptions = inscriptions;
		this.journee = journee;
//		this.resultat = resultat;
	}

	
	/// GETTERS
	
	public Long getId() {
		return id;
	}

	public List<Inscription> getInscriptions() {
		return inscriptions;
	}

	public Journee getJournee() {
		return journee;
	}

//	public Map<Inscription, Integer> getResultat() {
//		return resultat;
//	}

	
	/// SETTERS
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public void setJournee(Journee journee) {
		this.journee = journee;
	}

//	public void setResultat(Map<Inscription, Integer> resultat) {
//		this.resultat = resultat;
//	}

	
		
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
		Match other = (Match) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
}
