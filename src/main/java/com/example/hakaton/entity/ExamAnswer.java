package com.example.hakaton.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamAnswer {
    @Id
    @SequenceGenerator(name = "exam_answer_gen", sequenceName = "exam_answer_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exam_answer_gen")
    private Long id;
    @OneToOne()
    @JoinColumn(name = "application_id", referencedColumnName = "id")
    private Application application;
    private byte[] image;
    @OneToOne(mappedBy = "examAnswer")
    private ExamGrade examGrade;
}
