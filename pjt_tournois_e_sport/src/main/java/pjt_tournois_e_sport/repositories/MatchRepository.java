package pjt_tournois_e_sport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pjt_tournois_e_sport.model.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {
	
//	@Query("select m from Match m left join fetch m.journee as mjournee where mjournee.DateDebutJournee=:dateDebut and mjournee.DateFinJournee=:dateFin")
//	List<Match> findByDateWithJournees(@Param("journee_date_debut") LocalDate dateDebut, @Param("journee_date_fin") LocalDate dateFIn);
	

}
