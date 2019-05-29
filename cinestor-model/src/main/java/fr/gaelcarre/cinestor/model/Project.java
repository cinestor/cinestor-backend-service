package fr.gaelcarre.cinestor.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Project {

	private @Id @GeneratedValue Long id;
	private String name;
	@Lob
	private String description;

	private TypeProject type;

	private Boolean isPublic;

	@ManyToMany
	@JoinTable(name = "user_project", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> members;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "project")
	private Set<Scene> scenes;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "project")
	private Set<Season> seasons;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "projectHard")
	private Set<Element> projectElements;

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

	/**
	 * @return the seasons
	 */
	public Set<Season> getSeasons() {
		return this.seasons;
	}

	/**
	 * @param seasons
	 *            the seasons to set
	 */
	public void setSeasons(Set<Season> seasons) {
		this.seasons = seasons;
	}

	/**
	 * @return the projectElements
	 */
	public Set<Element> getProjectElements() {
		return this.projectElements;
	}

	/**
	 * @param projectElements
	 *            the projectElements to set
	 */
	public void setProjectElements(Set<Element> projectElements) {
		this.projectElements = projectElements;
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
	 * @return the members
	 */
	public Set<User> getMembers() {
		if (this.members == null)
			this.members = new HashSet<>();
		return this.members;
	}

	/**
	 * @param members
	 *            the members to set
	 */
	public void setMembers(Set<User> members) {
		this.members = members;
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
	 * @return the type
	 */
	public TypeProject getType() {
		return this.type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(TypeProject type) {
		this.type = type;
	}

	/**
	 * @return the isPublic
	 */
	public Boolean getIsPublic() {
		return this.isPublic;
	}

	/**
	 * @param isPublic
	 *            the isPublic to set
	 */
	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

}
