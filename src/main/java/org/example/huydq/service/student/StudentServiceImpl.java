package org.example.huydq.service.student;

import org.example.huydq.entity.Student;
import org.example.huydq.exception.StudentNotFoundException;
import org.example.huydq.repository.StudentRepository;
import org.example.huydq.respone.Respone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Respone saveStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        return new Respone("Thêm học sinh thành công", savedStudent);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public String deleteStudent(long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("can't find any student with id "
                        + id));
        studentRepository.delete(student);
        return "Student "+student.getName()+" have id "+student.getId()+", successfully deleted from database";
    }

    @Override
    public Optional<Student> findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public Optional<Student> findByStudentNumber(String studentCode) {
        return studentRepository.findByStudentCode(studentCode);
    }
}
