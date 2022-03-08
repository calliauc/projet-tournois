package projet.sopra.pjt_tournois_e_sport_boot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.sopra.pjt_tournois_e_sport_boot.exceptions.ResultatException;
import projet.sopra.pjt_tournois_e_sport_boot.model.Resultat;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.ResultatRepository;

@Service
public class ResultatService {
	@Autowired
	private ResultatRepository resultatRepo;
	
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
		Resultat resultatEnBase = null;
		if (r.getId() == null) {
			checkData(r);
			return resultatRepo.save(r);
		} else {
			resultatEnBase = this.getById(r.getId());
			resultatEnBase.setMatch(r.getMatch());
			resultatEnBase.setParticipant(r.getParticipant());
			resultatEnBase.setScoreMatch(r.getScoreMatch());
			resultatEnBase.setPositionMatch(r.getPositionMatch());
			checkData(r);
			return resultatRepo.save(resultatEnBase);
		}
	}
	
	private void checkData(Resultat r) {
		if (r.getMatch() == null || r.getParticipant() == null || r.getScoreMatch()<0 || r.getPositionMatch()<1) {
			throw new ResultatException("données incorrectes");
		}
	}
	
	public void delete(Resultat r) {
		if (r == null || r.getId() == null) {
			throw new ResultatException();
		}
		resultatRepo.delete(r);
	}
	
	public void delete(Long id) {
		delete(getById(id)); 
	}
	
	public boolean exist(Long id) {
		return resultatRepo.existsById(id);
	}
}
