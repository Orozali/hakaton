package com.example.hakaton.service.impl;

import com.example.hakaton.config.jwt.JwtService;
import com.example.hakaton.entity.Application;
import com.example.hakaton.entity.FormGrade;
import com.example.hakaton.entity.Teacher;
import com.example.hakaton.repository.ApplicationRepository;
import com.example.hakaton.repository.FormGradeRepository;
import com.example.hakaton.repository.FormRepository;
import com.example.hakaton.service.FormGradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FormGradeServiceImpl implements FormGradeService {

    private final ApplicationRepository applicationRepository;
    private final FormGradeRepository formGradeRepository;
    private final JwtService jwtService;
    @Override
    public void addGrade(Long applicationId, short grade) {
        Teacher teacher =  jwtService.getAuthenticate().getTeacher();
        Application application = applicationRepository.findById(applicationId)
                .orElseThrow();
        var formGrade = FormGrade.builder()
                .grade(grade)
                .application(application)
                .teacher(teacher)
                .build();
        application.setFormGrade(formGrade);
        formGradeRepository.save(formGrade);
        applicationRepository.save(application);
    }
}
