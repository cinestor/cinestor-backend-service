package fr.gaelcarre.cinestor.model;

import java.util.List;

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
	private List<Element> subelements;
	@ManyToOne
	@JoinColumn(name = "parent", insertable = false, updatable = false)
	@JsonIgnore
	private Element parent;

	@ManyToOne
	@JoinColumn(name = "scene", insertable = false, updatable = false)
	@JsonIgnore
	private Scene scenes;

	@ManyToOne
	@JoinColumn(name = "projectHard", insertable = false, updatable = false)
	@JsonIgnore
	private Project projectHard;

	private TypeElement type;

	private Integer number;

	@Lob
	private String description;

	private String artist;
	private String track;
	private String youtube;
	private String name;
	private String sheet;

	/**
	 * @return the scenes
	 */
	public Scene getScenes() {
		return this.scenes;
	}

	/**
	 * @param scenes
	 *            the scenes to set
	 */
	public void setScenes(Scene scenes) {
		this.scenes = scenes;
	}

	/**
	 * @return the artist
	 */
	public String getArtist() {
		return this.artist;
	}

	/**
	 * @param artist
	 *            the artist to set
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * @return the track
	 */
	public String getTrack() {
		return this.track;
	}

	/**
	 * @param track
	 *            the track to set
	 */
	public void setTrack(String track) {
		this.track = track;
	}

	/**
	 * @return the youtube
	 */
	public String getYoutube() {
		return this.youtube;
	}

	/**
	 * @param youtube
	 *            the youtube to set
	 */
	public void setYoutube(String youtube) {
		this.youtube = youtube;
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
	 * @return the sheet
	 */
	public String getSheet() {
		return this.sheet;
	}

	/**
	 * @param sheet
	 *            the sheet to set
	 */
	public void setSheet(String sheet) {
		this.sheet = sheet;
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
	public List<Element> getSubelements() {
		return this.subelements;
	}

	/**
	 * @param subelements
	 *            the subelements to set
	 */
	public void setSubelements(List<Element> subelements) {
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
