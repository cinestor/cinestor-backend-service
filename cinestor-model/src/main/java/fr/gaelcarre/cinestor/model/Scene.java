package fr.gaelcarre.cinestor.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Scene {

	private @Id @GeneratedValue Long id;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "scene")
	private Set<Element> elements;

	@ManyToOne
	@JoinColumn(name = "project", insertable = false, updatable = false)
	@JsonIgnore
	private Project project;

	@ManyToOne
	@JoinColumn(name = "episode", insertable = false, updatable = false)
	@JsonIgnore
	private Episode episode;

	private Integer number;

	@Lob
	private String description;

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
	 * @return the elements
	 */
	public Set<Element> getElements() {
		return this.elements;
	}

	/**
	 * @param elements
	 *            the elements to set
	 */
	public void setElements(Set<Element> elements) {
		this.elements = elements;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return this.project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * @return the episode
	 */
	public Episode getEpisode() {
		return this.episode;
	}

	/**
	 * @param episode
	 *            the episode to set
	 */
	public void setEpisode(Episode episode) {
		this.episode = episode;
	}

}
