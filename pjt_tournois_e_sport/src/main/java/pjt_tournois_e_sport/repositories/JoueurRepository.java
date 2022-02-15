package pjt_tournois_e_sport.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pjt_tournois_e_sport.model.InscriptionKey;
import pjt_tournois_e_sport.model.Joueur;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {
	Optional<Joueur> findById(Long id);
	
	Optional<Joueur> findByPseudo(String pseudo);

	List<Joueur> findByPseudoLike(String pseudo);

	List<Joueur> findByPseudoStartingWith(String pseudo);

	List<Joueur> findByPseudoContaining(String pseudo);

	Optional<Joueur> findByIdCompteAndPseudo(Long id, String pseudo);

	List<Joueur> findByIdCompteOrPseudo(Long id, String pseudo);
	
	@Query("select j from Joueur j left join fetch j.inscriptions where j.idCompte = :Id")
	Optional<Joueur> findJoueurWithInscriptions(@Param("Id") InscriptionKey Id);
	
}
