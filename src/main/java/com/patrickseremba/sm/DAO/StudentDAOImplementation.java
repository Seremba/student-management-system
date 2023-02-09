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
		
		return studentList;
	}

	@Override
	public void saveStudent(Student student) {
		Object[] sqlParams = {student.getName(), student.getMobile(), student.getCountry()};
		
		String sql = "insert into students(name,mobile,country) values(?,?,?)";
		
		jdbcTemplate.update(sql, sqlParams);
		
		System.out.println("updated one record");
	}

	@Override
	public Student getStudent(int id) {
		String sql = "SELECT * FROM students WHERE ID = ?";
		
		Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
		
		return student;
	}

}



















