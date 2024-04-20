package com.example.hakaton.api;

import com.example.hakaton.dto.request.ExamGradeRequest;
import com.example.hakaton.service.IExamGradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/examGrade")
@RequiredArgsConstructor
public class ExamGradeApi {
    private final IExamGradeService examGradeService;
    @PostMapping()
    public ResponseEntity<?> createExamGrade(@RequestBody ExamGradeRequest examGradeRequest,
                                             Authentication authentication) {
        examGradeService.createExamGrade(examGradeRequest, authentication.getName());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
