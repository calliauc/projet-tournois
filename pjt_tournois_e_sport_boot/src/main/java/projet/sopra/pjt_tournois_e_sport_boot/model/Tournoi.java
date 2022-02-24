package projet.sopra.pjt_tournois_e_sport_boot.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "seqTournoi", sequenceName = "seq_tournoi", initialValue = 100, allocationSize = 1)
public abstract class Tournoi {

	//// TO-DO annotations @JsonView

	/// ATTRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTournoi")

	protected Long idTournoi;
	@Column(name = "tournoi_nom", length = 50, nullable = false)
	protected String nom;
	@Column(name = "tournoi_date_creation", nullable = false)
	protected LocalDate dateDeCreation;
	@Column(name = "tournoi_date_debut", nullable = false)
	protected LocalDate dateDeDebut;
	@Column(name = "tournoi_jeu", length = 50, nullable = false)

	protected String jeu;
	@OneToMany(mappedBy = "id.tournoi")
	protected Set<Inscription> listeInscriptions = new HashSet<Inscription>();

	@Column(name = "tournoi_nb_participants_match", nullable = false)
	protected int nbParticipantsParMatch;

	@ManyToOne
	@JoinColumn(name = "organisteur_tournoi", foreignKey = @ForeignKey(name = "organisteur_tournoi_fk"))
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
	}

	/// GETTERS

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

	/// SETTERS

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
