package pjt_tournois_e_sport.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pjt_tournois_e_sport.exceptions.JoueurException;
import pjt_tournois_e_sport.exceptions.OrganisateurException;
import pjt_tournois_e_sport.model.Organisateur;
import pjt_tournois_e_sport.repositories.OrganisateurRepository;

@Service
public class OrganisateurService {

	@Autowired
	private OrganisateurRepository orgaRepo;

	// Service CRUD:
	public List<Organisateur> getAll() {
		return orgaRepo.findAll();
	}

	public Organisateur getById(Long id) {
		return orgaRepo.findById(id).orElseThrow(() -> {
			throw new OrganisateurException("can't find by id");
		});
	}

	public Organisateur save(Organisateur org) {
		check(org);
		if (org.getIdCompte() == null) {
			return orgaRepo.save(org);
		} else {
			return orgaRepo.save(this.setData(org));
		}
	}

	public void delete(Organisateur org) {
		orgaRepo.delete(org);
	}

	public void delete(Long id) {
		orgaRepo.delete(this.getById(id));
	}

	// Service QUERY:
	public Organisateur getByPseudo(String pseudo) {
		return orgaRepo.findByPseudo(pseudo).orElseThrow(() -> {
			throw new OrganisateurException("can't find by pseudo");
		});
	}
	
	public Organisateur getOrganisateurWithTournois(Long id) {
		return orgaRepo.findOrganisateurWithTournois(id).orElseThrow(() -> {
			throw new OrganisateurException("can't find by tournoi");
		});
	}

	private Organisateur setData(Organisateur org) {
		Organisateur orgEnBase = new Organisateur();
		orgEnBase.setIdCompte(org.getIdCompte());
		orgEnBase.setPseudo(org.getPseudo());
		orgEnBase.setPassword(org.getPassword());
		orgEnBase.setMail(org.getMail());
		orgEnBase.setTournois(org.getTournois());
		return orgEnBase;
	}

	private void check(Organisateur org) {
		if (org.getPseudo().isEmpty() || org.getPseudo() == null) {
			throw new JoueurException("Incorrect data for pseudo");
		}
		if (org.getPassword().isEmpty() || org.getPassword() == null) {
			throw new JoueurException("Incorrect data for password");
		}
	}

}
