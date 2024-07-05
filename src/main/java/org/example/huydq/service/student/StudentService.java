package org.example.huydq.service.student;

import org.example.huydq.entity.Student;
import org.example.huydq.respone.Respone;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public Respone saveStudent(Student student);

    public List<Student> getAllStudents();

    public Optional<Student> getStudentById(Long id);

    public String deleteStudent(long id);

    public Optional<Student> findByEmail(String email);

    public Optional<Student> findByStudentNumber(String studentNumber);

}
