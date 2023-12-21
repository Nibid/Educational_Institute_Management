package com.college.ed.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.college.ed.model.Group;
import com.college.ed.repository.GroupRepository;

@Service
@Transactional
public class GroupWorkLoadService {
	
	@Autowired
	private GroupRepository repository;
	
	public List<Group> listAll() {
		return repository.findAll();
	}
	
	public Group get(Long group_id) {
		return repository.findById(group_id).get();
	}
	
	public void save(Group group) {
		repository.save(group);
	}
	
	public void delete(Long group_id) {
		repository.deleteById(group_id);
	}
	

}