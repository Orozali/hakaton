package com.example.hakaton.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExamGradeRequest {
    private short grade;
    private String feedback;
    private Long examAnswerId;
}
