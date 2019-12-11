package fr.gaelcarre.cinestor.model;

import java.util.List;
import java.util.Set;

public class UserEntity {

	private String login;
	private String email;
	private Boolean enabled;
	private String password;
	private String displayName;
	private String biography;

	private List<ProjectEntity> projects;

	private Set<MessageEntity> messagesSent;
	private Set<MessageEntity> messagesReceived;

}
