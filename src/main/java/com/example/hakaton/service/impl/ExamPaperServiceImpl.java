package com.example.hakaton.service.impl;

import com.example.hakaton.dto.request.ExamRequest;
import com.example.hakaton.entity.Exam;
import com.example.hakaton.mapper.ModelMapper;
import com.example.hakaton.repository.ExamRepository;
import com.example.hakaton.service.IExamPaperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamPaperServiceImpl implements IExamPaperService {
    private final ExamRepository examRepository;

    @Override
    public void createExamPaper(ExamRequest examRequest) {
        Exam exam = ModelMapper.INSTANCE.toExam(examRequest);
        exam.getExamPaper().setExam(exam);
        examRepository.save(exam);
    }
}
