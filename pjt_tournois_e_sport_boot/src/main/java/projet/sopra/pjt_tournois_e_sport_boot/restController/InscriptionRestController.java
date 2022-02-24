package projet.sopra.pjt_tournois_e_sport_boot.restController;

import java.util.ArrayList;
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

import projet.sopra.pjt_tournois_e_sport_boot.dto.InscriptionDto;
import projet.sopra.pjt_tournois_e_sport_boot.dto.InscriptionKeyDto;
import projet.sopra.pjt_tournois_e_sport_boot.exceptions.InscriptionException;
import projet.sopra.pjt_tournois_e_sport_boot.model.Inscription;
import projet.sopra.pjt_tournois_e_sport_boot.model.InscriptionKey;
import projet.sopra.pjt_tournois_e_sport_boot.model.Views;
import projet.sopra.pjt_tournois_e_sport_boot.services.InscriptionService;

@RestController
@RequestMapping("api/inscription")
public class InscriptionRestController {
	//TO DO :
// getById composé --> id joueur et tournoi en parametre
//	Meme chose delete
//	Meme chose update
//Validation
	
	@Autowired
	private InscriptionService inscriptionService;
	
	//CRUD
	
	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Inscription> getAll() {
		return inscriptionService.getAll();
	}
	
	@GetMapping("/avecId")
	public List<InscriptionDto> getAllWithKey(){
		return inscriptionListToInscriptionDTOList(inscriptionService.getAll());
	}
	
	@GetMapping("{id}")
	public Inscription getById(@PathVariable InscriptionKey id) {
		return inscriptionService.getById(id);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	public Inscription create(@RequestBody Inscription inscription, BindingResult br) {
		return save(inscription,br);
	}
	
	@PutMapping("/{id}")
	public Inscription create(@RequestBody Inscription inscription, BindingResult br, @PathVariable InscriptionKey id) {
		if(!inscriptionService.exist(id)) {
			throw new InscriptionException();
		}
		return save(inscription,br);
	}
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable InscriptionKey id) {
		if(!inscriptionService.exist(id)) {
			throw new InscriptionException();
		}
		inscriptionService.deleteById(id);
	}
	
	//METHODS
	
	private Inscription save(Inscription inscription, BindingResult br) {
		if (br.hasErrors()) {
			throw new InscriptionException();
		}
		return inscriptionService.createOrUpdate(inscription);
	}
	
	private InscriptionDto inscriptionToInscriptionDTO(Inscription i) {
		InscriptionKeyDto ikDto = new InscriptionKeyDto(i.getId().getJoueur().getId(), i.getId().getTournoi().getIdTournoi());
		return new InscriptionDto(ikDto, i.getPosition(), i.getScore(), i.getProchainMatch());
	}
	
	private List<InscriptionDto> inscriptionListToInscriptionDTOList(List<Inscription> inscriptions){
		List<InscriptionDto> inscriptionsWithKey = new ArrayList<InscriptionDto>();
		for(Inscription i : inscriptions) {
			inscriptionsWithKey.add(inscriptionToInscriptionDTO(i));
		}
		return inscriptionsWithKey;
	}
	
	// SPECIAL QUERIES
	
	@GetMapping("/{score1}/{score2}")
	public List<InscriptionDto> getAllByScore(@PathVariable int score1, @PathVariable int score2){
		return inscriptionListToInscriptionDTOList(inscriptionService.getAllByScoreBetween(score1, score2));
	}
}
