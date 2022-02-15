package pjt_tournois_e_sport_web.restController;

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

import pjt_tournois_e_sport.exceptions.JourneeException;
import pjt_tournois_e_sport.model.Journee;
import pjt_tournois_e_sport.services.JourneeService;
import pjt_tournois_e_sport.services.TournoiService;

@RestController
@RequestMapping("api/journee")
public class JourneeRestController {
	
	
	//// TO-DO annotations @JsonView 

	@Autowired
	private JourneeService journeeService; 
	
	@Autowired
	private TournoiService tournoiService; 
	
	//// CRUD
	
	@GetMapping("")
	public List<Journee> getAll() {
		List<Journee> list = journeeService.getAll(); 
		return list; 
	}
	
	@GetMapping("/{id}")
	public Journee getById(@PathVariable Long id) {
		return journeeService.getById(id);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	public Journee create(@Valid @RequestBody Journee journee, BindingResult br) {
		return save(journee, br); 
	}
	
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	@PutMapping("/{id}")
	public Journee update(@Valid @RequestBody Journee journee, BindingResult br, @PathVariable Long id) {
		if (!journeeService.exist(id)) {
			throw new JourneeException(); 
		}
		return save(journee, br);
	}
	
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
