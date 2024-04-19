package com.example.hakaton.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExamRequest {
    private String name;
    private LocalDate date;
    private LocalTime time;
    private int duration;
}
