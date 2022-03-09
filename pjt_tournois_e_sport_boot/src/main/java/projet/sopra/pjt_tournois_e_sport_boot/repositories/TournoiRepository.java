package projet.sopra.pjt_tournois_e_sport_boot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.sopra.pjt_tournois_e_sport_boot.model.Tournoi;

public interface TournoiRepository extends JpaRepository<Tournoi, Long>{
	List<Tournoi> findByNom(String nom);
	
	List<Tournoi> findByNomContaining(String nom);
	
	@Query("select COUNT(*) from Inscription as i where i.id.tournoi.id = :id_tournoi ")
	int getNbInscriptionTournoi(@Param("id_tournoi") long idTournoi);

}
