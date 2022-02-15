package pjt_tournois_e_sport.model;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="joueur")
@SequenceGenerator(name="seqCompte", sequenceName="seq_joueur", initialValue=100, allocationSize=1)
@AttributeOverrides({
		@AttributeOverride(name="idCompte" ,column=@Column(name="joueur_id")),
		@AttributeOverride(name="pseudo" ,column=@Column(name="joueur_pseudo", nullable = false)),
		@AttributeOverride(name="password", column=@Column(name="joueur_password", nullable = false)), 
		@AttributeOverride(name="mail", column=@Column(name="joueur_mail"))
})
public class Joueur extends Compte {
	@OneToMany(mappedBy="id.joueur")
	@Column(name="joueur_inscriptions")
	private Set<Inscription> inscriptions;

	
	public Joueur() {
		
	}
	public Joueur(String pseudo, String password, String mail) {
		super(pseudo, password, mail);
		// TODO Auto-generated constructor stub
	}
	
	
	public Set<Inscription> getInscriptions() {
		return inscriptions;
	}
	public void setInscriptions(Set<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	
	
	
	

}
