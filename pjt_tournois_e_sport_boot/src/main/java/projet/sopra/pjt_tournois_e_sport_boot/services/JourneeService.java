package projet.sopra.pjt_tournois_e_sport_boot.services;

import java.util.List;

import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.sopra.pjt_tournois_e_sport_boot.exceptions.JourneeException;
import projet.sopra.pjt_tournois_e_sport_boot.model.Inscription;
import projet.sopra.pjt_tournois_e_sport_boot.model.Journee;
import projet.sopra.pjt_tournois_e_sport_boot.model.Match;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.InscriptionRepository;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.JourneeRepository;

@Service
public class JourneeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JourneeService.class);

	@Autowired 
	private JourneeRepository journeeRepo;
	
	@Autowired 
	private InscriptionRepository inscriptionRepo;
	
	@Autowired
	private MatchService matchService;
	
	@Autowired
	private Validator validator;
	
	public List<Journee> getAll() {
		return journeeRepo.findAll(); 
	}
	
	public Journee getById(Long id) {
		return journeeRepo.findById(id).orElseThrow(() -> {
			throw new JourneeException("Journ�e inconnue"); 
		});
	}
	
	public Journee createOrUpdate(Journee j) {
		checkData(j);
		if (j.getId() == null) {
			return journeeRepo.save(j);
		} else {
			Journee journeeEnBase = getById(j.getId());
			journeeEnBase.setTournoi(j.getTournoi());
			journeeEnBase.setDateDebutJournee(j.getDateDebutJournee());
			journeeEnBase.setDateFinJournee(j.getDateFinJournee());
			journeeEnBase.setEtape(j.getEtape());
			journeeEnBase.setNumero(j.getNumero());
			checkData(j);
			return journeeRepo.save(journeeEnBase);
		}
	}
	
	private void checkData(Journee j) {
		if (!validator.validate(j).isEmpty())  {
			throw new JourneeException("donn�es incorrectes");
		}
	}
	
	public void delete(Journee j) {
		for (Match m : j.getMatchsAJouerPourJournee()) {
			
			matchService.delete(m);
		}
		journeeRepo.delete(j);
	}
	
	public void delete(Long id) {
		Journee j = getById(id);
		for (Match m : j.getMatchsAJouerPourJournee()) {
			for (Inscription i : m.getInscriptions()) {
				if (i.getProchainMatch() == m) {
					Inscription inscriptionEnBase = inscriptionRepo.getById(i.getId()); 
					inscriptionEnBase.setProchainMatch(null);
				}
			}
			matchService.delete(m);
			
		}
		journeeRepo.delete(j);
	}
	
	public boolean exist(Long id) {
		return journeeRepo.existsById(id);
	}
	
	
}
