package fr.gaelcarre.cinestor.rest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gaelcarre.cinestor.model.User;
import fr.gaelcarre.cinestor.repository.UserRepository;
import fr.gaelcarre.cinestor.rest.mapper.UserMapper;

@RestController
@RequestMapping()
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserMapper userMapper;

	@GetMapping("user/login")
	public ResponseEntity<fr.gaelcarre.cinestor.rest.dto.DTOUser> connexion(Authentication authentication) {

		User userEntity = this.userRepository.findByLogin(authentication.getName());

		if (userEntity == null)
			return ResponseEntity.notFound().build();
		else {
			fr.gaelcarre.cinestor.rest.dto.DTOUser utilisateurDto = this.userMapper.userEntityToDto(userEntity);
			return ResponseEntity.ok(utilisateurDto);
		}

	}

	@PostMapping("public/user")
	public ResponseEntity<fr.gaelcarre.cinestor.rest.dto.DTOUser> create(
			@RequestAttribute fr.gaelcarre.cinestor.rest.dto.DTOUser user) {

		User u = this.userRepository.save(this.userMapper.userDtoToEntity(user));
		user.setId(u.getId());

		return ResponseEntity.ok(user);

	}
}
