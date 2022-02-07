package pjt_tournois_e_sport.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pjt_tournois_e_sport.model.Tournoi;

public interface TournoiRepository extends JpaRepository<Tournoi, Long>{
	List<Tournoi> findByNom(String nom);
	
	List<Tournoi> findByNomContaining(String nom);
}
