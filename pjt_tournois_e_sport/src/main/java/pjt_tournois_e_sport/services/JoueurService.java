package pjt_tournois_e_sport.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pjt_tournois_e_sport.exceptions.JoueurException;
import pjt_tournois_e_sport.model.InscriptionKey;
import pjt_tournois_e_sport.model.Joueur;
import pjt_tournois_e_sport.repositories.JoueurRepository;

@Service
public class JoueurService {

	@Autowired
	private JoueurRepository joueurRepo;

	//Service pour le CRUD
	public List<Joueur> getAll() {
		return joueurRepo.findAll();
	}

	public Joueur getById(Long id) {
		return joueurRepo.findById(id).orElseThrow(() -> {
			throw new JoueurException("Can't find by id");
		});
	}
	
	public Joueur save(Joueur joueur) {
		check(joueur);
		if( joueur.getIdCompte()==null) {
			return joueurRepo.save(joueur);
		}
		else {
			return joueurRepo.save(this.setData(joueur));
		}
	}
	
	public void delete(Joueur joueur) {
		joueurRepo.delete(joueur);
	}
	
	public void delete(Long id) {
		joueurRepo.delete(this.getById(id));
	}
	
	//Service pour QUERY particuliere:
	public Joueur getByPseudo(String pseudo) {
		return joueurRepo.findByPseudo(pseudo).orElseThrow(() -> {
			throw new JoueurException("Can't find by pseudo");
		});
	}
	
	public List<Joueur> getByPseudoLike(String pseudo) {
		return joueurRepo.findByPseudoLike(pseudo);
	}
	
	public List<Joueur> getByPseudoStartingWith(String pseudo) {
		return joueurRepo.findByPseudoStartingWith(pseudo);
	}
	
	public List<Joueur> getByPseudoContaining(String pseudo) {
		return joueurRepo.findByPseudoContaining(pseudo);
	}
	
	public Joueur getByIdCompteAndPseudo(Long id, String pseudo) {
		return joueurRepo.findByIdCompteAndPseudo(id,pseudo).orElseThrow(() -> {
			throw new JoueurException("Can't find by id and pseudo");
		});
	}
	
	public Joueur getJoueurWithInscriptions(InscriptionKey key) {
		return joueurRepo.findJoueurWithInscriptions(key).orElseThrow(() -> {
			throw new JoueurException("Can't find by inscriptions");
		});
	}
	
	// Fonctions propres au service 
	private void check(Joueur jr)
	{
		if(jr.getPseudo().isEmpty() || jr.getPseudo() == null) {
			throw new JoueurException("Incorrect data for pseudo");
		}
		if(jr.getPassword().isEmpty() || jr.getPassword() == null) {
			throw new JoueurException("Incorrect data for password");
		}
	}
	
	private Joueur setData(Joueur joueur) {
		Joueur joueurEnBase = new Joueur();
		joueurEnBase.setIdCompte(joueur.getIdCompte());
		joueurEnBase.setPseudo(joueur.getPseudo());
		joueurEnBase.setPassword(joueur.getPassword());
		joueurEnBase.setMail(joueur.getMail());
		joueurEnBase.setInscriptions(joueur.getInscriptions());
		return joueurEnBase;
	}
	
}
