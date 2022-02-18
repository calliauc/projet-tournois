package projet.sopra.pjt_tournois_e_sport_boot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.sopra.pjt_tournois_e_sport_boot.model.Etape;
import projet.sopra.pjt_tournois_e_sport_boot.model.Journee;
import projet.sopra.pjt_tournois_e_sport_boot.model.Tournoi;


public interface JourneeRepository extends JpaRepository<Journee, Long>{
	
	List<Journee> findByTournoi(Tournoi tournoi); 
	
	List<Journee> findByTournoiAndEtape(Tournoi tournoi, Etape etape);
	
//	List<Journee> findByDateDebutJournee(LocalDateTime DateDebut);
//	
//	List<Journee> findByDateFinJournee(LocalDateTime DateFin);
//	
	
	

}
