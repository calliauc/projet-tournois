package projet.sopra.pjt_tournois_e_sport_boot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	
	List<Journee> findByTournoiAndNumero(Tournoi tournoi, int numero);
	
	@Query("select j FROM Journee j WHERE j.tournoi = :tournoi ORDER BY j.numero asc")
	List<Journee> getJourneesOrderByNumero(@Param("tournoi") Tournoi tournoi);
	
	<Optional>Journee findByNumeroAndTournoi(int numero, Tournoi tournoi);

}
