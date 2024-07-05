package org.example.huydq.controller;

import org.example.huydq.entity.Student;
import org.example.huydq.respone.Respone;
import org.example.huydq.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/all-students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/new-student")
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        Optional<Student> existingStudentByEmail = studentService.findByEmail(student.getEmail());
        Optional<Student> existingStudentByStudentNumber = studentService.findByStudentNumber(student.getStudentCode());
        if (existingStudentByEmail.isPresent() || existingStudentByStudentNumber.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Student already exists.");
        }
        Respone message = studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @PutMapping("/update-student/{id}")
    public ResponseEntity<Respone> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Optional<Student> student = studentService.getStudentById(id);
        if (student.isPresent()) {
            Student updatedStudent = student.get();
            updatedStudent.setName(studentDetails.getName());
            updatedStudent.setStudentCode(studentDetails.getStudentCode());
            updatedStudent.setDateOfBirth(studentDetails.getDateOfBirth());
            updatedStudent.setAddress(studentDetails.getAddress());
            updatedStudent.setPhone(studentDetails.getPhone());
            updatedStudent.setEmail(studentDetails.getEmail());
            return ResponseEntity.ok(studentService.saveStudent(updatedStudent));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
