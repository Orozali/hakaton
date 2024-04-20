package com.example.hakaton.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamGrade {
    @Id
    @SequenceGenerator(name = "exam_answer_gen", sequenceName = "exam_answer_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exam_answer_gen")
    private Long id;
    private short grade;
    private String feedback;
    @OneToOne()
    @JoinColumn(name = "exam_answer_id", referencedColumnName = "id")
    private ExamAnswer examAnswer;
    @OneToOne()
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;
}
