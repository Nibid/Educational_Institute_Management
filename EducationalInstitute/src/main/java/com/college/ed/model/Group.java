package com.college.ed.model;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// Creating group entity
@Entity
@Table(name="\"Group\"")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="groupName", columnDefinition = "VARCHAR(255)")
	private String groupName;
	
    // One To Many relationship with routine entity
	@OneToMany(fetch =FetchType.LAZY, mappedBy="group")
	private List<Routine> routine;
    
	// Default Constructors
    public Group() {
	}
    
    // Getters and Setters
	public int getGroupId() {
		return id;
	}

	public void setGroupId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	//String toString
	@Override
	public String toString() {
		return "Group [id=" + id + ", groupName=" + groupName + ", getGroupId()=" + getGroupId()
				+ ", getGroupName()=" + getGroupName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}