package com.devsuperior.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.devsuperior.workshopmongodb.domain.Post;
import com.devsuperior.workshopmongodb.domain.User;
import com.devsuperior.workshopmongodb.dto.AuthorDTO;
import com.devsuperior.workshopmongodb.dto.CommentDTO;
import com.devsuperior.workshopmongodb.repository.PostRepository;
import com.devsuperior.workshopmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		User priscila = new User(null, "Priscila Marques", "priscila@gmail.com");
		User taiane = new User(null, "Taiane Marques", "taiane@gmail.com");
		User joao = new User(null, "João Marques", "joao@gmail.com");
		userRepository.saveAll(Arrays.asList(priscila, taiane, joao));
		
		Post p1 = new Post(null, sdf.parse("01/05/2021"), "Partiu viagem", "Vou viajar para São Paulo", new AuthorDTO(joao));
		Post p2 = new Post(null, sdf.parse("30/04/2021"), "Bom dia!", "Acordei feliz hoje!", new AuthorDTO(joao));
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("01/05/2021"), new AuthorDTO(joao));
		CommentDTO c2 = new CommentDTO("Aproveite!", sdf.parse("01/05/2021"), new AuthorDTO(taiane));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("30/04/2021"), new AuthorDTO(joao));
		
		p1.getComments().addAll(Arrays.asList(c1, c2));
		p2.getComments().addAll(Arrays.asList(c3));
						
		postRepository.saveAll(Arrays.asList(p1, p2));
		
		joao.getPosts().addAll(Arrays.asList(p1, p2));
		userRepository.save(joao);

	}

}
