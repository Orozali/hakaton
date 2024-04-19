package com.example.hakaton.api;

import com.example.hakaton.dto.request.ExamRequest;
import com.example.hakaton.service.IExamPaperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/examPaper")
@RequiredArgsConstructor
public class ExamPaperApi {
    private final IExamPaperService examPaperService;
    @PostMapping()
    public ResponseEntity<?> createExamPaper(@RequestBody ExamRequest exam) {
        examPaperService.createExamPaper(exam);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
