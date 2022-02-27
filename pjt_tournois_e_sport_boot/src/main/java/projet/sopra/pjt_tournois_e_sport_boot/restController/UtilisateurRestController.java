package projet.sopra.pjt_tournois_e_sport_boot.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import projet.sopra.pjt_tournois_e_sport_boot.exceptions.UtilisateurException;
import projet.sopra.pjt_tournois_e_sport_boot.model.Utilisateur;
import projet.sopra.pjt_tournois_e_sport_boot.services.UtilisateurService;

@RestController
@RequestMapping("api/utilisateur")
public class UtilisateurRestController {

	// To Do : ajouter @Valid
	@Autowired
	UtilisateurService uService;
	
	@GetMapping("")
	public List<Utilisateur> getAll() {
		return uService.getAll();
	}
	
	@GetMapping("/{id}")
	public Utilisateur getById(@PathVariable Long id) {
		return uService.getById(id);
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Utilisateur save(@RequestBody Utilisateur u) {
		return uService.save(u);
	}
	
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	@PutMapping("/{id}")
	public Utilisateur update(@RequestBody Utilisateur u, @PathVariable Long id) {
		if (!uService.exists(id)) {
			throw new UtilisateurException("This user id doesn't exist");
		}
		return uService.save(u);
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete (@PathVariable Long id) {
		uService.delete(id);
	}
	
}
