package projet.sopra.pjt_tournois_e_sport_boot.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")
public class MatchRestController {
//	TO-DO :
//  delete
//	update
//  create
	
	@Autowired 
	private MatchService matchService;

	
	//CRUD
	
	
	@GetMapping("")
	@JsonView(Views.MatchWithIncriptions.class)
	public List<Match> getAllWithInscriptions(){
		return matchService.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.MatchWithIncriptions.class)
	public Match getById(@PathVariable Long id) {
		return matchService.getById(id);
	}
	
	@GetMapping("/journee/{id}")
	@JsonView(Views.MatchWithIncriptions.class)
	public List<Match> getByJournee(@PathVariable Long id) {
		return matchService.getByJourn(id);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(Views.Match.class)
	public Match create(@Valid @RequestBody Match match, BindingResult br) {
		return save(match,br);
	}
	
	//TODO probleme validation
	@PutMapping("/{id}")
	@JsonView(Views.Match.class)
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

	
}
