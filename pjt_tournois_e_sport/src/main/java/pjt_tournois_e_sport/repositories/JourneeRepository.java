package pjt_tournois_e_sport.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pjt_tournois_e_sport.model.Etape;
import pjt_tournois_e_sport.model.Journee;
import pjt_tournois_e_sport.model.Tournoi;


public interface JourneeRepository extends JpaRepository<Journee, Long>{
	
	List<Journee> findByTournoi(Tournoi tournoi); 
	
	List<Journee> findByTournoiAndEtape(Tournoi tournoi, Etape etape);
	
	List<Journee> findByDateDebutJournee(LocalDateTime DateDebut);
	
	List<Journee> findByDateFinJournee(LocalDateTime DateFin);
	
	
	

}
