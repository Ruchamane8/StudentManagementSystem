package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {
	
	//display the outputs
	@GetMapping("/showcase")
    public String showGallery() {
        return "showcase";  // Returns the Thymeleaf template
    }
    
    // Injecting the StudentService dependency
    private final StudentService studentService;

    // Constructor-based dependency injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Handler method to display the list of students
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";  // Returns the view name
    }

    // Handler method to display the form for adding a new student
    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student); // Corrected model attribute name
        return "create_student";  // Returns the view name
    }

    // Handler method to save a new student
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";  // Redirects to the student list page
    }

    // Handler method to display the edit form for a specific student
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";  // Returns the view name
    }

    // Handler method to update a student
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, RedirectAttributes redirectAttributes) {
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setAddress(student.getAddress());

        studentService.updateStudent(existingStudent);

        redirectAttributes.addFlashAttribute("message", "Student updated successfully!");
        return "redirect:/students";
    }


    // Handler method to delete a student (fixed duplicate mapping issue)
    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
