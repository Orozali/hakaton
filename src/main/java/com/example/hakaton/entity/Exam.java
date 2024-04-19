package com.example.hakaton.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

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
    @OneToOne(mappedBy = "exam", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    @RestResource(exported = false)
    @JsonIgnore
    private ExamPaper examPaper;
}
