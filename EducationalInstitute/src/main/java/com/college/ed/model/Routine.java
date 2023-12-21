package com.college.ed.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="routines")
public class Routine {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long routineId;
	
	private LocalTime startTime;
	private LocalTime endTime;
	private LocalDate routineDate;
	
	//@JsonIgnore
    //@ManyToOne(cascade = CascadeType.ALL, fetch =FetchType.EAGER)
    //@JoinColumn(name="teacher_id")
    //private Teacher teacher;
	//private Long teacher_id;

	//public Teacher getTeacher() {
	//	return teacher;
	//}

	//public void setTeacher(Teacher teacher) {
	//	this.teacher = teacher;
	//}

	public Routine() {
	}

	@Id
	public Long getRoutineId() {
		return routineId;
	}

	public void setRoutineId(Long routineId) {
		this.routineId = routineId;
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


	@Override
	public String toString() {
		return "Routine [routineId=" + routineId + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", routineDate=" + routineDate + ", getRoutineId()="
				+ getRoutineId() + ", getStartTime()=" + getStartTime() + ", getEndTime()=" + getEndTime()
				+ ", getRoutineDate()=" + getRoutineDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	//public Long getTeacher_id() {
	//	return teacher_id;
	//}

	//public void setTeacher_id(Long teacher_id) {
	//	this.teacher_id = teacher_id;
	//} 
		
	}
