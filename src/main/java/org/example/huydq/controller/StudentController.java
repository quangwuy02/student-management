package org.example.huydq.controller;

import org.example.huydq.entity.Student;
import org.example.huydq.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/saveStudent")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {

        return new ResponseEntity<Student>(studentService.createStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/getAllStudent")
    public ResponseEntity<List<Student>> getAllStudent(){

        return new ResponseEntity<List<Student>>(studentService.getAllStudent(), HttpStatus.OK);
    }

    @PutMapping("/editStudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student){
        return new ResponseEntity<Student>(studentService.updateStudent(id, student), HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
}
