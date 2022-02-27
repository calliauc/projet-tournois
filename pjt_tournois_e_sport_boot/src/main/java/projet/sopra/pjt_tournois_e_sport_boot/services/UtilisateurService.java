package projet.sopra.pjt_tournois_e_sport_boot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.sopra.pjt_tournois_e_sport_boot.exceptions.UtilisateurException;
import projet.sopra.pjt_tournois_e_sport_boot.model.InscriptionKey;
import projet.sopra.pjt_tournois_e_sport_boot.model.Utilisateur;
import projet.sopra.pjt_tournois_e_sport_boot.repositories.UtilisateurRepository;

@Service
public class UtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepo;

	// Service pour le CRUD
	public List<Utilisateur> getAll() {
		return utilisateurRepo.findAll();
	}

	public Utilisateur getById(Long id) {
		return utilisateurRepo.findById(id).orElseThrow(() -> {
			throw new UtilisateurException("Can't find by id");
		});
	}

	public Utilisateur save(Utilisateur user) {
		check(user);
		if (user.getId() == null) {
			return utilisateurRepo.save(user);
		} else {
			return utilisateurRepo.save(this.setData(user));
		}
	}

	public void delete(Utilisateur user) {
		utilisateurRepo.delete(user);
	}

	public void delete(Long id) {
		utilisateurRepo.delete(this.getById(id));
	}

	public boolean exists(long id) {
		return utilisateurRepo.existsById(id);
	}

	// Service pour QUERY particuliere:
	public Utilisateur getByUsername(String username) {
		return utilisateurRepo.findByUsername(username).orElseThrow(() -> {
			throw new UtilisateurException("Can't find by Username");
		});
	}

	public List<Utilisateur> getByUsernameLike(String username) {
		return utilisateurRepo.findByUsernameLike(username);
	}

	public List<Utilisateur> getByUsernameStartingWith(String username) {
		return utilisateurRepo.findByUsernameStartingWith(username);
	}

	public List<Utilisateur> getByUsernameContaining(String username) {
		return utilisateurRepo.findByUsernameContaining(username);
	}

	public Utilisateur getByIdCompteAndUsername(Long id, String username) {
		return utilisateurRepo.findByIdAndUsername(id, username).orElseThrow(() -> {
			throw new UtilisateurException("Can't find by id and Username");
		});
	}

	//// QUERY JOUEURS
	public Utilisateur getUtilisateurWithInscriptions(InscriptionKey key) {
		return utilisateurRepo.findJoueurWithInscriptions(key).orElseThrow(() -> {
			throw new UtilisateurException("Can't find by inscriptions");
		});
	}

	//// QUERY ORGANISATEUR

	public Utilisateur getOrganisateurWithTournois(Long id) {
		return utilisateurRepo.findOrganisateurWithTournois(id).orElseThrow(() -> {
			throw new UtilisateurException("can't find by tournoi");
		});
	}

	// Fonctions propres au service
	private void check(Utilisateur user) {
		if (user.getUsername().isEmpty() || user.getUsername() == null) {
			throw new UtilisateurException("Incorrect data for Username");
		}
		if (user.getPassword().isEmpty() || user.getPassword() == null) {
			throw new UtilisateurException("Incorrect data for password");
		}
	}

	private Utilisateur setData(Utilisateur user) {
		Utilisateur utilisateurEnBase = new Utilisateur();
		utilisateurEnBase.setId(user.getId());
		utilisateurEnBase.setUsername(user.getUsername());
		utilisateurEnBase.setPassword(user.getPassword());
		utilisateurEnBase.setMail(user.getMail());
		/// joueur
		utilisateurEnBase.setInscriptions(user.getInscriptions());
		/// orga
		utilisateurEnBase.setTournois(user.getTournois());
		utilisateurEnBase.setRoles(user.getRoles());
		return utilisateurEnBase;
	}

}
