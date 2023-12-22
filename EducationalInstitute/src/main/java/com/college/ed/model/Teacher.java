package com.college.ed.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.*;

@Entity
@Table(name="\"teacher\"")
public class Teacher {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="firstName", columnDefinition = "VARCHAR(255)")
	private String firstName;
    
    @Column(name="lastName", columnDefinition = "VARCHAR(255)")
	private String lastName;
	
	@OneToMany(fetch =FetchType.LAZY, mappedBy="teacher")
	private List<Routine> routine;
    
	public Long getTeacherid() {
		return id;
	}

	public void setTeacherid(Long id) {
		this.id = id;
	}

	public Teacher() {
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", groupName=" + firstName + ", getTeacherid()=" + getTeacherid()
				+ ", getTeacherName()=" + getFirstName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}