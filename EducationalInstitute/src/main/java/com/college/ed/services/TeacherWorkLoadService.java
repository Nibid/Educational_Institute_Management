package com.college.ed.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.college.ed.model.Teacher;
import com.college.ed.repository.TeacherRepository;

@Service
@Transactional
public class TeacherWorkLoadService {
	
	@Autowired
	private TeacherRepository repository;
	
	public List<Teacher> listAll() {
		return repository.findAll();
	}
	
	public Teacher get(Long teacher_id) {
		return repository.findById(teacher_id).get();
	}
	
	public void save(Teacher teacher) {
		repository.save(teacher);
	}
	
	public void delete(Long teacher_id) {
		repository.deleteById(teacher_id);
	}
	

}