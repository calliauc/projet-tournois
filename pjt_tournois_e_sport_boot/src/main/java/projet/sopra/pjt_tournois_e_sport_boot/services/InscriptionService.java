package projet.sopra.pjt_tournois_e_sport_boot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.sopra.pjt_tournois_e_sport_boot.exceptions.InscriptionException;
import projet.sopra.pjt_tournois_e_sport_boot.model.Inscription;
import projet.sopra.pjt_tournois_e_sport_boot.model.InscriptionKey;
import projet.sopra.pjt_tournois_e_sport_boot.model.Tournoi;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.InscriptionRepository;

@Service
public class InscriptionService {
	
	@Autowired
	private InscriptionRepository inscriptionRepo;
	
	//CRUD
	public List<Inscription> getAll(){
		return inscriptionRepo.findAll();
	}
	
	public Inscription getById(InscriptionKey id) {
		return inscriptionRepo.findById(id).orElseThrow(() -> {
			throw new InscriptionException("Inscription inconnue");
		});
	}
	
	public Inscription createOrUpdate(Inscription i) {
		checkData(i);
		if(i.getId()==null) {
			return inscriptionRepo.save(i);
		}
		Inscription iEnBase=new Inscription();
		iEnBase = this.getById(i.getId());
		iEnBase.setPosition(i.getPosition());
		iEnBase.setProchainMatch(i.getProchainMatch());
		iEnBase.setScore(i.getScore());
		iEnBase.setScoreDifference(i.getScoreDifference());
		return inscriptionRepo.save(iEnBase);
	}
	
	public void delete(Inscription i) {
		checkData(i);
		if(i.getId()==null) {
			throw new InscriptionException("donnees incorrectes");
		}
		inscriptionRepo.delete(i);
	}
	
	public void deleteById(InscriptionKey id) {
		inscriptionRepo.deleteById(id);
	}
	
	//METHODS CRUD
	
	public boolean exist(InscriptionKey id) {
		return inscriptionRepo.existsById(id);
	}
	
	//en attendant que le validator soit OK
	private void checkData(Inscription i) {
		if(i ==null) {
			throw new InscriptionException("pas d'inscription renseignee");
		}
		if(i.getScore() <0) {
			throw new InscriptionException("le score doit etre positif");
		}
	}
	
	// SPECIAL QUERIES
	public List<Inscription> getAllByScoreBetween(int score1, int score2){
		return inscriptionRepo.findByScoreBetween(score1, score2);
	}
	
	public List<Inscription> getClassementLigue(Inscription i) {
		return inscriptionRepo.getClassementLigue(i.getId().getTournoi().getIdTournoi());
	}
}
