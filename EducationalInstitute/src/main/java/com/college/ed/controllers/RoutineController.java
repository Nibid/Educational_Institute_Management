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

import com.college.ed.model.Routine;
import com.college.ed.services.RoutineService;

@RestController
@RequestMapping("/api")
public class RoutineController {
	
	@Autowired
	private RoutineService service;
	
	//Retrieval
	@GetMapping("/routines")
	public List<Routine> list() {
		return service.listAll();
	}
	
	//Retrieval By Id
	@GetMapping("/routines/{id}")
	public ResponseEntity <Routine> get(@PathVariable Long routineId){
		try {
			Routine routine = service.get(routineId);
			return new ResponseEntity<Routine>(routine,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Routine>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Create operation
	@PostMapping("/routines")
	public void add(@RequestBody Routine routine) {
		service.save(routine);
	}
	
	//Update operation
	@PutMapping("/routines/{id}")
	public ResponseEntity <?> update(@RequestBody Routine routine, @PathVariable Long routineId){
		try {
			Routine existRoutine = service.get(routineId);
			service.save(routine);
			return new ResponseEntity <> (HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity <> (HttpStatus.NOT_FOUND);
		}
	}
	
	//Delete Operation
	@DeleteMapping("/routines/{id}")
	public void delete(@PathVariable Long routineId){
		service.delete(routineId);
	}

}
