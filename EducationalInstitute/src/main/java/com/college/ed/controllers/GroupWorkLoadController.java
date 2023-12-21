package com.college.ed.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.ed.model.Group;
import com.college.ed.services.GroupWorkLoadService;

@RestController
@RequestMapping("/api")
public class GroupWorkLoadController {
	
	@Autowired
	private GroupWorkLoadService service;
	
	//Retrieval
	@GetMapping("/groups")
	public List<Group> list() {
		return service.listAll();
	}
	
	//Retrieval By Id
	@GetMapping("/groups/{id}")
	public ResponseEntity <Group> get(@PathVariable Long group_id){
		try {
			Group group = service.get(group_id);
			return new ResponseEntity<Group>(group,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Group>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Create operation
	@PostMapping("/groups")
	public void add(@RequestBody Group group) {
		service.save(group);
	}
	
	//Update operation
	@PutMapping("/grups/{id}")
	public ResponseEntity <?> update(@RequestBody Group group, @PathVariable Long group_id){
		try {
			Group existGroup = service.get(group_id);
			service.save(group);
			return new ResponseEntity <> (HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity <> (HttpStatus.NOT_FOUND);
		}
	}
	
	//Delete Operation
	@DeleteMapping("/groups/{id}")
	public void delete(@PathVariable Long group_id){
		service.delete(group_id);
	}

}