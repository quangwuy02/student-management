package org.example.huydq.service;

import org.example.huydq.entity.Student;

import java.util.List;

public interface StudentService {
    public Student createStudent(Student student);

    public List<Student> getAllStudent();

    public Student updateStudent(long id, Student student);

    public void deleteStudent(long id);
}
