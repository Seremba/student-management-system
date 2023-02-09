package com.patrickseremba.sm.service;

import java.util.List;

import com.patrickseremba.sm.api.Student;

public interface StudentService {
	List<Student> loadStudents();

	void saveStudent(Student student);
	Student getStudent(int id);
}
