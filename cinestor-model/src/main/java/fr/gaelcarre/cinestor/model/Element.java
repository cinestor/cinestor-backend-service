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
public class Element {

	private @Id @GeneratedValue Long id;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "parent")
	private Set<Element> subelements;
	@ManyToOne
	@JoinColumn(name = "parent", insertable = false, updatable = false)
	@JsonIgnore
	private Element parent;

	@ManyToOne
	@JoinColumn(name = "projectHard", insertable = false, updatable = false)
	@JsonIgnore
	private Project projectHard;

	@ManyToOne
	@JoinColumn(name = "project", insertable = false, updatable = false)
	@JsonIgnore
	private Project project;

	private TypeElement type;

	private Integer number;

	@Lob
	private String description;

	private String value;

	/**
	 * @return the value
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
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
	 * @return the projectHard
	 */
	public Project getProjectHard() {
		return this.projectHard;
	}

	/**
	 * @param projectHard
	 *            the projectHard to set
	 */
	public void setProjectHard(Project projectHard) {
		this.projectHard = projectHard;
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
	 * @return the type
	 */
	public TypeElement getType() {
		return this.type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(TypeElement type) {
		this.type = type;
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
	 * @return the subelements
	 */
	public Set<Element> getSubelements() {
		return this.subelements;
	}

	/**
	 * @param subelements
	 *            the subelements to set
	 */
	public void setSubelements(Set<Element> subelements) {
		this.subelements = subelements;
	}

	/**
	 * @return the parent
	 */
	public Element getParent() {
		return this.parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(Element parent) {
		this.parent = parent;
	}

}
