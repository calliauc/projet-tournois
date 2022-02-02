package pjt_tournois_e_sport.model;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Joueur")
@SequenceGenerator(name ="seqCompte", sequenceName ="seq_joueur", initialValue = 100, allocationSize = 1)
@AttributeOverrides({ @AttributeOverride(name = "idCompte", column = @Column(name = "joueur_id")),
	@AttributeOverride(name = "pseudo", column = @Column(name = "joueur_pseudo", length = 200)),
	@AttributeOverride(name = "password", column = @Column(name = "joueur_password", length = 200)),
	@AttributeOverride(name = "mail", column = @Column(name = "joueur_mail")) })
public class Joueur extends Compte {
	
	@Column(name="tournois_joues")
	@OneToMany(mappedBy="id.joueur")
	private Set<Tournoi> tournois;

	public Joueur() {
		
	}
	
	public Joueur(String pseudo, String password, String mail) {
		super(pseudo, password, mail);
		// TODO Auto-generated constructor stub
	}

	public Set<Tournoi> getTournois() {
		return tournois;
	}

	public void setTournois(Set<Tournoi> tournois) {
		this.tournois = tournois;
	}

	
	
	
	

}
