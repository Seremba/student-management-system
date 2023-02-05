package com.patrickseremba.sm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.patrickseremba.sm.DAO.StudentDAO;
import com.patrickseremba.sm.api.Student;

@Controller
public class StudentController {
	@Autowired
	StudentDAO studentDAO;
	@GetMapping("/showStudent")
	public String showStudentString(Model model) {
		
		List<Student> students = studentDAO.loadStudents();
		
		model.addAttribute("students", students);
		 return "student-list";
	}
}
