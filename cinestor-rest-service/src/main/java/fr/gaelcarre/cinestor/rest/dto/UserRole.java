package fr.gaelcarre.cinestor.rest.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserRole {

	public UserRole(String login, String role) {
		super();
		this.login = login;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userroleid;
	private String login;
	private String role;

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Long getUserroleid() {
		return this.userroleid;
	}

	public void setUserroleid(Long userroleid) {
		this.userroleid = userroleid;
	}
}
