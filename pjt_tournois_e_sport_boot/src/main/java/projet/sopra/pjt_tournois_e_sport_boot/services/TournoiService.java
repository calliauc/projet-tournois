package projet.sopra.pjt_tournois_e_sport_boot.services;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.sopra.pjt_tournois_e_sport_boot.exceptions.TournoiException;
import projet.sopra.pjt_tournois_e_sport_boot.model.Inscription;
import projet.sopra.pjt_tournois_e_sport_boot.model.StatutInscriptions;
import projet.sopra.pjt_tournois_e_sport_boot.model.StatutTemps;
import projet.sopra.pjt_tournois_e_sport_boot.model.Tournoi;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.InscriptionRepository;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.TournoiRepository;


@Service
public class TournoiService {
	@Autowired
	private TournoiRepository tournoiRepo;
	@Autowired
	private InscriptionRepository inscriptionRepo;
	private static final Logger LOGGER = LoggerFactory.getLogger(TournoiService.class);

	
	public List<Tournoi> getAll() {
		List<Tournoi> tournois = tournoiRepo.findAll();
		updateStatusAll(tournois);
		return tournois;
	}
	
	public Tournoi getById(Long id) {
		Tournoi tournoiEnBase = tournoiRepo.findById(id).orElseThrow(() -> {
			throw new TournoiException("tournoi inconnu");
		});
		updateStatus(tournoiEnBase);
		return tournoiEnBase;
	}
	
	public Tournoi createOrUpdate(Tournoi t) {
		if (t == null) {
			throw new TournoiException();
		}
		Tournoi tournoiEnBase = null;
		if (t.getIdTournoi() == null) {
			checkData(t);
			LOGGER.info("CREATE TOURNOI");
			return tournoiRepo.save(t);
		
		} else {
			tournoiEnBase = this.getById(t.getIdTournoi());
			checkData(t);
			tournoiEnBase.setNom(t.getNom());
			tournoiEnBase.setDateDeCreation(t.getDateDeCreation());
			tournoiEnBase.setDateDeDebut(t.getDateDeDebut());
			tournoiEnBase.setJeu(t.getJeu());
			//tournoiEnBase.setListeInscriptions(t.getListeInscriptions());
			tournoiEnBase.setNbParticipantsParMatch(t.getNbParticipantsParMatch());
			tournoiEnBase.setNbParticipantsTotal(t.getNbParticipantsTotal());
			tournoiEnBase.setOrganisateur(t.getOrganisateur());
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
	
	// SPECIAL QUERIES
	public List<Inscription> getClassementLigue(Long id){
		return inscriptionRepo.getClassementLigue(id);
	}
	
	
	public void updateStatus(Tournoi tournoi) {
		/// check inscriptions 
		if (tournoi.getListeInscriptions().size() == tournoi.getNbParticipantsTotal()) {
			tournoi.setStatutInscriptions(StatutInscriptions.Inscriptions_Terminées);
		}
		else if (tournoi.getListeInscriptions().size() < tournoi.getNbParticipantsTotal()) {
			tournoi.setStatutInscriptions(StatutInscriptions.Inscription_En_Cours);
		}
		if (LocalDate.now().isAfter(tournoi.getDateDeDebut()) || LocalDate.now().isEqual(tournoi.getDateDeDebut())) {
			tournoi.setStatutTemps(StatutTemps.En_cours);
		}
		else if (LocalDate.now().isBefore(tournoi.getDateDeDebut()))
		{
			tournoi.setStatutTemps(StatutTemps.A_venir);
		}
		tournoiRepo.save(tournoi);
	}
	
	public void updateStatusAll(List<Tournoi> tournois) {
		for (Tournoi t : tournois) {
			updateStatus(t);
		}
	}
	
	public int getNbInscriptionTournoi(Tournoi t) {
		return tournoiRepo.getNbInscriptionTournoi(t.getIdTournoi());
	}

	
}

