package com.patrickseremba.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrickseremba.sm.DAO.StudentDAO;
import com.patrickseremba.sm.api.Student;

@Service
public class StudentServiceImplementation implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	@Override
	public List<Student> loadStudents() {
		
		List<Student> studentList = studentDAO.loadStudents();
		
		return studentList;
	}
	
	@Override
	public void saveStudent(Student student) {
		
		studentDAO.saveStudent(student);
	}

	@Override
	public Student getStudent(int id) {
		          
		return studentDAO.getStudent(id);
	}

}
