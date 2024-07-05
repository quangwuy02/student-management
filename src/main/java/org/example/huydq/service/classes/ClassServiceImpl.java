package org.example.huydq.service.classes;

import org.example.huydq.entity.Class;
import org.example.huydq.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassRepository classRepository;

    @Override
    public Class saveClass(Class lop) {
        return classRepository.save(lop);
    }

    @Override
    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    @Override
    public Optional<Class> getClassById(Long id) {
        return classRepository.findById(id);
    }

    @Override
    public Class updateClass(long id, Class lop) {
        lop.setId(id);
        return classRepository.save(lop);
    }

    @Override
    public void deleteClass(long id) {
        classRepository.deleteById(id);
    }
}
