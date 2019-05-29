package fr.gaelcarre.cinestor.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import fr.gaelcarre.cinestor.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

	Set<Project> findByMembers_Id(Long id);

}
