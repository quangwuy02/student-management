package org.example.huydq.service.subject;

import org.example.huydq.entity.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    public Subject saveSubject(Subject subject);

    public List<Subject> getAllSubject();

    public Optional<Subject> getSubjectById(Long id);

    public void deleteSubject(long id);
}
