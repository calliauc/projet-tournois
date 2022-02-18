package projet.sopra.pjt_tournois_e_sport_boot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.sopra.pjt_tournois_e_sport_boot.model.Tournoi;

public interface TournoiRepository extends JpaRepository<Tournoi, Long>{
	List<Tournoi> findByNom(String nom);
	
	List<Tournoi> findByNomContaining(String nom);
}
