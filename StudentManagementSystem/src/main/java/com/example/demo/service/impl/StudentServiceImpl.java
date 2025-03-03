package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service

public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepository;
	
	//constructor
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	
	
	@Override
	public List<Student> getAllStudents() {
		//TODO Auto-generted method stub
		
		//return whole students from the repository() Simply it will return list
		return studentRepository.findAll();
	}

	//save data into repository
	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	//get student id from repository
	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).get();
	}

	//now update/save data for particular student object in the repository
	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	//
	@Override
	public void deleteStudentById(Long id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
		
	}
	
	
	//now call this method in student controller
	

}
