package com.college.ed.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.*;

@Entity
@Table(name="teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacher_id;

    @Column(name="teacherName")
	private String teacherName;
	
	//@JsonIgnore
	//@OneToMany(cascade = CascadeType.ALL, fetch =FetchType.EAGER, mappedBy="teacher")
	//private List<Routine> routines;
    
    //public List<Routine> getRoutines() {
	//	return routines;
	//}

	//public void setRoutines(List<Routine> routines) {
	//	this.routines = routines;
	//}

	public Long getTeacherid() {
		return teacher_id;
	}

	public void setTeacherid(Long teacher_id) {
		this.teacher_id = teacher_id;
	}

	public Teacher() {
	}


	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	@Override
	public String toString() {
		return "Teacher [teacher_id=" + teacher_id + ", groupName=" + teacherName + ", getTeacherid()=" + getTeacherid()
				+ ", getTeacherName()=" + getTeacherName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}