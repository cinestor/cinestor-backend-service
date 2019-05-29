package fr.gaelcarre.cinestor.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import fr.gaelcarre.cinestor.model.User;

public class CustomPrincipal implements UserDetails {

	private User user;

	public CustomPrincipal(User utilisateur) {
		this.user = utilisateur;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	public String getUsername() {
		return this.user.getLogin();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

	public String getPassword() {
		return this.user.getPassword();
	}

}
