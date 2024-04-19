package com.example.hakaton.api;

import com.example.hakaton.dto.request.ExamRequest;
import com.example.hakaton.service.IExamPaperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/examPaper")
@RequiredArgsConstructor
public class ExamPaperApi {
    private final IExamPaperService examPaperService;
    @PostMapping()
    public ResponseEntity<?> createExamPaper(@ModelAttribute ExamRequest exam) {
        examPaperService.createExamPaper(exam);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
