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

import projet.sopra.pjt_tournois_e_sport_boot.exceptions.TournoiException;
import projet.sopra.pjt_tournois_e_sport_boot.model.Championnat;
import projet.sopra.pjt_tournois_e_sport_boot.model.Inscription;
import projet.sopra.pjt_tournois_e_sport_boot.model.Ligue;
import projet.sopra.pjt_tournois_e_sport_boot.model.Tournoi;
import projet.sopra.pjt_tournois_e_sport_boot.model.Views;
import projet.sopra.pjt_tournois_e_sport_boot.services.InscriptionService;
import projet.sopra.pjt_tournois_e_sport_boot.services.TournoiService;

@RestController
@RequestMapping("api/tournoi")
@CrossOrigin(origins = "*")
public class TournoiRestController {

	//// TO-DO
	// Create
	// Update
	// JSONVIEW SPECIAL QUERIES

	@Autowired
	private TournoiService tournoiService;
	@Autowired
	private InscriptionService inscriptionService;

	//// CRUD

	@GetMapping("")
	@JsonView(Views.TournoiWithInscriptions.class)
	public List<Tournoi> getAll() {
		List<Tournoi> list = tournoiService.getAll();
		return list;
	}

	@GetMapping("/{id}")
	@JsonView(Views.TournoiWithInscriptions.class)
	public Tournoi getById(@PathVariable Long id) {
		return tournoiService.getById(id);
	}

	// TO-DO
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/ligue")
	@JsonView(Views.TournoiWithInscriptions.class)
	public Tournoi create(@Valid @RequestBody Ligue ligue, BindingResult br) {
		return createTournoi(ligue, br);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/championnat")
	@JsonView(Views.TournoiWithInscriptions.class)
	public Tournoi create(@Valid @RequestBody Championnat championnat, BindingResult br) {
		return createTournoi(championnat, br);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	public Tournoi createTournoi(Tournoi tournoi, BindingResult br) {
		return save(tournoi, br);
	}

	// TO-DO
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	@PutMapping("/ligue_{id}")
	@JsonView(Views.TournoiWithInscriptions.class)
	public Tournoi update(@Valid @RequestBody Ligue tournoi, BindingResult br, @PathVariable Long id) {
		return updateTournoi(tournoi, br, id);
	}

	@ResponseStatus(code = HttpStatus.ACCEPTED)
	@PutMapping("/championnat_{id}")
	@JsonView(Views.TournoiWithInscriptions.class)
	public Tournoi update(@Valid @RequestBody Championnat tournoi, BindingResult br, @PathVariable Long id) {
		return updateTournoi(tournoi, br, id);
	}

	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Tournoi updateTournoi(Tournoi tournoi, BindingResult br, Long id) {
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
	@JsonView(Views.InscriptionWithId.class)
	@GetMapping("/{id}/classement")
	private List<Inscription> getClassementLigue(@PathVariable Long id) {
		return tournoiService.getClassementLigue(id);
	}

	//// METHODS

	private Tournoi save(Tournoi tournoi, BindingResult br) {
		if (br.hasErrors()) {
			throw new TournoiException();
		}
		return tournoiService.createOrUpdate(tournoi);

	}
}