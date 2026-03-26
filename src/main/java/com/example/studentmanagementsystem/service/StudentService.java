package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    // Add a new student
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    // Update existing student
    public Student updateStudent(Long id, Student studentData) {
        Student student = getStudentById(id); // existing student fetch
        student.setEmail(studentData.getEmail());
        student.setMark(studentData.getMark());
        student.setPhone(studentData.getPhone());
        student.setFirstname(studentData.getFirstname());
        student.setLastname(studentData.getLastname());
        return studentRepository.save(student);
    }

    // Delete student
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> addStudentAll(List<Student> students) {
        return studentRepository.saveAll(students);
    }
}