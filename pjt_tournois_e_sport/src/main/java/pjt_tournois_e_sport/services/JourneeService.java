package pjt_tournois_e_sport.services;

import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pjt_tournois_e_sport.exceptions.JourneeException;
import pjt_tournois_e_sport.model.Journee;
import pjt_tournois_e_sport.repositories.JourneeRepository;

@Service
public class JourneeService {

	@Autowired 
	private JourneeRepository journeeRepo;
	
	@Autowired
	private Validator validator;
	
	public List<Journee> getAll() {
		return journeeRepo.findAll(); 
	}
	
	public Journee getById(Long id) {
		return journeeRepo.findById(id).orElseThrow(() -> {
			throw new JourneeException("Journée inconnue"); 
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
			checkData(j);
			return journeeRepo.save(journeeEnBase);
		}
	}
	
	private void checkData(Journee j) {
		if (!validator.validate(j).isEmpty())  {
			throw new JourneeException("données incorrectes");
		}
	}
	
	public void delete(Journee j) {
		journeeRepo.delete(j);
	}
	
	public void delete(Long id) {
		delete(getById(id)); 
	}
	
	public boolean exist(Long id) {
		return journeeRepo.existsById(id);
	}
	
	
}
