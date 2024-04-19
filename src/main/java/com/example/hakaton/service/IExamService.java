package com.example.hakaton.service;

import java.util.List;

public interface IExamService {
    void addTeachers(List<Long> teacherIds, Long examId);
}
