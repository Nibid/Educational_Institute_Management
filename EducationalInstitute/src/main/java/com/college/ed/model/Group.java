package com.college.ed.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="'Groups'")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="group_id", unique=true, nullable=false)
    private Long group_id;

	private String groupName;
	
	//@OneToMany(fetch =FetchType.LAZY, mappedBy="group")
	//private List<Routine> routines;
    
    public Group() {
	}

	public Long getGroupId() {
		return group_id;
	}

	public void setGroupId(Long group_id) {
		this.group_id = group_id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "Group [group_id=" + group_id + ", groupName=" + groupName + ", getGroupId()=" + getGroupId()
				+ ", getGroupName()=" + getGroupName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}