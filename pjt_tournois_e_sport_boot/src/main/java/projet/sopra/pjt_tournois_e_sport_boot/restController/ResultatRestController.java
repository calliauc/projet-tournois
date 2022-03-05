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

import projet.sopra.pjt_tournois_e_sport_boot.exceptions.ResultatException;
import projet.sopra.pjt_tournois_e_sport_boot.model.Resultat;
import projet.sopra.pjt_tournois_e_sport_boot.model.Views;
import projet.sopra.pjt_tournois_e_sport_boot.services.ResultatService;


@RestController
@RequestMapping("api/resultat")
public class ResultatRestController {
////TO-DO annotations @JsonView 
	
	
	@Autowired
	private ResultatService resultatService; 
	
	////CRUD
	
	@JsonView(Views.ResultatWithInscriptionAndMatch.class)
	@GetMapping("")
	public List<Resultat> getAll() {
		List<Resultat> list = resultatService.getAll(); 
		return list; 
	}
	
	@JsonView(Views.ResultatWithInscriptionAndMatch.class)
	@GetMapping("/{id}")
	public Resultat getById(@PathVariable Long id) {
		return resultatService.getById(id);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	public Resultat create(@Valid @RequestBody Resultat resultat, BindingResult br) {
		return save(resultat, br); 
	}
	
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	@PutMapping("/{id}")
	public Resultat update(@Valid @RequestBody Resultat resultat, BindingResult br, @PathVariable Long id) {
		if (!resultatService.exist(id)) {
			throw new ResultatException(); 
		}
		return save(resultat, br);
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	private void delete(@PathVariable Long id) {
		resultatService.delete(id); 
	}
	
	//// TO DO - SPECIAL QUERIES
	
	
	
	
	
	
	//// METHODS
	
	private Resultat save(Resultat resultat, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResultatException(); 
		}
		return resultatService.createOrUpdate(resultat); 
		
	}
}
