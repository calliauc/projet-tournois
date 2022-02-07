package pjt_tournois_e_sport.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pjt_tournois_e_sport.model.Joueur;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {
	List<Joueur> findByPseudo(String pseudo);

	List<Joueur> findByPseudoLike(String pseudo);

	List<Joueur> findByPseudoStartingWith(String pseudo);

	List<Joueur> findByPseudoContaining(String pseudo);

	Optional<Joueur> findByIdCompteAndPseudo(Long id, String pseudo);

	List<Joueur> findByIdCompteOrPseudo(Long id, String pseudo);
}
