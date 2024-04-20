package com.example.hakaton.service.impl;

import com.example.hakaton.dto.request.ExamGradeRequest;
import com.example.hakaton.entity.ExamGrade;
import com.example.hakaton.entity.Teacher;
import com.example.hakaton.entity.User;
import com.example.hakaton.mapper.ModelMapper;
import com.example.hakaton.repository.ExamAnswerRepository;
import com.example.hakaton.repository.ExamGradeRepository;
import com.example.hakaton.repository.UserRepository;
import com.example.hakaton.service.IExamGradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamGradeServiceImpl implements IExamGradeService {
    private final ExamAnswerRepository examAnswerRepository;
    private final ExamGradeRepository examGradeRepository;
    private final UserRepository userRepository;
    @Override
    public void createExamGrade(ExamGradeRequest examGrade, String email) {
        ExamGrade examGradeEntity = ModelMapper.INSTANCE.toExamGrade(examGrade);
        examGradeEntity.setExamAnswer(examAnswerRepository.findById(examGrade.getExamAnswerId()).orElseThrow());
        Teacher teacher = userRepository.findByEmail(email).map(User::getTeacher).orElseThrow();
        examGradeEntity.setTeacher(teacher);
        examGradeRepository.save(examGradeEntity);
    }
}
