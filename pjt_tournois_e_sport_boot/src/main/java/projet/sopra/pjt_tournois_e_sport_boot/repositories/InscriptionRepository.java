package projet.sopra.pjt_tournois_e_sport_boot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.sopra.pjt_tournois_e_sport_boot.model.Inscription;
import projet.sopra.pjt_tournois_e_sport_boot.model.InscriptionKey;

public interface InscriptionRepository extends JpaRepository<Inscription, InscriptionKey> {
	
	@Query(value="select i from inscription i left join fetch i.score where i.score between :score1 and :score2", nativeQuery = true)
	List<Inscription> findByScoreBetween(@Param("score1") int scoreLow, @Param("score2") int scoreHigh);
}
