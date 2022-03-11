package projet.sopra.pjt_tournois_e_sport_boot.services;

import java.util.List;

import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.sopra.pjt_tournois_e_sport_boot.exceptions.MatchException;
import projet.sopra.pjt_tournois_e_sport_boot.exceptions.UtilisateurException;
import projet.sopra.pjt_tournois_e_sport_boot.model.Inscription;
import projet.sopra.pjt_tournois_e_sport_boot.model.InscriptionKey;
import projet.sopra.pjt_tournois_e_sport_boot.model.Journee;
import projet.sopra.pjt_tournois_e_sport_boot.model.Match;
import projet.sopra.pjt_tournois_e_sport_boot.model.Resultat;
import projet.sopra.pjt_tournois_e_sport_boot.model.Tournoi;
import projet.sopra.pjt_tournois_e_sport_boot.model.Utilisateur;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.InscriptionRepository;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.JourneeRepository;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.MatchRepository;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.ResultatRepository;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.TournoiRepository;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.UtilisateurRepository;

@Service
public class MatchService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MatchService.class);

	@Autowired
	private MatchRepository matchRepo;

	@Autowired
	private TournoiRepository tournoiRepo;

	@Autowired
	private JourneeRepository journeeRepo;

	@Autowired
	private InscriptionRepository inscriptionRepo;

	@Autowired
	private ResultatRepository resultatRepo;
	
	@Autowired
	private UtilisateurRepository utlisateurRepo;

	@Autowired
	private Validator validator;

	public List<Match> getAll() {
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
	
	public List<Match> getByJourn(Long id) {
		Journee j = new Journee(); 
		j = journeeRepo.getById(id);
		return matchRepo.findByJournee(j);
	}

	public List<Match> getByTourn(Long id) {
		Tournoi t = tournoiRepo.getById(id);
		return matchRepo.getMatchByTournoi(t);
	}
	public List<Match> getByInscription(Long idJoueur, Long idTournoi){
		Utilisateur user = utlisateurRepo.getById(idJoueur);
		Tournoi tourn = tournoiRepo.getById(idTournoi);
		InscriptionKey key = new InscriptionKey(user, tourn);
		Inscription i = inscriptionRepo.findById(key).orElseThrow();
		return matchRepo.getMatchsWithInscription(i);
		
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
		Inscription i1 = inscriptionRepo.getById(matchEnBase.getInscriptions().get(0).getId()); 
		Inscription i2 = inscriptionRepo.getById(matchEnBase.getInscriptions().get(1).getId());
		if (i1.getProchainMatch() == matchEnBase) {
			i1.setProchainMatch(null);
			i1.getMatchs().remove(m);
			inscriptionRepo.save(i1); 
		}
		if (i2.getProchainMatch() == matchEnBase) {
			i2.setProchainMatch(null);
			i2.getMatchs().remove(m);
			inscriptionRepo.save(i2); 
		}
		
		
		matchRepo.delete(matchEnBase);
	}
	
	public void deleteById(Long id) {
		Match m = matchRepo.getById(id);
		delete(m);
	}

	private void checkData(Match m) {
		if (!validator.validate(m).isEmpty()) {
			throw new UtilisateurException();
		}
//		if(m==null) {
//			throw new MatchException("pas de match renseigne");
//		}
//		
//		if (m.getJournee() == null || m.getInscriptions().isEmpty()) {
//			throw new MatchException("donnees incorrectes");
//		}
	}

	public boolean exist(Long id) {
		return matchRepo.existsById(id);
	}

	public void setProchainMatch(Inscription inscription) {
		boolean isProchainMatchFound = false;
		int numProchaineJournee = resultatRepo.findByParticipant(inscription).size() + 1;
		while (isProchainMatchFound != true) {
			if (journeeRepo.findByNumeroAndTournoi(numProchaineJournee, inscription.getId().getTournoi()) == null) {
				inscription.setProchainMatch(null);
				break;
			} else {
				Journee jProchainMatch = journeeRepo.findByNumeroAndTournoi(numProchaineJournee,
						inscription.getId().getTournoi());
				for (Match m : jProchainMatch.getMatchsAJouerPourJournee()) {
					if (m.getInscriptions().contains(inscription)) {
						inscription.setProchainMatch(m);
						inscriptionRepo.save(inscription);
						isProchainMatchFound = true;
						break;
					}
				}
				numProchaineJournee++;
				if (numProchaineJournee > inscription.getId().getTournoi().getListeInscriptions().size() - 1) {
					/// a modifier par un attribut calculé qui nous donne le nombre précis de
					/// journées à jouer dans un tournoi
					break;
				}
			}

		}

	}

	public void setAllProchainMatch(Long idTournoi) {
		for (Inscription i : tournoiRepo.getById(idTournoi).getListeInscriptions()) {
			setProchainMatch(i);
		}
	}

}
