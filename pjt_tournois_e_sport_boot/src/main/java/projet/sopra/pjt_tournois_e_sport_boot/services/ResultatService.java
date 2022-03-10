package projet.sopra.pjt_tournois_e_sport_boot.services;

import java.util.List;

import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.sopra.pjt_tournois_e_sport_boot.exceptions.ResultatException;
import projet.sopra.pjt_tournois_e_sport_boot.exceptions.UtilisateurException;
import projet.sopra.pjt_tournois_e_sport_boot.model.Ligue;
import projet.sopra.pjt_tournois_e_sport_boot.model.Match;
import projet.sopra.pjt_tournois_e_sport_boot.model.Poule;
import projet.sopra.pjt_tournois_e_sport_boot.model.Resultat;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.MatchRepository;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.ResultatRepository;

@Service
public class ResultatService {
	@Autowired
	private ResultatRepository resultatRepo;
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private MatchRepository matchRepo;
	
	@Autowired
	private SetClassementTournoiService classementService; 
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ResultatService.class);
	
	public List<Resultat> getAll() {
		return resultatRepo.findAll();
	}
	
	public Resultat getById(Long id) {
		return resultatRepo.findById(id).orElseThrow(() -> {
			throw new ResultatException("resultat inconnu");
		});
	}
	
	public Resultat createOrUpdate(Resultat r) {
		if (r == null) {
			throw new ResultatException();
		}
		LOGGER.info(r.toString());
		Resultat resultatEnBase = null;
		checkData(r);
		LOGGER.info("données OK");
		if (r.getId() == null) {
			LOGGER.info(r.getMatch().toString());
			resultatRepo.save(r);
			Long idM = r.getMatch().getId(); 
			Match idMBase = matchRepo.findById(idM).orElseThrow(); 
			idMBase.getResultats().add(r);
			matchRepo.save(idMBase);
			LOGGER.info("print match results");
			LOGGER.info(idMBase.getResultats().toString());
			LOGGER.info("print match inscriptions");
			LOGGER.info(idMBase.getInscriptions().toString());
			if (idMBase.getResultats() != null && idMBase.getResultats().size() == 2 ) {
				LOGGER.info("GOGO SetScore");
				classementService.setScoreClassementDuel(idMBase);
				Ligue li = new Ligue();
				Poule po = new Poule(); 
				if (r.getParticipant().getId().getTournoi().getClass() == li.getClass() ||
						r.getParticipant().getId().getTournoi().getClass() == po.getClass()) {
					LOGGER.info("GOGO Classement");
					classementService.SetClassementPasFacile(r.getParticipant().getId().getTournoi());
					LOGGER.info("Classement Fini");
					
				}
				
			}
			
			
			return resultatRepo.save(r);
		} else {
			resultatEnBase = this.getById(r.getId());
			resultatEnBase.setMatch(r.getMatch());
			resultatEnBase.setParticipant(r.getParticipant());
			resultatEnBase.setScoreMatch(r.getScoreMatch());
			resultatEnBase.setPositionMatch(r.getPositionMatch());
			resultatRepo.save(resultatEnBase);
			Long idM = resultatEnBase.getMatch().getId(); 
			Match idMBase = matchRepo.findById(idM).orElseThrow(); 
			idMBase.getResultats().add(resultatEnBase);
			matchRepo.save(idMBase);
			LOGGER.info("print match results");
			LOGGER.info(idMBase.getResultats().toString());
			LOGGER.info("print match inscriptions");
			LOGGER.info(idMBase.getInscriptions().get(0).toString());
			if (idMBase.getResultats() != null && idMBase.getResultats().size() == 2 ) {
				LOGGER.info("GOGO SetScore");
				classementService.setScoreClassementDuel(idMBase);
				Ligue li = new Ligue();
				Poule po = new Poule(); 
				if (resultatEnBase.getParticipant().getId().getTournoi().getClass() == li.getClass() ||
						resultatEnBase.getParticipant().getId().getTournoi().getClass() == po.getClass()) {
					LOGGER.info("GOGO Classement");
					classementService.SetClassementPasFacile(resultatEnBase.getParticipant().getId().getTournoi());
					LOGGER.info("Classement Fini");
					
				}
				
			}
			return resultatRepo.save(resultatEnBase);
		}
	}
	
	private void checkData(Resultat r) {
		if (!validator.validate(r).isEmpty()) {
			throw new UtilisateurException();
		}
	}
	
	public void delete(Resultat r) {
		if (r == null || r.getId() == null) {
			throw new ResultatException();
		}
		resultatRepo.delete(r);
	}
	
	public void delete(Long id) {
		//matchRepo.delete(getById(id).getMatch());
		if(resultatRepo.existsById(id)) {
			delete(getById(id)); 
		}
	}
	
	public boolean exist(Long id) {
		return resultatRepo.existsById(id);
	}
}
