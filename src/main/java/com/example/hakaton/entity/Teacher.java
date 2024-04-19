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
public class Teacher {
    @Id
    @SequenceGenerator(name = "teacher_gen", sequenceName = "teacher_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_gen")
    private Long id;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    private String name;
    private String surname;
    @ManyToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;
}
