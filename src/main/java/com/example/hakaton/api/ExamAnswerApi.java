package com.example.hakaton.api;

import com.example.hakaton.dto.request.ExamAnswerRequest;
import com.example.hakaton.service.IExamAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/examAnswer")
@RequiredArgsConstructor
public class ExamAnswerApi {
    private final IExamAnswerService examAnswerService;
    @PostMapping()
    public ResponseEntity<?> createExamAnswer(@ModelAttribute ExamAnswerRequest examAnswer, Authentication authentication) {
        examAnswerService.createExamAnswer(examAnswer, authentication.getName());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
