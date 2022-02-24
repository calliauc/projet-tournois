package projet.sopra.pjt_tournois_e_sport_boot.model;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "seqUtilisateur", sequenceName = "seq_users", initialValue = 100, allocationSize = 1)
public class Utilisateur implements UserDetails {
	
	///////// Attributs généraux
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUtilisateur")
	@JsonView(Views.Common.class)
	private Long id;
	@Column(name = "username", unique = true, nullable = false)
	@JsonView(Views.Common.class)
	private String username;
	@Column(name = "email", unique = true, nullable = false)
	@JsonView(Views.Common.class)
	private String mail;
	@Column(name = "password", length = 150, nullable = false)
	private String password;
	@Column(name = "enable", nullable = false)
	private boolean enable = true;
	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "users_roles")
	private Set<Role> roles;
	/*
	 * TODO : autoriser un orga sur ses tournois seulement
	 */
	//////////// Attributs Joueur
	
	
	@OneToMany(mappedBy="id.joueur")
	@Column(name="joueur_inscriptions", nullable= true)
	private Set<Inscription> inscriptions;
	
	////////////Attributs Organisateur
	
	@OneToMany(mappedBy="organisateur")
	@Column(name="tournois_organises", nullable= true)
	private List<Tournoi> tournois;
	
	//////////// CONSTRUCTOR
			
	public Utilisateur(String username, String mail, String password) {
		super();
		this.username = username;
		this.mail = mail;
		this.password = password;
	}

	public Utilisateur() {
			
		}

	//////// GETTERS SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(Set<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public List<Tournoi> getTournois() {
		return tournois;
	}

	public void setTournois(List<Tournoi> tournois) {
		this.tournois = tournois;
	}

	
	//////////// METHODS
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		getRoles().forEach(r -> {
//			authorities.add(new SimpleGrantedAuthority(r.toString()));
//		});
//		return authorities;

		// return Arrays.asList(new
		// SimpleGrantedAuthority(this.getClass().getSimpleName()));

		return getRoles().stream().map(r -> new SimpleGrantedAuthority(r.toString())).collect(Collectors.toList());
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enable;
	}

}