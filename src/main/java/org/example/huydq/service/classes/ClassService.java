package org.example.huydq.service.classes;

import org.example.huydq.entity.Class;
import org.example.huydq.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ClassService {
    public Class saveClass(Class lop);

    public List<Class> getAllClasses();
    public Optional<Class> getClassById(Long id);

    public Class updateClass(long id, Class lop);

    public void deleteClass(long id);
}
