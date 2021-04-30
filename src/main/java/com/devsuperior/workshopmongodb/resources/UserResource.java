package com.devsuperior.workshopmongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.workshopmongodb.domain.User;


@RestController // classe recurso rest
@RequestMapping(value = "/users") //Caminho do endpoint
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET) //metodo
	public ResponseEntity<List<User>> findAll() {
		List<User> list = new ArrayList<>();
		User taiane = new User("1001", "Taiane", "taiane@gmail.com");
		User joao = new User("1002", "João", "joao@gmail.com");
		list.addAll(Arrays.asList(taiane, joao));
		return ResponseEntity.ok().body(list);
	}

}
