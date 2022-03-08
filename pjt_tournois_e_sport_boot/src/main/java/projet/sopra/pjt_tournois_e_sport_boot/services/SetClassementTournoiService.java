package projet.sopra.pjt_tournois_e_sport_boot.services;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.sopra.pjt_tournois_e_sport_boot.exceptions.ResultatException;
import projet.sopra.pjt_tournois_e_sport_boot.model.Inscription;
import projet.sopra.pjt_tournois_e_sport_boot.model.Match;
import projet.sopra.pjt_tournois_e_sport_boot.model.Resultat;
import projet.sopra.pjt_tournois_e_sport_boot.model.Tournoi;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.InscriptionRepository;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.MatchRepository;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.ResultatRepository;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.TournoiRepository;

@Service
public class SetClassementTournoiService {

	@Autowired
	private TournoiRepository tournoiRepo;
	@Autowired
	private MatchRepository matchRepo;
	@Autowired
	private InscriptionRepository inscriptionRepo;
	@Autowired
	private ResultatRepository resultatRepo;

	/// points gagnés lors d'un duel
	private static int ptGagnesWinDuel = 3;
	private static int ptGagnesLoseDuel = 0;
	private static int ptGagnesNulDuel = 1;

	public void setScoreClassementDuel(Match match) {
		List<Inscription> participants = match.getInscriptions();
		Inscription j1EnBase = inscriptionRepo.getById(participants.get(0).getId());
		Inscription j2EnBase = inscriptionRepo.getById(participants.get(1).getId());
		Resultat resultatJ1 = resultatRepo.findByMatchAndParticipant(match, j1EnBase).orElseThrow(() -> {
			throw new ResultatException("resultat inconnu");
		});
		Resultat resultatJ2 = resultatRepo.findByMatchAndParticipant(match, j2EnBase).orElseThrow(() -> {
			throw new ResultatException("resultat inconnu");
		});
		////// SET SCORE + SCORE_DIFF(S/0 SCREAMING_SNAKE_CASE ^^) CLASSEMENT LIGUE (ET
		////// MAYBE POULE)
		/// J'ai opté pour mettre en place une difference de score pour départager
		/// les joueurs ayant le meme classement mais on peut faire autrement
		int diffPosition = resultatJ1.getPositionMatch() - resultatJ2.getPositionMatch();
		int diffScore = Math.abs(resultatJ1.getScoreMatch() - resultatJ2.getScoreMatch());

		if (diffPosition < 0) {
			j1EnBase.setScore(j1EnBase.getScore() + ptGagnesWinDuel);
			j1EnBase.setScoreDifference(j1EnBase.getScoreDifference() + diffScore);
			j2EnBase.setScore(j2EnBase.getScore() + ptGagnesLoseDuel);
			j2EnBase.setScoreDifference(j2EnBase.getScoreDifference() - diffScore);

		} else if (diffPosition > 0) {
			j2EnBase.setScore(j2EnBase.getScore() + ptGagnesWinDuel);
			j2EnBase.setScoreDifference(j2EnBase.getScoreDifference() + diffScore);
			j1EnBase.setScore(j1EnBase.getScore() + ptGagnesLoseDuel);
			j1EnBase.setScoreDifference(j1EnBase.getScoreDifference() - diffScore);
		} else {
			j2EnBase.setScore(j2EnBase.getScore() + ptGagnesNulDuel);
			j1EnBase.setScore(j1EnBase.getScore() + ptGagnesNulDuel);
		}
		inscriptionRepo.save(j1EnBase);
		inscriptionRepo.save(j2EnBase);
	}

//	/// VERSION SANS CHECKER LE SCORE DIFF
//
//	public void SetClassementFacile(Tournoi tournoi) {
//		LinkedList<Inscription> participants = new LinkedList<Inscription>(tournoi.getListeInscriptions());
//		Collections.sort(participants, Inscription.ComparatorScore);
//		for (int i = 0; i < participants.size(); i++) {
//			if (i > 0 && (participants.get(i).getScore() == participants.get(i).getScore())) {
//				participants.get(i).setPosition(i - 1);
//			}
//			else {
//				participants.get(i).setPosition(i);
//			}
//			inscriptionRepo.save(participants.get(i));
//		}
//	}
//	
	/// VERSION CHECKER LE SCORE DIFF
	
	public void SetClassementPasFacile(Tournoi tournoi) {
		LinkedList<Inscription> participants = new LinkedList<Inscription>(inscriptionRepo.getClassementLigue(tournoi.getIdTournoi()));
		Collections.sort(participants, Inscription.ComparatorScore);
		for (int i = 0; i < participants.size(); i++) {
			if (i > 0 && (participants.get(i-1).getScoreDifference() == participants.get(i).getScoreDifference())) {
				participants.get(i).setPosition(i);
			}
			else {
				participants.get(i).setPosition(i+1);
			}
			inscriptionRepo.save(participants.get(i));
		}
	}

}
