package projet.sopra.pjt_tournois_e_sport_boot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.sopra.pjt_tournois_e_sport_boot.model.Resultat;

public interface ResultatRepository extends JpaRepository<Resultat, Long>{
	Optional<Resultat> findById(Long id);
}
