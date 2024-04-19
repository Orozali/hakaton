package com.example.hakaton.api;

import com.example.hakaton.dto.request.ApplicationRequest;
import com.example.hakaton.dto.response.SimpleResponse;
import com.example.hakaton.service.ApplicationService;
import com.example.hakaton.service.TeacherService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/application")
@Tag(name = "Application API")
@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
public class ApplicationApi {


    private final ApplicationService applicationService;

    @PatchMapping ("/approve")
    public SimpleResponse approveStudent(@RequestBody ApplicationRequest request){
        return applicationService.approve(request);

    }
}
