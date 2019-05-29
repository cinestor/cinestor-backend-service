package fr.gaelcarre.cinestor.repository;

import org.springframework.data.repository.CrudRepository;

import fr.gaelcarre.cinestor.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByLogin(String login);

}
