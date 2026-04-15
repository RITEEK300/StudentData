package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Rest controller

@RestController
@AllArgsConstructor@CrossOrigin(origins = "*")
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }
    @PostMapping("/bulk")
    public List<Student> addStudentsAll(@RequestBody List<Student> students) {
        return studentService.addStudentAll(students);
    }
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id ,@RequestBody Student studentData) {
        return studentService.updateStudent(id,studentData);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok("Student deleted successfully with ID: " + id);
    }


}
