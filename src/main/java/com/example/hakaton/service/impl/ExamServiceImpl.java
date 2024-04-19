package com.example.hakaton.service.impl;

import com.example.hakaton.entity.Teacher;
import com.example.hakaton.repository.ExamRepository;
import com.example.hakaton.repository.TeacherRepository;
import com.example.hakaton.service.IExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements IExamService {
    private final ExamRepository examRepository;
    private final TeacherRepository teacherRepository;;

    @Override
    public void addTeachers(List<Long> teacherIds, Long examId) {
        List<Teacher> teachers = teacherRepository.findAllById(teacherIds);
        teachers.forEach(teacher -> teacher.setExam(
                examRepository.findById(examId).orElseThrow()
        ));
        teacherRepository.saveAll(teachers);
    }
}
