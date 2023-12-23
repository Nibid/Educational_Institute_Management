package com.college.ed.model;

import java.util.List;

import jakarta.persistence.*;

//Creating teacher entity
@Entity
@Table(name="\"teacher\"")
public class Teacher {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="teacherName", columnDefinition = "VARCHAR(255)")
	private String teacherName;

    // One To Many relationship with routine entity
	@OneToMany(fetch =FetchType.LAZY, mappedBy="teacher")
	private List<Routine> routine;

	// Default Constructors
	public Teacher() {
	}

	// Getters and Setters
	public int getTeacherid() {
		return id;
	}

	public void setTeacherid(int i) {
		this.id = i;
	}
	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	//String toString
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", groupName=" + teacherName + ", getTeacherid()=" + getTeacherid()
				+ ", getTeacherName()=" + getTeacherName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}