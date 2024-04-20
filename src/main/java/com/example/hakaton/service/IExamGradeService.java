package com.example.hakaton.service;

import com.example.hakaton.dto.request.ExamGradeRequest;

public interface IExamGradeService {
    void createExamGrade(ExamGradeRequest examGrade, String email);
}
