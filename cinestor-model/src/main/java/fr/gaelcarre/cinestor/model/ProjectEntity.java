package fr.gaelcarre.cinestor.model;

import java.util.Set;
import java.util.UUID;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "project")
public class ProjectEntity {

	private @Id @GeneratedValue UUID id;
	private String name;
	private String description;

	private Boolean isPublic;

	private Set<UserEntity> members;

	private StepOutlineEntity stepOutline;

	private Set<ElementEntity> inventory;

}
