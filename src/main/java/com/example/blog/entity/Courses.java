package com.example.blog.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

public class Courses {
	@Id
	int id;
	String name;
	
	@ManyToMany
	@JoinTable(name="student-course",joinColumns = @JoinColumn(name="student-id"),inverseJoinColumns = @JoinColumn(name="course-id"))
	 Student student;
}
