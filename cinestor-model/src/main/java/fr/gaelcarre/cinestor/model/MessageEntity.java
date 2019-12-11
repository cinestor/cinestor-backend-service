package fr.gaelcarre.cinestor.model;

import java.sql.Date;

public class MessageEntity {

	private UserEntity sender;
	private UserEntity recipient;

	private String title;
	private String content;

	private Date sendingDate;
	private Boolean isRead;

}
