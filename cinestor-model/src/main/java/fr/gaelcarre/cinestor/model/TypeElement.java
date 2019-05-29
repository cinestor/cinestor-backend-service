package fr.gaelcarre.cinestor.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeElement {

	CHARACTER("Character"), PLACE("Place"), SOUNDTRACK("SoundTrack"), ELEMENTSET("ElementSet");

	private String title;

	TypeElement(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return this.title;
	}

	@JsonValue
	public String getTitle() {
		return this.title;
	}

}
