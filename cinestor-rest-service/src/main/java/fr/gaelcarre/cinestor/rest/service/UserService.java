package fr.gaelcarre.cinestor.rest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gaelcarre.cinestor.model.User;
import fr.gaelcarre.cinestor.repository.UserRepository;

@RestController
@RequestMapping()
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@GetMapping("user/login")
	public ResponseEntity<User> connexion(Authentication authentication) {

		User utilisateur = this.userRepository.findByLogin(authentication.getName());

		if (utilisateur == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(utilisateur);

	}
}
