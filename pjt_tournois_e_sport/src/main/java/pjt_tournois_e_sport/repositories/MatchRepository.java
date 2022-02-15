package pjt_tournois_e_sport.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pjt_tournois_e_sport.model.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {
	
	@Query("select m from Match m left join fetch m.journee as mjournee where mjournee.dateDebutJournee=:dateDebut")
	List<Match> findByDateWithJournees(@Param("dateDebutJournee") LocalDateTime dateDebut);
	

}
