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
public class ExamPaper {
    @Id
    @SequenceGenerator(name = "exam_paper_gen", sequenceName = "exam_paper_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exam_paper_gen")
    private Long id;

    @OneToOne()
    @JoinColumn(name = "exam_id", referencedColumnName = "id")
    private Exam exam;
}
