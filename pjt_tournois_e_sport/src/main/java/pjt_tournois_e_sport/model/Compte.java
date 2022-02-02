package pjt_tournois_e_sport.model;

import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@MappedSuperclass
public abstract class Compte {
	
	/// ATTRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCompte")
	protected Long idCompte ; 
	protected String pseudo; 
	protected String password; 
	protected String mail;
	
	
	
	/// CONSTRUCTOR
	public Compte() {
		
	}
	
	public Compte(String pseudo, String password, String mail) {
		 	
		this.pseudo = pseudo;
		this.password = password;
		this.mail = mail;
		
	}

	/// GETTERS

	public Long getIdCompte() {
		return idCompte;
	}

	public String getPseudo() {
		return pseudo;
	}

	public String getPassword() {
		return password;
	}

	public String getMail() {
		return mail;
	}

	/// SETTERS
	
	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCompte);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		return idCompte == other.idCompte;
	} 
	
	
	

}
