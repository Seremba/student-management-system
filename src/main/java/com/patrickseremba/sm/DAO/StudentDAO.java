package com.patrickseremba.sm.DAO;

import java.util.List;

import com.patrickseremba.sm.api.Student;

public interface StudentDAO {
	List<Student> loadStudents();
}
