package fr.gaelcarre.cinestor.repository;

import org.springframework.data.repository.CrudRepository;

import fr.gaelcarre.cinestor.model.UserRole;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

}
