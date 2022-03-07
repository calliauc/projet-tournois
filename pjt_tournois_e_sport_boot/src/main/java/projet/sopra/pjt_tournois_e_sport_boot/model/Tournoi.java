package projet.sopra.pjt_tournois_e_sport_boot.model;

import java.time.LocalDate;
import java.util.HashSet;
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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "seqTournoi", sequenceName = "seq_tournoi", initialValue = 100, allocationSize = 1)


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property ="type")
@JsonSubTypes(
{
    @Type(value = Ligue.class, name = "ligue"),
    @Type(value = Championnat.class, name = "championnat")
})
public abstract class Tournoi {

	//// TO-DO annotations @JsonView

	/// ATTRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTournoi")
	@JsonView({Views.InscriptionWithId.class, Views.ResultatWithInscriptionAndMatch.class,Views.TournoiWithInscriptions.class,Views.JourneeWithTournoiAndMatch.class})
	protected Long idTournoi;
	@Column(name = "tournoi_nom", length = 50, nullable = false)
	@JsonView(Views.TournoiWithInscriptions.class)
	protected String nom;
	@Column(name = "tournoi_date_creation", nullable = false)
	@JsonView(Views.TournoiWithInscriptions.class)
	protected LocalDate dateDeCreation = LocalDate.now();
	@Column(name = "tournoi_date_debut")
	@JsonView(Views.TournoiWithInscriptions.class)
	protected LocalDate dateDeDebut = LocalDate.now();
	@Enumerated(EnumType.STRING)
	@Column(name = "tournoi_statut_temps")
	@JsonView(Views.TournoiWithInscriptions.class)
	protected StatutTemps statutTemps;
	@Enumerated(EnumType.STRING)
	@Column(name = "tournoi_statut_inscriptions")
	@JsonView(Views.TournoiWithInscriptions.class)
	protected StatutInscriptions statutInscriptions;
	@Column(name = "tournoi_jeu", length = 50)
	@JsonView(Views.TournoiWithInscriptions.class)
	protected String jeu;
	@OneToMany(mappedBy = "id.tournoi")
	@JsonView(Views.TournoiWithInscriptions.class)
	protected Set<Inscription> listeInscriptions = new HashSet<Inscription>();
	@Column(name = "tournoi_nb_participants_match")
	@JsonView(Views.TournoiWithInscriptions.class)
	protected int nbParticipantsParMatch;
	@Column(name="tournoi_nb_participants_total")
	@JsonView(Views.TournoiWithInscriptions.class)
	protected int nbParticipantsTotal;	
	@ManyToOne
	@JoinColumn(name = "organisteur_tournoi", foreignKey = @ForeignKey(name = "organisteur_tournoi_fk"))
	@JsonView(Views.TournoiWithInscriptions.class)
	protected Utilisateur organisateur;
	/// CONSTRUCTOR

	public Tournoi() {
	}

	/*
	 * EDIT (comm à supprimer)
	 * Suppression de dateCreation dans les parametres du constructeur.
	 * Ce sera toujours le moment de création de l'ojet par défaut.
	 */
	public Tournoi(String nom, LocalDate dateDeDebut, String jeu,
			Set<Inscription> listeInscriptions) {
		super();
		this.nom = nom;
		this.dateDeCreation = LocalDate.now();
		this.dateDeDebut = dateDeDebut;
		this.jeu = jeu;
		this.listeInscriptions = listeInscriptions;
//		this.statutInscriptions = StatutInscriptions.Inscription_En_Cours;
//		this.statutTemps = StatutTemps.A_venir;
	}

	/// GETTERS

	public int getNbParticipantsTotal() {
		return nbParticipantsTotal;
	}

	public Long getIdTournoi() {
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
		return jeu;
	}

	public int getNbParticipantsParMatch() {
		return nbParticipantsParMatch;
	}

	public StatutTemps getStatutTemps() {
		return statutTemps;
	}

	public StatutInscriptions getStatutInscriptions() {
		return statutInscriptions;
	}
	/// SETTERS

	public void setNbParticipantsTotal(int nbParticipantsTotal) {
		this.nbParticipantsTotal = nbParticipantsTotal;
	}

	public Set<Inscription> getListeInscriptions() {
		return listeInscriptions;
	}

	public void setIdTournoi(Long idTournoi) {
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
		this.jeu = jeu;
	}

	public void setListeInscriptions(Set<Inscription> listeInscriptions) {
		this.listeInscriptions = listeInscriptions;
	}

	public Utilisateur getOrganisateur() {
		return organisateur;
	}

	public void setOrganisateur(Utilisateur organisateur) {
		this.organisateur = organisateur;
	}

	public void setNbParticipantsParMatch(int nbParticipantsParMatch) {
		this.nbParticipantsParMatch = nbParticipantsParMatch;
	}

	public void setStatutTemps(StatutTemps statutTemps) {
		this.statutTemps = statutTemps;
	}

	public void setStatutInscriptions(StatutInscriptions statutInscriptions) {
		this.statutInscriptions = statutInscriptions;
	}

	///// METHODS
	
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
