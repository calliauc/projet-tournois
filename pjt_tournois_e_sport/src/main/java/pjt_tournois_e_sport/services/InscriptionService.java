package pjt_tournois_e_sport.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pjt_tournois_e_sport.exceptions.InscriptionException;
import pjt_tournois_e_sport.model.Inscription;
import pjt_tournois_e_sport.model.InscriptionKey;
import pjt_tournois_e_sport.repositories.InscriptionRepository;

@Service
public class InscriptionService {
	
	@Autowired
	private InscriptionRepository inscriptionRepo;
	
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
		return inscriptionRepo.save(iEnBase);
	}
	
	public void delete(Inscription i) {
		checkData(i);
		if(i.getId()==null) {
			throw new InscriptionException("donnees incorrectes");
		}
		inscriptionRepo.delete(i);
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
}
