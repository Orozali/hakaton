package com.example.hakaton.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Exam {
    @Id
    @SequenceGenerator(name = "exam_gen", sequenceName = "exam_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exam_gen")
    private Long id;
    private String name;
    private LocalDate date;
    private LocalTime time;
    private int duration;
    @OneToOne(mappedBy = "exam")
    private ExamPaper examPaper;
}
