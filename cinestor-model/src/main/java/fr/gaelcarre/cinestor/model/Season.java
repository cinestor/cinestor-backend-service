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
public class Season {

	private @Id @GeneratedValue Long id;
	private String name;
	@Lob
	private String description;

	private Integer number;

	@ManyToOne
	@JoinColumn(name = "project", insertable = false, updatable = false)
	@JsonIgnore
	private Project project;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "season")
	private Set<Episode> episodes;

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
	 * @return the episodes
	 */
	public Set<Episode> getEpisodes() {
		return this.episodes;
	}

	/**
	 * @param episodes
	 *            the episodes to set
	 */
	public void setEpisodes(Set<Episode> episodes) {
		this.episodes = episodes;
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

}
