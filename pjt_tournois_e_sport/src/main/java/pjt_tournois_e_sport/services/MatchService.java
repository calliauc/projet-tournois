package pjt_tournois_e_sport.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pjt_tournois_e_sport.exceptions.MatchException;
import pjt_tournois_e_sport.exceptions.TournoiException;
import pjt_tournois_e_sport.model.Match;
import pjt_tournois_e_sport.repositories.MatchRepository;

@Service
public class MatchService {

	@Autowired
	private MatchRepository matchRepo;
	
	public List<Match> getAll(){
		return matchRepo.findAll();
	}
	
	public List<Match> findByDateWithJournees(LocalDate dateDebut, LocalDate dateFin){
		return matchRepo.findByDateWithJournees(dateDebut, dateFin);
	}
	
	public Match getById(Long id) {
		return matchRepo.findById(id).orElseThrow(() -> {
			throw new MatchException("match inconnu");
		});
	}

	public Match createOrUpdate(Match m) {
		if (m == null) {
			throw new MatchException();
		}
		Match matchEnBase = null;
		if (m.getId() == null) {
			// create
			// controle des donnees
			checkData(m);
			return matchRepo.save(m);
		} else {
			// update (gestion de la version)
			matchEnBase = this.getById(m.getId());
			checkData(m);
			matchEnBase.setJournee(m.getJournee());
			return matchRepo.save(matchEnBase);
		}
	}
	
	private void checkData(Match m) {
		if (m.getJournee() == null) {
			throw new MatchException("donnees incorrectes");
		}
	}
	
	public void delete(Match m) {
		if (m == null || m.getId() == null) {
			throw new TournoiException();
		}
		Match tournoiEnBase = matchRepo.findById(m.getId()).orElseThrow(TournoiException::new);
		matchRepo.delete(tournoiEnBase);
	}

}
