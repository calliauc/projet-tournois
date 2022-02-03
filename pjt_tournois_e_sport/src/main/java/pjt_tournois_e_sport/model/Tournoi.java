package pjt_tournois_e_sport.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name="seqTournoi", sequenceName = "seq_tournoi",initialValue = 100,allocationSize = 1)
public abstract class Tournoi {

	/// ATTRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTournoi")
	private int idTournoi ; 
	@Column(name="tournoi_nom", length = 50, nullable =false)
	private String nom; 
	@Column(name="tournoi_date_creation", nullable =false)
	private LocalDate dateDeCreation ; 
	@Column(name="tournoi_date_debut", nullable =false)
	private LocalDate dateDeDebut ;
	@Column(name="tournoi_jeu", length = 50, nullable =false)
	
	private String Jeu ; 
	@OneToMany(mappedBy="id.tournoi")
	private Set<Inscription> listeInscriptions = new HashSet<Inscription>() ;
	
	/// CONSTRUCTOR
	
	
	
	public Tournoi() {
	}

	
	public Tournoi(String nom, LocalDate dateDeCreation, LocalDate dateDeDebut, String jeu,
			Set<Inscription> listeInscriptions) {
		super();
		this.nom = nom;
		this.dateDeCreation = dateDeCreation;
		this.dateDeDebut = dateDeDebut;
		Jeu = jeu;
		this.listeInscriptions = listeInscriptions;
	}


	/// GETTERS
	
	public int getIdTournoi() {
		return idTournoi;
	}

	public String getNom() {
		return nom;
	}

	public LocalDate getDateDeCreation() {
		return dateDeCreation;
	}

	public LocalDate getDateDeDebut() {
		return dateDeDebut;
	}

	public String getJeu() {
		return Jeu;
	}

	
	/// SETTERS
	
	public Set<Inscription> getListeInscriptions() {
		return listeInscriptions;
	}

	public void setIdTournoi(int idTournoi) {
		this.idTournoi = idTournoi;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setDateDeCreation(LocalDate dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public void setDateDeDebut(LocalDate dateDeDebut) {
		this.dateDeDebut = dateDeDebut;
	}

	public void setJeu(String jeu) {
		Jeu = jeu;
	}

	public void setListeInscriptions(Set<Inscription> listeInscriptions) {
		this.listeInscriptions = listeInscriptions;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idTournoi);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tournoi other = (Tournoi) obj;
		return idTournoi == other.idTournoi;
	}
	
	
	
	
}
