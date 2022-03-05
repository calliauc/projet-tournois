package projet.sopra.pjt_tournois_e_sport_boot.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import projet.sopra.pjt_tournois_e_sport_boot.exceptions.MatchException;
import projet.sopra.pjt_tournois_e_sport_boot.model.Match;
import projet.sopra.pjt_tournois_e_sport_boot.model.Views;
import projet.sopra.pjt_tournois_e_sport_boot.services.MatchService;

@RestController
@RequestMapping("api/match")
public class MatchRestController {
//	TO-DO :
//  delete
//	update
//  create
	
	@Autowired 
	private MatchService matchService;
	
	//CRUD
	
	
	@GetMapping("")
	@JsonView(Views.MatchWithJourneeAndResultat.class)
	public List<Match> getAllWithInscriptions(){
		return matchService.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.MatchWithJourneeAndResultat.class)
	public Match getById(@PathVariable Long id) {
		return matchService.getById(id);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	public Match create(@Valid @RequestBody Match match, BindingResult br) {
		return save(match,br);
	}
	
	//TODO probleme validation
	@PutMapping("/{id}")
	public Match update(@Valid @RequestBody Match match, BindingResult br, @PathVariable Long id) {
		if(!matchService.exist(id)) {
			throw new MatchException();
		}
		return save(match,br);
	}
	
	// TODO - Conflit resultat
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if(!matchService.exist(id)) {
			throw new MatchException();
		}
		matchService.deleteById(id);
	}
	
	//METHODS
	
	private Match save(Match match, BindingResult br) {
		if (br.hasErrors()) {
			throw new MatchException("Validation not ok \n \n"+br.getGlobalErrors());
		}
		return matchService.createOrUpdate(match);
	}
	
//	private InscriptionDto inscriptionToInscriptionDTO(Inscription i) {
//		InscriptionKeyDto ikDto = new InscriptionKeyDto(i.getId().getJoueur().getId(), i.getId().getTournoi().getIdTournoi());
//		return new InscriptionDto(ikDto, i.getPosition(), i.getScore(), i.getScoreDifference(), i.getProchainMatch());
//	}
	
//	private List<InscriptionDto> inscriptionListToInscriptionDTOList(List<Inscription> inscriptions){
//		List<InscriptionDto> inscriptionsWithKey = new ArrayList<InscriptionDto>();
//		for(Inscription i : inscriptions) {
//			inscriptionsWithKey.add(inscriptionToInscriptionDTO(i));
//		}
//		return inscriptionsWithKey;
//	}
	
	
//	private MatchDto matchToMatchDto(Match m) {
//		MatchDto matchDto = new MatchDto(m.getId(),inscriptionListToInscriptionDTOList(m.getInscriptions()),m.getJournee());
//		return matchDto;
//	}
	
//	private List<MatchDto> listMatchToListMatchDto(List<Match> matchs){
//		List<MatchDto> matchsDto = new ArrayList<MatchDto>();
//		for(Match m : matchs) {
//			matchsDto.add(matchToMatchDto(m));
//		}
//		return matchsDto;
//	}
	
}
