package com.example.hakaton.service;

import com.example.hakaton.dto.request.ExamAnswerRequest;

public interface IExamAnswerService {
    void createExamAnswer(ExamAnswerRequest examAnswerRequest, String email);
}
