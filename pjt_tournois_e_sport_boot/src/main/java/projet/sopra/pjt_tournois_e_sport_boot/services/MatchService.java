package projet.sopra.pjt_tournois_e_sport_boot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.sopra.pjt_tournois_e_sport_boot.exceptions.MatchException;
import projet.sopra.pjt_tournois_e_sport_boot.exceptions.TournoiException;
import projet.sopra.pjt_tournois_e_sport_boot.model.Match;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.MatchRepository;

@Service
public class MatchService {

	@Autowired
	private MatchRepository matchRepo;
	
	public List<Match> getAll(){
		return matchRepo.findAll();
	}
	
//	public List<Match> findByDateWithJournees(LocalDateTime dateDebut){
//		return matchRepo.findByDateWithJournees(dateDebut);
//	}
	
	public Match getById(Long id) {
		return matchRepo.findById(id).orElseThrow(() -> {
			throw new MatchException("match inconnu");
		});
	}

	public Match createOrUpdate(Match m) {
		checkData(m);
		if (m.getId() == null) {
			return matchRepo.save(m);
		} else {
			Match matchEnBase = null;
			matchEnBase = this.getById(m.getId());
			matchEnBase.setJournee(m.getJournee());
			return matchRepo.save(matchEnBase);
		}
	}
	
	public void delete(Match m) {
		checkData(m);
		if (m.getId() == null) {
			throw new TournoiException();
		}
		Match tournoiEnBase = matchRepo.findById(m.getId()).orElseThrow(TournoiException::new);
		matchRepo.delete(tournoiEnBase);
	}

	private void checkData(Match m) {
		if(m==null) {
			throw new MatchException("pas de match renseigne");
		}
		
		if (m.getJournee() == null || m.getInscriptions().isEmpty()) {
			throw new MatchException("donnees incorrectes");
		}
	}
}