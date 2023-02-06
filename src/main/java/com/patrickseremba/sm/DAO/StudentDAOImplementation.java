package com.patrickseremba.sm.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import com.patrickseremba.sm.api.Student;
import com.patrickseremba.sm.rowmapper.StudentRowMapper;

@Repository
public class StudentDAOImplementation implements StudentDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Student> loadStudents() {

		String sql = "SELECT * FROM students";
		
		List<Student> studentList = jdbcTemplate.query(sql, new StudentRowMapper());
		
		for(Student temp: studentList) {
			System.out.println(temp);
		}
		
		return studentList;
	}

}
