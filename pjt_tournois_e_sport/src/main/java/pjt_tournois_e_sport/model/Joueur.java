package pjt_tournois_e_sport.model;

public class Joueur extends Compte {
	

	public Joueur(int idCompte, String pseudo, String password, String mail) {
		super(idCompte, pseudo, password, mail);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Joueur [idCompte=" + idCompte + ", pseudo=" + pseudo + ", password=" + password + ", mail=" + mail
				+ "]";
	}
	
	
	

}
