package com.college.ed.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.college.ed.model.Routine;
import com.college.ed.repository.RoutineRepository;

@Service
@Transactional
public class RoutineService {
	
	@Autowired
	private RoutineRepository repository;
	
	public List<Routine> listAll() {
		return repository.findAll();
	}
	
	public Routine get(Long id) {
		return repository.findById(id).get();
	}
	
	public void save(Routine routine) {
		repository.save(routine);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	

}
