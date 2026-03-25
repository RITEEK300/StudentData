package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("student not found" + id));
    }

    public Student update(Student studentData, long id) {
        Student student = getStudentById(id);
        student.setEmail(studentData.setEmail());
        student.setId(studentData.setId());
        student.setMark(studentData.setMark());
        student.setPhone(studentData.setPhone());
        student.setLastname(studentData.setLastname());
        student.setLastname(studentData.setLastname());
        return studentRepository.save(student);
    }

    public void delete(long id) {
        studentRepository.deleteById(id);
    }

}
