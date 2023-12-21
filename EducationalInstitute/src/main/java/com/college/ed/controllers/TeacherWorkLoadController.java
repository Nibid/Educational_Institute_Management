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

import com.college.ed.model.Teacher;
import com.college.ed.services.TeacherWorkLoadService;

@RestController
@RequestMapping("/api")
public class TeacherWorkLoadController {
	
	@Autowired
	private TeacherWorkLoadService service;
	
	//Retrieval
	@GetMapping("/teachers")
	public List<Teacher> list() {
		return service.listAll();
	}
	
	//Retrieval By Id
	@GetMapping("/teachers/{id}")
	public ResponseEntity <Teacher> get(@PathVariable Long teacher_id){
		try {
			Teacher teacher = service.get(teacher_id);
			return new ResponseEntity<Teacher>(teacher,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Teacher>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Create operation
	@PostMapping("/teachers")
	public void add(@RequestBody Teacher teacher) {
		service.save(teacher);
	}
	
	//Update operation
	@PutMapping("/teachers/{id}")
	public ResponseEntity <?> update(@RequestBody Teacher teacher, @PathVariable Long teacher_id){
		try {
			Teacher existTeacher = service.get(teacher_id);
			service.save(teacher);
			return new ResponseEntity <> (HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity <> (HttpStatus.NOT_FOUND);
		}
	}
	
	//Delete Operation
	@DeleteMapping("/teachers/{id}")
	public void delete(@PathVariable Long teacher_id){
		service.delete(teacher_id);
	}

}