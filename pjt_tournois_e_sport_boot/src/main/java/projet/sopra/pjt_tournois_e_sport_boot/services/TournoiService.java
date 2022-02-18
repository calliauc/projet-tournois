package projet.sopra.pjt_tournois_e_sport_boot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.sopra.pjt_tournois_e_sport_boot.exceptions.TournoiException;
import projet.sopra.pjt_tournois_e_sport_boot.model.Tournoi;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.TournoiRepository;


@Service
public class TournoiService {
	@Autowired
	private TournoiRepository tournoiRepo;
	
	public List<Tournoi> getAll() {
		return tournoiRepo.findAll();
	}
	
	public Tournoi getById(Long id) {
		return tournoiRepo.findById(id).orElseThrow(() -> {
			throw new TournoiException("tournoi inconnu");
		});
	}
	
	public Tournoi createOrUpdate(Tournoi t) {
		if (t == null) {
			throw new TournoiException();
		}
		Tournoi tournoiEnBase = null;
		if (t.getIdTournoi() == null) {
			checkData(t);
			return tournoiRepo.save(t);
		} else {
			tournoiEnBase = this.getById(t.getIdTournoi());
			checkData(t);
			tournoiEnBase.setNom(t.getNom());
			return tournoiRepo.save(tournoiEnBase);
		}
	}
	
	private void checkData(Tournoi t) {
		if (t.getNom() == null || t.getNom().isEmpty()) {
			throw new TournoiException("donn�es incorrectes");
		}
	}
	
	public void delete(Tournoi t) {
		if (t == null || t.getIdTournoi() == null) {
			throw new TournoiException();
		}
		Tournoi tournoiEnBase = tournoiRepo.findById(t.getIdTournoi()).orElseThrow(TournoiException::new);
		tournoiRepo.delete(tournoiEnBase);
	}
	
	public void delete(Long id) {
		delete(getById(id)); 
	}
	
	public boolean exist(Long id) {
		return tournoiRepo.existsById(id);
	}
}

