package com.patrickseremba.sm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.patrickseremba.sm.api.Student;
import com.patrickseremba.sm.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/showStudent")
	public String showStudentString(Model model) {

		List<Student> students = studentService.loadStudents();

		model.addAttribute("students", students);
		return "student-list";
	}

	@GetMapping("/showAddStudentPage")
	public String addStudent(Model model) {

		Student student = new Student();

		model.addAttribute("student", student);

		return "add-student";
	}

	@PostMapping("/save-student")
	public String saveStudent(Student student) {
		// if no id,
		if (student.getId() == 0) {
			// insert a new record to the db
			studentService.saveStudent(student);
		} else {
			// do an update
			studentService.update(student);
		}

		return "redirect:/showStudent";
	}

	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("userId") int id, Model model) {

		Student myStudent = studentService.getStudent(id);

		System.out.println(myStudent);
		model.addAttribute("student", myStudent);

		System.out.println("Here is the " + id);

		return "add-student";
	}
}
