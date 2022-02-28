package projet.sopra.pjt_tournois_e_sport_boot.restController;

import java.util.List;

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
//	TO-DO Vigilance
//	  - getall avec list inscription ? list resultat (plutot non) ?
	
	@Autowired 
	private MatchService matchService;
	
	//CRUD
	
	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Match> getAll(){
		return matchService.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Match getById(@PathVariable Long id) {
		return matchService.getById(id);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	public Match create(@RequestBody Match match, BindingResult br) {
		return save(match,br);
	}
	
	@PutMapping("/{id}")
	public Match update(@RequestBody Match match, BindingResult br, @PathVariable Long id) {
		if(!matchService.exist(id)) {
			throw new MatchException();
		}
		return save(match,br);
	}
	
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
			throw new MatchException();
		}
		return matchService.createOrUpdate(match);
	}
}
