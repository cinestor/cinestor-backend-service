package fr.gaelcarre.cinestor.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Episode {

	private @Id @GeneratedValue Long id;
	private String name;
	@Lob
	private String description;

	private Integer number;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "episode")
	private Set<Scene> scenes;

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
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return this.number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * @return the scenes
	 */
	public Set<Scene> getScenes() {
		return this.scenes;
	}

	/**
	 * @param scenes
	 *            the scenes to set
	 */
	public void setScenes(Set<Scene> scenes) {
		this.scenes = scenes;
	}

}
