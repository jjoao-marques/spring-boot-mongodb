package com.devsuperior.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.workshopmongodb.domain.Post;
import com.devsuperior.workshopmongodb.repository.PostRepository;
import com.devsuperior.workshopmongodb.services.exception.ObjectNotFoundException;


@Service // Serviço injetável em outras classes
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

	
	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text) {
		return postRepository.findByTitleContainingIgnoreCase(text);
	}
	
}
