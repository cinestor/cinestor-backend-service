package fr.gaelcarre.cinestor.rest.dto;

import java.util.Set;
import java.util.UUID;

public class DTOUser {

	private UUID id;
	private String login;
	private String token;
	private String email;
	private Boolean enabled;
	private String password;
	private String displayName;

	private Set<DTOMessage> messagesSent;
	private Set<DTOMessage> messagesReceived;

	/**
	 *
	 */
	public DTOUser() {
		super();
	}

	/**
	 * @return the id
	 */
	public UUID getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return this.token;
	}

	/**
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return this.enabled;
	}

	/**
	 * @param enabled
	 *            the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return this.displayName;
	}

	/**
	 * @param displayName
	 *            the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the messagesSent
	 */
	public Set<DTOMessage> getMessagesSent() {
		return this.messagesSent;
	}

	/**
	 * @param messagesSent
	 *            the messagesSent to set
	 */
	public void setMessagesSent(Set<DTOMessage> messagesSent) {
		this.messagesSent = messagesSent;
	}

	/**
	 * @return the messagesReceived
	 */
	public Set<DTOMessage> getMessagesReceived() {
		return this.messagesReceived;
	}

	/**
	 * @param messagesReceived
	 *            the messagesReceived to set
	 */
	public void setMessagesReceived(Set<DTOMessage> messagesReceived) {
		this.messagesReceived = messagesReceived;
	}

}
