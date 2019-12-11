package fr.gaelcarre.cinestor.rest.dto;

import java.sql.Date;
import java.util.UUID;

public class DTOMessage {

	private UUID id;
	private DTOUser sender;
	private DTOUser recipient;

	private String title;
	private String content;

	private Date sendingDate;
	private Boolean isRead;

}
