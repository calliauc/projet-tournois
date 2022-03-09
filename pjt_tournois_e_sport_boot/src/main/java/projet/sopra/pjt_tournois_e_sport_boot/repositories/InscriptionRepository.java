package projet.sopra.pjt_tournois_e_sport_boot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.sopra.pjt_tournois_e_sport_boot.model.Inscription;
import projet.sopra.pjt_tournois_e_sport_boot.model.InscriptionKey;

public interface InscriptionRepository extends JpaRepository<Inscription, InscriptionKey> {

	@Query("select i from Inscription i where score between :score1 and :score2")
	List<Inscription> findByScoreBetween(@Param("score1") int scoreLow, @Param("score2") int scoreHigh);

	@Query("select i from Inscription as i where i.id.tournoi.id = :id_tournoi order by i.score desc, i.scoreDifference desc ")
	List<Inscription> getClassementLigue(@Param("id_tournoi") long idTournoi);

}
