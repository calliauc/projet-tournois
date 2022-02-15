package pjt_tournois_e_sport.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pjt_tournois_e_sport.model.Inscription;
import pjt_tournois_e_sport.model.InscriptionKey;

public interface InscriptionRepository extends JpaRepository<Inscription, InscriptionKey> {
	@Query("select i from Inscription i left join fetch i.score where i.score between :score1 and :score2")
	List<Inscription> findByScoreBetween(@Param("score1") int scoreLow, @Param("score2") int scoreHigh);
}
