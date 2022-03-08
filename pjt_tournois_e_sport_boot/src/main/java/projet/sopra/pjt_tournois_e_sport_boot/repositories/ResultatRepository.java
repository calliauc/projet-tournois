package projet.sopra.pjt_tournois_e_sport_boot.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.sopra.pjt_tournois_e_sport_boot.model.Inscription;
import projet.sopra.pjt_tournois_e_sport_boot.model.Match;
import projet.sopra.pjt_tournois_e_sport_boot.model.Resultat;

public interface ResultatRepository extends JpaRepository<Resultat, Long>{
	Optional<Resultat> findById(Long id);
	List<Resultat> findByParticipant(Inscription inscription); 
	Optional<Resultat> findByMatchAndParticipant(Match m, Inscription i);
	
	
}
