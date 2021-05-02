package com.devsuperior.workshopmongodb.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.workshopmongodb.domain.Post;
import com.devsuperior.workshopmongodb.services.PostService;


@RestController // classe recurso rest
@RequestMapping(value = "/posts") //Caminho do endpoint
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = postService.findById(id);
		return ResponseEntity.ok().body(obj);
	}		

}
