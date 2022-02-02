package pjt_tournois_e_sport.model;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Championnat extends Tournoi {

	/// ATTRIBUTES
	
	/// CONSTRUCTOR
	
	public Championnat(String nom, LocalDate dateDeCreation, LocalDate dateDeDebut, String jeu,
			LinkedList<Joueur> listeJoueurs) {
		super(nom, dateDeCreation, dateDeDebut, jeu, listeJoueurs);
		// TODO Auto-generated constructor stub
	}

	
	/// METHODS
	
	private void phasePoule() 
	{
		
	}
	
	private void phaseFinale()
	{
		
	}
	
	private void SetPositionFinale(List<Classement> classement)
	{
		
	}
}
