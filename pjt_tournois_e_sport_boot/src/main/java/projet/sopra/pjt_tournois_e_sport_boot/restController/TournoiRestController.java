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

import projet.sopra.pjt_tournois_e_sport_boot.exceptions.TournoiException;
import projet.sopra.pjt_tournois_e_sport_boot.model.Tournoi;
import projet.sopra.pjt_tournois_e_sport_boot.services.TournoiService;

@RestController
@RequestMapping("api/tournoi")
public class TournoiRestController {
	
	////TO-DO annotations @JsonView 
	
	
	@Autowired
	private TournoiService tournoiService; 
	
	////CRUD
	
	
	@GetMapping("")
	public List<Tournoi> getAll() {
		List<Tournoi> list = tournoiService.getAll(); 
		return list; 
	}
	
	@GetMapping("/{id}")
	public Tournoi getById(@PathVariable Long id) {
		return tournoiService.getById(id);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	public Tournoi create(@Valid @RequestBody Tournoi tournoi, BindingResult br) {
		return save(tournoi, br); 
	}
	
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	@PutMapping("/{id}")
	public Tournoi update(@Valid @RequestBody Tournoi tournoi, BindingResult br, @PathVariable Long id) {
		if (!tournoiService.exist(id)) {
			throw new TournoiException(); 
		}
		return save(tournoi, br);
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	private void delete(@PathVariable Long id) {
		tournoiService.delete(id); 
	}
	
	//// TO DO - SPECIAL QUERIES
	
	
	
	
	
	
	//// METHODS
	
	private Tournoi save(Tournoi tournoi, BindingResult br) {
		if (br.hasErrors()) {
			throw new TournoiException(); 
		}
		return tournoiService.createOrUpdate(tournoi); 
		
	}
}