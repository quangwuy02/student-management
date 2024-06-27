package org.example.huydq.service;

import org.example.huydq.entity.Student;
import org.example.huydq.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {

        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {

        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(long id, Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(long id) {

        studentRepository.deleteById(id);
    }
}
