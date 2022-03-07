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
import projet.sopra.pjt_tournois_e_sport_boot.model.InscriptionKey;
import projet.sopra.pjt_tournois_e_sport_boot.model.Utilisateur;
import projet.sopra.pjt_tournois_e_sport_boot.model.Views;
import projet.sopra.pjt_tournois_e_sport_boot.services.ConsoleService;
import projet.sopra.pjt_tournois_e_sport_boot.services.UtilisateurService;

@RestController
@RequestMapping("api/utilisateur")
public class UtilisateurRestController {

	@Autowired
	UtilisateurService uService;

	private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurRestController.class);

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Utilisateur> getAll() {
		return uService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Utilisateur getById(@PathVariable Long id) {
		return uService.getById(id);
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(Views.Common.class)
	public Utilisateur create(@Valid @RequestBody Utilisateur u, BindingResult br) {
		LOGGER.info("Dans PostMapping");
		return save(u, br);
	}

	@ResponseStatus(code = HttpStatus.ACCEPTED)
	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Utilisateur update(@Valid @RequestBody Utilisateur u, BindingResult br, @PathVariable Long id) {
		if (!uService.exists(id)) {
			throw new UtilisateurException("This user id doesn't exist");
		}
		LOGGER.info("Dans PutMapping");
		return save(u, br);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		uService.delete(id);
	}

	// Requete pour query spéciales:
	@GetMapping("/username_{username}")
	@JsonView(Views.Common.class)
	public Utilisateur getByUsername(@PathVariable String username) {
		return uService.getByUsername(username);
	}

	@GetMapping("/like_{username}")
	@JsonView(Views.Common.class)
	public List<Utilisateur> getByUsernameLike(@PathVariable String username) {
		return uService.getByUsernameLike(username);
	}

//	@GetMapping("/{username}")
//	@JsonView(Views.Common.class)
//	public List<Utilisateur> getByUsernameStartingWith(@PathVariable String username) {
//		return uService.getByUsernameStartingWith(username);
//	}
//
//	@GetMapping("/{username}")
//	@JsonView(Views.Common.class)
//	public List<Utilisateur> getByUsernameContaining(@PathVariable String username) {
//		return uService.getByUsernameStartingWith(username);
//	}
//
//	@GetMapping("/{id}/{username}")
//	@JsonView(Views.Common.class)
//	public Utilisateur getByIdAndUsername(@PathVariable Long id, @PathVariable String username) {
//		return uService.getByIdCompteAndUsername(id, username);
//	}

	// Requete pour Collections

	@GetMapping("/inscriptions_{key}")
	@JsonView(Views.UserWithIncriptions.class)
	public Utilisateur getUtilisateurWithIncriptions(@PathVariable InscriptionKey key) {
		return uService.getUtilisateurWithInscriptions(key);
	}

	@GetMapping("/tournoi_{idTournoi}")
	@JsonView(Views.UserWithTournois.class)
	public Utilisateur getOrganisateurWithTournois(@PathVariable Long idTournoi) {
		return uService.getOrganisateurWithTournois(idTournoi);
	}

	@GetMapping("/roles_{username}")
	@JsonView(Views.Common.class)
	public Utilisateur getByUsernameWithRoles(@PathVariable String username) {
		return uService.getByUsernameWithRoles(username);
	}

	// Methods

	private Utilisateur save(Utilisateur u, BindingResult br) {
		if (br.hasErrors()) {
			throw new UtilisateurException("Utilisateur invalide");
		}
		LOGGER.info("Validator OK => on save");
		return uService.save(u);
	}

}
