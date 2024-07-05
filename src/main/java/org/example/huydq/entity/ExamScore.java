package org.example.huydq.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "examscore")
public class ExamScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    private double score;
}
