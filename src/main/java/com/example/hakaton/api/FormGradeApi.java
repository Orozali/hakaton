package com.example.hakaton.api;


import com.example.hakaton.service.FormGradeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/formGrade")
@Tag(name = "Form Grade API")
@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
public class FormGradeApi {
    private final FormGradeService formGradeService;

    @PostMapping()
    @PreAuthorize("hasAuthority('TEACHER')")
    public ResponseEntity<?> addFormGradeService(@RequestParam Long applicationId,
                                                 @RequestParam short grade){
        formGradeService.addGrade(applicationId,grade);
        return ResponseEntity.ok().build();
    }
}
