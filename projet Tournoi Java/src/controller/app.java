package controller;
import model.Journee ; 
import model.Match;
import model.Tournoi;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;

import model.Joueur; ;


public class app {
	
	

	public static void generate_matchs_ligue(LinkedList<Joueur> participants, int idTournoi)
	{
		LinkedList<Journee> matchs_ligue = new LinkedList() ; 
		for (int i=0 ; i < participants.size()-1 ;  i++)
		{
			LinkedList<Match> liste_Match = new LinkedList() ;
			for(int j=0 ; j < participants.size()/2; j++)
			{
				Match m = new Match(participants.get(j).getIdCompte() , participants.get(j+participants.size()/2).getIdCompte(), i, idTournoi ) ;
				liste_Match.add(m);
			}
			
			Journee j = new Journee(i, idTournoi, liste_Match) ;
			matchs_ligue.add(j);
			
			participants.add(1,participants.pollLast() ); 
			System.out.println(participants);
		}
		System.out.println(matchs_ligue);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Joueur j1 = new Joueur(1, "a", "b", "c") ; 
		Joueur j2 = new Joueur(2, "r", "t", "y") ; 
		Joueur j3 = new Joueur(3, "e", "t", "o") ; 
		Joueur j4 = new Joueur(4, "k", "u", "i") ; 
		Joueur j5 = new Joueur(5, "o", "f", "j") ; 
		Joueur j6 = new Joueur(6, "l", "m", "g") ; 
		
		LinkedList<Joueur> listeParticipants = new LinkedList() ; 
		Collections.addAll(listeParticipants,j1, j2, j3, j4);
		
		Tournoi test = new Tournoi("test", LocalDate.now(), LocalDate.now() , "smash", listeParticipants) ; 
		
		
		
		generate_matchs_ligue(listeParticipants, test.getIdTournoi());
		
	}
	
	

}
