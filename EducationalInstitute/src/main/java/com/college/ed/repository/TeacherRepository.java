package com.college.ed.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.college.ed.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Long>{

	Teacher findByFirstName(String firstName);
    
	Teacher findByLastName(String lastName);
	
}
