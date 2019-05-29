package fr.gaelcarre.cinestor.repository;

import org.springframework.data.repository.CrudRepository;

import fr.gaelcarre.cinestor.model.Element;

public interface ElementRepository extends CrudRepository<Element, Long> {

	void deleteById(Long id);

}
