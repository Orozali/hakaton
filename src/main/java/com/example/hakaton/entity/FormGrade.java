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
public class FormGrade {
    @Id
    @SequenceGenerator(name = "application_gen", sequenceName = "application_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application_gen")
    private Long id;
    @OneToOne()
    @JoinColumn(name = "application_id", referencedColumnName = "id")
    private Application application;
    @ManyToOne()
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;
    private short grade;
}
