package com.example.hakaton.api;

import com.example.hakaton.service.ApplicationService;
import com.example.hakaton.service.IExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/exam")
@RequiredArgsConstructor
public class ExamApi {
    private final IExamService examService;
    private final ApplicationService applicationService;
    @PatchMapping("/{examId}/addTeachers")
    public ResponseEntity<?> addTeachers(@RequestBody List<Long> teachers, @PathVariable Long examId) {
        examService.addTeachers(teachers, examId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/rating")
    public ResponseEntity<?> getRatings(@RequestParam Long examId) {
        return ResponseEntity.ok(applicationService.getRatings(examId));
    }
}
