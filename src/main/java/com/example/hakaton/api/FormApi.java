package com.example.hakaton.api;

import com.example.hakaton.dto.request.FormRequest;
import com.example.hakaton.service.IFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/form")
@RequiredArgsConstructor
public class FormApi {
    private final IFormService formService;
    @PostMapping()
    public ResponseEntity<?> createForm(@RequestBody List<FormRequest> form) {
        formService.createForm(form);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
