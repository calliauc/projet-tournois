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

import projet.sopra.pjt_tournois_e_sport_boot.exceptions.JourneeException;
import projet.sopra.pjt_tournois_e_sport_boot.model.Journee;
import projet.sopra.pjt_tournois_e_sport_boot.model.Views;
import projet.sopra.pjt_tournois_e_sport_boot.services.JourneeService;
import projet.sopra.pjt_tournois_e_sport_boot.services.TournoiService;

@RestController
@RequestMapping("api/journee")
public class JourneeRestController {
	
	
	//// TO-DO 
//	Create
//	Update
//	Delete en conflit avec prochain match

	@Autowired
	private JourneeService journeeService; 
	
	@Autowired
	private TournoiService tournoiService; 
	
	//// CRUD
	
	@GetMapping("")
	@JsonView(Views.JourneeWithTournoiAndMatch.class)
	public List<Journee> getAll() {
		List<Journee> list = journeeService.getAll(); 
		return list; 
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.JourneeWithTournoiAndMatch.class)
	public Journee getById(@PathVariable Long id) {
		return journeeService.getById(id);
	}
	
	//TO-DO
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(Views.JourneeWithTournoiAndMatch.class)
	public Journee create(@Valid @RequestBody Journee journee, BindingResult br) {
		return save(journee, br); 
	}
	
	//TO-DO
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	@PutMapping("/{id}")
	@JsonView(Views.JourneeWithTournoiAndMatch.class)
	public Journee update(@Valid @RequestBody Journee journee, BindingResult br, @PathVariable Long id) {
		if (!journeeService.exist(id)) {
			throw new JourneeException(); 
		}
		return save(journee, br);
	}
	
//	TO-DO (Conflit avec prochain match)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	private void delete(@PathVariable Long id) {
		journeeService.delete(id); 
	}
	
	//// TO DO - SPECIAL QUERIES
	
	//// METHODS
	
	private Journee save(Journee journee, BindingResult br) {
		if (br.hasErrors()) {
			throw new JourneeException(); 
		}
		return journeeService.createOrUpdate(journee); 
		
	}
	
	
	
	
	
	
	
}
