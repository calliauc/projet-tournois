package pjt_tournois_e_sport.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="admin")
@SequenceGenerator(name = "seqCompte", sequenceName = "seq_admin", initialValue = 10, allocationSize = 1)
@AttributeOverrides({ @AttributeOverride(name = "idCompte", column = @Column(name = "admine_id")),
	@AttributeOverride(name = "pseudo", column = @Column(name = "admin_pseudo", length = 200)),
	@AttributeOverride(name = "password", column = @Column(name = "admin_password", length = 200)),
	@AttributeOverride(name = "mail", column = @Column(name = "admin_mail")) })
public class Admin extends Compte {

	public Admin() {
		
	}
	public Admin( String pseudo, String password, String mail) {
		super(pseudo, password, mail);
		// TODO Auto-generated constructor stub
	}

}
