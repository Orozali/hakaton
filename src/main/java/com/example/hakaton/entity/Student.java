package com.example.hakaton.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

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
@Builder
public class Student {
    @Id
    @SequenceGenerator(name = "student_gen", sequenceName = "student_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_gen")
    private Long id;
    private String name;
    private String surName;
    private String telNumber;
    private String university;
    private String faculty;
    private String profession;
    private int dateFrom;
    private int dateTo;
    @Column(unique = true)
    private String email;
    private String address;
    @Column(name = "image", length = 1000000)
    private byte[] image;
    @Column(name = "diplom", length = 1000000)
    private byte[] diploma;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @OneToOne(mappedBy = "student", fetch = FetchType.EAGER)
    private Application application;


}
