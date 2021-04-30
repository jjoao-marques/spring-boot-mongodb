package com.devsuperior.workshopmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.devsuperior.workshopmongodb.domain.User;
import com.devsuperior.workshopmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User priscila = new User(null, "Priscila Marques", "priscila@gmail.com");
		User taiane = new User(null, "Taiane Marques", "taiane@gmail.com");
		User joao = new User(null, "João Marques", "joao@gmail.com");
		
		userRepository.saveAll(Arrays.asList(priscila, taiane, joao));

	}

}
