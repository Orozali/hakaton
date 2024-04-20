package com.example.hakaton.entity;

import com.example.hakaton.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.rest.core.annotation.RestResource;

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
    @OneToOne(cascade = {REFRESH, PERSIST, MERGE, DETACH})
    @JoinColumn(name = "student_id")
    @RestResource(exported = false)
    @JsonIgnore
    private Student student;
    @OneToOne(mappedBy = "application")
    private ExamAnswer examAnswers;
    @OneToOne(mappedBy = "application")
    private FormGrade formGrade;
}
