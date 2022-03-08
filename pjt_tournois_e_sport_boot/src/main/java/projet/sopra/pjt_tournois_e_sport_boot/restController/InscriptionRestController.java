package projet.sopra.pjt_tournois_e_sport_boot.restController;

import java.util.ArrayList;
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

import projet.sopra.pjt_tournois_e_sport_boot.dto.InscriptionDto;
import projet.sopra.pjt_tournois_e_sport_boot.dto.InscriptionKeyDto;
import projet.sopra.pjt_tournois_e_sport_boot.exceptions.InscriptionException;
import projet.sopra.pjt_tournois_e_sport_boot.model.Inscription;
import projet.sopra.pjt_tournois_e_sport_boot.model.InscriptionKey;
import projet.sopra.pjt_tournois_e_sport_boot.model.Views;
import projet.sopra.pjt_tournois_e_sport_boot.services.InscriptionService;
import projet.sopra.pjt_tournois_e_sport_boot.services.TournoiService;
import projet.sopra.pjt_tournois_e_sport_boot.services.UtilisateurService;

@RestController
@RequestMapping("api/inscription")
public class InscriptionRestController {
	//TO DO :
//  getById composé
//  delete
//	update
//  create
	
	@Autowired
	private InscriptionService inscriptionService;
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private TournoiService tournoiService;
	
	//CRUD
	
	@GetMapping("")
	@JsonView(Views.InscriptionWithId.class)
	public List<Inscription> getAll() {
		return inscriptionService.getAll();
	}
	
	@GetMapping("/avecDto")
	public List<InscriptionDto> getAllWithKey(){
		return inscriptionListToInscriptionDTOList(inscriptionService.getAll());
	}
	
	@GetMapping("/{idJoueur}&{idTournoi}")
	@JsonView(Views.InscriptionWithId.class)
	public Inscription getById(@PathVariable Long idJoueur, @PathVariable Long idTournoi) {
		InscriptionKey key = new InscriptionKey(utilisateurService.getById(idJoueur),tournoiService.getById(idTournoi));
		return inscriptionService.getById(key);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(Views.InscriptionWithId.class)
	@PostMapping("")
	public Inscription create(@Valid @RequestBody InscriptionKeyDto ikDto, BindingResult br) {
		Inscription i =new Inscription(InscriptionKeyDtoToInscriptionKey(ikDto));
		return save(i,br);
	}
	
	@JsonView(Views.InscriptionWithId.class)
	@PutMapping("/{idJoueur}&{idTournoi}")
	public Inscription update(@Valid @RequestBody InscriptionDto inscriptionDto, BindingResult br, @PathVariable Long idJoueur, @PathVariable Long idTournoi) {
		Inscription inscription = InscriptionDtoToInscription(inscriptionDto);
		if(!inscriptionService.exist(inscription.getId())) {
			throw new InscriptionException("\n\n Id absent base : " + inscription.getId().toString() + "\n\n");
		}
		if(inscription.getId().getJoueur().getId() != idJoueur || inscription.getId().getTournoi().getIdTournoi() != idTournoi) {
			throw new InscriptionException("Les id ne correspondent pas");
		}
		return save(inscription,br);
	}
	
		
	// TO DO (conflit avec table Resultat)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@JsonView(Views.InscriptionWithId.class)
	@DeleteMapping("/{idJoueur}&{idTournoi}")
	public void delete(@PathVariable Long idJoueur, @PathVariable Long idTournoi) {
		InscriptionKey key = new InscriptionKey(utilisateurService.getById(idJoueur),tournoiService.getById(idTournoi));
		if(!inscriptionService.exist(key)) {
			throw new InscriptionException();
		}
		inscriptionService.deleteById(key);
	}
	
	//METHODS
	
	private Inscription save(Inscription inscription, BindingResult br) {
		if (br.hasErrors()) {
			throw new InscriptionException();
		}
		return inscriptionService.createOrUpdate(inscription);
	}
	
	//DTO
	
	private InscriptionDto inscriptionToInscriptionDTO(Inscription i) {
		InscriptionKeyDto ikDto = new InscriptionKeyDto(i.getId().getJoueur().getId(), i.getId().getTournoi().getIdTournoi());
		return new InscriptionDto(ikDto, i.getPosition(), i.getScore(), i.getScoreDifference(), i.getProchainMatch());
	}
	
	private List<InscriptionDto> inscriptionListToInscriptionDTOList(List<Inscription> inscriptions){
		List<InscriptionDto> inscriptionsWithKey = new ArrayList<InscriptionDto>();
		for(Inscription i : inscriptions) {
			inscriptionsWithKey.add(inscriptionToInscriptionDTO(i));
		}
		return inscriptionsWithKey;
	}
	
	private InscriptionKey InscriptionKeyDtoToInscriptionKey(InscriptionKeyDto ikDto) {
		InscriptionKey ik = new InscriptionKey();
		ik.setJoueur(utilisateurService.getById(ikDto.getIdJoueur()));
		ik.setTournoi(tournoiService.getById(ikDto.getIdTournoi()));
		//BeanUtils.copyProperties(ikDto, ik);
		return ik;
	}
	
	private Inscription InscriptionDtoToInscription (InscriptionDto iDto) {
		Inscription i = new Inscription(InscriptionKeyDtoToInscriptionKey(iDto.getId()),iDto.getPosition(), iDto.getScore(), iDto.getScoreDifference(), iDto.getProchainMatch());
		return i;
	}
	
	// SPECIAL QUERIES
	
	@GetMapping("/score/{score1}&{score2}")
	public List<InscriptionDto> getAllByScore(@PathVariable int score1, @PathVariable int score2){
		return inscriptionListToInscriptionDTOList(inscriptionService.getAllByScoreBetween(score1, score2));
	}
	
	
}
