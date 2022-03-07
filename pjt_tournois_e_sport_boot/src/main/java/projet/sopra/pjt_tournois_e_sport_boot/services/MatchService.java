package projet.sopra.pjt_tournois_e_sport_boot.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.sopra.pjt_tournois_e_sport_boot.exceptions.MatchException;
import projet.sopra.pjt_tournois_e_sport_boot.exceptions.TournoiException;
import projet.sopra.pjt_tournois_e_sport_boot.model.Match;
import projet.sopra.pjt_tournois_e_sport_boot.model.Resultat;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.MatchRepository;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.ResultatRepository;

@Service
public class MatchService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MatchService.class);
	
	@Autowired
	private MatchRepository matchRepo;
	
	@Autowired
	private ResultatRepository resultatRepo; 
	
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
//		checkData(m);
//		if (m.getId() == null) {
//			throw new MatchException();
//		}
		Match matchEnBase = matchRepo.findById(m.getId()).orElseThrow(MatchException::new);
		if (matchEnBase.getResultats() != null) {
			LOGGER.info("GO SUPPR RESULTAT");
			for (Resultat r : matchEnBase.getResultats()) {
				resultatRepo.delete(r);
			}
		}
		matchRepo.delete(matchEnBase);
	}
	
	public void deleteById(Long id) {
		matchRepo.deleteById(id);
	}

	private void checkData(Match m) {
		if(m==null) {
			throw new MatchException("pas de match renseigne");
		}
		
		if (m.getJournee() == null || m.getInscriptions().isEmpty()) {
			throw new MatchException("donnees incorrectes");
		}
	}
	
	public boolean exist (Long id) {
		return matchRepo.existsById(id);
	}
}
