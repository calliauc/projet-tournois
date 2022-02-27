package projet.sopra.pjt_tournois_e_sport_boot.restController;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import projet.sopra.pjt_tournois_e_sport_boot.exceptions.UtilisateurException;
import projet.sopra.pjt_tournois_e_sport_boot.model.Utilisateur;
import projet.sopra.pjt_tournois_e_sport_boot.model.Views;
import projet.sopra.pjt_tournois_e_sport_boot.services.ConsoleService;
import projet.sopra.pjt_tournois_e_sport_boot.services.UtilisateurService;

@RestController
@RequestMapping("api/utilisateur")
public class UtilisateurRestController {

	// To Do : ajouter @Valid
	@Autowired
	UtilisateurService uService;

	private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurRestController.class);

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Utilisateur> getAll() {
		return uService.getAll();
	}

	@GetMapping("/{id}")
	public Utilisateur getById(@PathVariable Long id) {
		return uService.getById(id);
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Utilisateur create(@Valid @RequestBody Utilisateur u, BindingResult br) {
		LOGGER.info("Dans PostMapping -> save");
		return save(u, br);
	}

	@ResponseStatus(code = HttpStatus.ACCEPTED)
	@PutMapping("/{id}")
	public Utilisateur update(@Valid @RequestBody Utilisateur u, BindingResult br, @PathVariable Long id) {
		if (!uService.exists(id)) {
			throw new UtilisateurException("This user id doesn't exist");
		}
		return save(u, br);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		uService.delete(id);
	}

	// Methods

	private Utilisateur save(Utilisateur u, BindingResult br) {
		if (br.hasErrors()) {
			throw new UtilisateurException("Utilisateur invalide");
		}
		return uService.save(u);
	}

}
