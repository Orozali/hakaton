package com.example.hakaton.api;

import com.example.hakaton.dto.request.ApplicationRequest;
import com.example.hakaton.dto.response.ApplicationResponse;
import com.example.hakaton.dto.response.SimpleResponse;
import com.example.hakaton.dto.response.StudentResponse;
import com.example.hakaton.service.ApplicationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/application")
@Tag(name = "Application API")
@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
public class ApplicationApi {


    private final ApplicationService applicationService;

    @GetMapping()
    public List<ApplicationResponse> getAllApplication() {
        return applicationService.getAllApplication();
    }

    @PatchMapping("/approve")
    public SimpleResponse approveStudent(@RequestBody ApplicationRequest request) {
        return applicationService.approve(request);
    }

    @GetMapping("/{id}")
    public StudentResponse getApplicationById(@PathVariable("id") Long applicationId) throws IOException {
        return applicationService.getApplicationById(applicationId);
    }
}