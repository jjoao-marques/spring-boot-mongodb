package com.devsuperior.workshopmongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.workshopmongodb.domain.User;
import com.devsuperior.workshopmongodb.dto.UserDTO;
import com.devsuperior.workshopmongodb.services.UserService;


@RestController // classe recurso rest
@RequestMapping(value = "/users") //Caminho do endpoint
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET) //metodo
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = userService.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = userService.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}

}
