package com.example.hakaton.service.impl;

import com.example.hakaton.dto.request.ExamAnswerRequest;
import com.example.hakaton.entity.Application;
import com.example.hakaton.entity.ExamAnswer;
import com.example.hakaton.entity.Student;
import com.example.hakaton.entity.User;
import com.example.hakaton.mapper.ModelMapper;
import com.example.hakaton.repository.ExamAnswerRepository;
import com.example.hakaton.repository.UserRepository;
import com.example.hakaton.service.IExamAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamAnswerServiceImpl implements IExamAnswerService {
    private final ExamAnswerRepository examAnswerRepository;
    private final UserRepository userRepository;
    @Override
    public void createExamAnswer(ExamAnswerRequest examAnswerRequest, String email) {
        ExamAnswer examAnswer = ModelMapper.INSTANCE.toExamAnswer(examAnswerRequest);
        Application application = userRepository.findByEmail(email).map(User::getStudent).map(Student::getApplication)
                .orElseThrow();
        examAnswer.setApplication(application);
        examAnswerRepository.save(examAnswer);
    }
}
