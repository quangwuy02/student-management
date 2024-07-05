package org.example.huydq.service.examscore;

import org.example.huydq.entity.ExamScore;
import org.example.huydq.entity.Student;
import org.example.huydq.repository.ExamScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamScoreServiceImpl implements ExamScoreService{
    @Autowired
    private ExamScoreRepository examScoreRepository;

    @Override
    public ExamScore saveExamScore(ExamScore examScore) {
        return null;
    }

    @Override
    public List<ExamScore> getAllExamScore() {
        return List.of();
    }

    @Override
    public Optional<ExamScore> getExamScoreById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteExamScore(long id) {

    }
}
