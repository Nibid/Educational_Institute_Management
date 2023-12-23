package com.college.ed.model;

import java.time.LocalDate;
import java.time.LocalTime;


import jakarta.persistence.*;

// Creating routine entity
@Entity
@Table(name="\"routine\"")
public class Routine {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private LocalTime startTime;
	private LocalTime endTime;
	private LocalDate routineDate;
	
	// Many To One relationship with teacher entity to join column 'teacher_id'
    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    // Many To One relationship with group entity to join column 'group_id'
	@ManyToOne
    @JoinColumn(name="group_id")
    private Group group;

	// Default Constructor
	public Routine() {
	}
	
	// Getters and Setters
	public int getRoutineId() {
		return id;
	}

	public void setRoutineId(int id) {
		this.id = id;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public LocalDate getRoutineDate() {
		return routineDate;
	}

	public void setRoutineDate(LocalDate routineDate) {
		this.routineDate = routineDate;
	}
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	// String toString
	@Override
	public String toString() {
		return "Routine [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", routineDate="
				+ routineDate + ", teacher=" + teacher + ", group=" + group + ", getGroup()=" + getGroup()
				+ ", getTeacher()=" + getTeacher() + ", getRoutineId()=" + getRoutineId() + ", getStartTime()="
				+ getStartTime() + ", getEndTime()=" + getEndTime() + ", getRoutineDate()=" + getRoutineDate()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
		
	}
