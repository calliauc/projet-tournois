package projet.sopra.pjt_tournois_e_sport_boot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.sopra.pjt_tournois_e_sport_boot.model.Inscription;
import projet.sopra.pjt_tournois_e_sport_boot.model.Journee;
import projet.sopra.pjt_tournois_e_sport_boot.model.Match;
import projet.sopra.pjt_tournois_e_sport_boot.model.Tournoi;

public interface MatchRepository extends JpaRepository<Match, Long> {
	
//	@Query("select m from Match m left join fetch m.journee as mjournee where mjournee.dateDebutJournee=:dateDebut")
//	List<Match> findByDateWithJournees(@Param("dateDebutJournee") LocalDateTime dateDebut);
	
	@Query("select m FROM Match m WHERE :inscription MEMBER OF m.inscriptions")
	List<Match> getMatchsWithInscription(@Param("inscription") Inscription inscription);

	
	@Query("select m FROM Match m WHERE tournoi = :tournoi AND match_is_fini = false")
	List<Match> getMatchsNotFinishedInTournoi(@Param("tournoi") Tournoi tournoi);
	
	List<Match> findByJournee(Journee journee);
	
	@Query("select m from Match m join m.journee as mjournee where mjournee.tournoi = :tournoi")
	List<Match> getMatchByTournoi(@Param("tournoi") Tournoi tournoi);

}
