package com.example.hakaton.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @SequenceGenerator(name = "department_gen", sequenceName = "department_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_gen")
    private Long id;
    private String name;
    private String institute;
    @OneToMany(mappedBy = "department")
    private List<Teacher> teachers;
}
