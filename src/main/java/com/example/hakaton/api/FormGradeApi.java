package com.example.hakaton.api;


import com.example.hakaton.service.FormGradeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/formGrade")
@Tag(name = "Form Grade API")
@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
public class FormGradeApi {
    private final FormGradeService formGradeService;
}
