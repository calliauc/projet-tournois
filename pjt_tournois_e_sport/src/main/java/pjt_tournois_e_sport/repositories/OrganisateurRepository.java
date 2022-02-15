package pjt_tournois_e_sport.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pjt_tournois_e_sport.model.Organisateur;

public interface OrganisateurRepository extends JpaRepository<Organisateur, Long>{

	Optional<Organisateur> findByPseudo(String pseudo);
	
	Optional<Organisateur> findById(Long id);
	
	// Trouver l'organisateur en fonction de l'id du tournoi
	@Query("select o from Organisateur o left join fetch o.tournois where o.idCompte = :IdTournoi")
	Optional<Organisateur> findOrganisateurWithTournois(@Param("IdTournoi") Long IdTournoi);
	
}
