package fr.gaelcarre.cinestor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.gaelcarre.cinestor.model.User;
import fr.gaelcarre.cinestor.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.findByLogin(username);
		if (user == null)
			throw new UsernameNotFoundException(username);

		return new CustomPrincipal(user);
	}

}
