package com.example.hakaton.entity;

import com.example.hakaton.entity.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.CascadeType.DETACH;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Application {
    @Id
    @SequenceGenerator(name = "application_gen", sequenceName = "application_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application_gen")
    private Long id;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne(cascade = {REFRESH, PERSIST, MERGE, DETACH})
    @JoinColumn(name = "student_id")
    private Student student;
    @OneToOne(mappedBy = "application")
    private ExamAnswer examAnswers;
    @OneToOne(mappedBy = "application")
    private FormGrade formGrade;
}
