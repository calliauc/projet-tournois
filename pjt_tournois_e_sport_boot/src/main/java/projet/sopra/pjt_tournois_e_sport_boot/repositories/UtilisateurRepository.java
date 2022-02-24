package projet.sopra.pjt_tournois_e_sport_boot.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.sopra.pjt_tournois_e_sport_boot.model.InscriptionKey;
import projet.sopra.pjt_tournois_e_sport_boot.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

	///// REQUETES GENERALES

	Optional<Utilisateur> findById(Long id);

	Optional<Utilisateur> findByUsername(String username);

	List<Utilisateur> findByUsernameLike(String username);

	List<Utilisateur> findByUsernameStartingWith(String username);

	List<Utilisateur> findByUsernameContaining(String username);

	Optional<Utilisateur> findByIdAndUsername(Long id, String username);

	List<Utilisateur> findByIdOrUsername(Long id, String username);
	
	@Query("select u from Utilisateur u left join fetch u.roles where u.username=:username")
	Optional<Utilisateur> findByUsernameWithRoles(@Param("username") String username);

	////// REQUETES JOUEURS

	@Query("select j from Utilisateur j left join fetch j.inscriptions where j.id = :Id")
	Optional<Utilisateur> findJoueurWithInscriptions(@Param("Id") InscriptionKey Id);

	////// REQUETES ORGANISATEURS

	// Trouver l'organisateur en fonction de l'id du tournoi
	@Query("select o from Utilisateur o left join fetch o.tournois where o.id = :IdTournoi")
	Optional<Utilisateur> findOrganisateurWithTournois(@Param("IdTournoi") Long IdTournoi);

}