package com.example.hakaton.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Form {
    @Id
    @SequenceGenerator(name = "form_gen", sequenceName = "form_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "form_gen")
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "exam_id", referencedColumnName = "id")
    @RestResource(exported = false)
    private Exam exam;
    private String question;
}
