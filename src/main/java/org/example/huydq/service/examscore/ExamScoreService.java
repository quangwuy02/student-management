package org.example.huydq.service.examscore;

import org.example.huydq.entity.Class;
import org.example.huydq.entity.ExamScore;
import org.example.huydq.entity.Student;

import java.util.List;
import java.util.Optional;

public interface ExamScoreService {
    public ExamScore saveExamScore(ExamScore examScore);

    public List<ExamScore> getAllExamScore();

    public Optional<ExamScore> getExamScoreById(Long id);

    public void deleteExamScore(long id);
}
