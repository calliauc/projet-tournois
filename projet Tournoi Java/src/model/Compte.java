package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Compte {
	
	/// ATTRIBUTES
	
	protected int idCompte ; 
	protected String pseudo; 
	protected String password; 
	protected String mail;
	
	public List<Compte> Users =new ArrayList();
	
	/// CONSTRUCTOR
	
	
	public Compte(int idCompte, String pseudo, String password, String mail) {
		
		this.idCompte = idCompte ; 	
		this.pseudo = pseudo;
		this.password = password;
		this.mail = mail;
		
	}

	/// GETTERS

	public int getIdCompte() {
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
	
	public void setIdCompte(int idCompte) {
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
	
	
	

}
