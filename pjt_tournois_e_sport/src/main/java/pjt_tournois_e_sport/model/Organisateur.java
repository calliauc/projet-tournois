package pjt_tournois_e_sport.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="organisateur")
@SequenceGenerator(name = "seqCompte", sequenceName ="seq_organisateur", initialValue = 10, allocationSize = 1)
@AttributeOverrides({ @AttributeOverride(name = "idCompte", column = @Column(name = "organisateure_id")),
	@AttributeOverride(name = "pseudo", column = @Column(name = "organisateur_pseudo", length = 200)),
	@AttributeOverride(name = "password", column = @Column(name = "organisateur_password", length = 200)),
	@AttributeOverride(name = "mail", column = @Column(name = "organisateur_mail")) })
public class Organisateur extends Compte{

	@Column(name="tournois_organisés")
	@OneToMany(mappedBy="id")
	private List<Tournoi> tournois; 
	
	public Organisateur() {
		
	}
	
	public Organisateur(String pseudo, String password, String mail) {
		super( pseudo, password, mail);
		// TODO Auto-generated constructor stub
	}

	public List<Tournoi> getTournois() {
		return tournois;
	}

	public void setTournois(List<Tournoi> tournois) {
		this.tournois = tournois;
	}
	
	
}
