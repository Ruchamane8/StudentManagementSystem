package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {

	//list of students
	List<Student> getAllStudents();
	
	//create save Student method
	
	Student saveStudent(Student student);
	
	//by these 2 methods we will get id and we can update
	//to get student id
	Student getStudentById(Long id);
	
	//update student
	Student updateStudent(Student student);
	
	//student delete
	void deleteStudentById(Long id);
}
