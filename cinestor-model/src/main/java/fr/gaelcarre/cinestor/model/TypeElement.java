package fr.gaelcarre.cinestor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TypeElement {

	private @Id @GeneratedValue Long id;

	private String name;

	private Integer level;

	/**
	 *
	 */
	public TypeElement() {
		super();
	}

	/**
	 * @param name
	 * @param level
	 */
	public TypeElement(String name, Integer level) {
		super();
		this.name = name;
		this.level = level;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return this.level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

}
