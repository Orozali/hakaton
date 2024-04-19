package com.example.hakaton.service.impl;

import com.example.hakaton.config.jwt.JwtService;
import com.example.hakaton.dto.request.ApplicationRequest;
import com.example.hakaton.dto.response.SimpleResponse;
import com.example.hakaton.entity.Application;
import com.example.hakaton.entity.enums.Status;
import com.example.hakaton.exception.exceptions.NotFoundException;
import com.example.hakaton.repository.ApplicationRepository;
import com.example.hakaton.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Override
    public SimpleResponse approve(ApplicationRequest request) {
        Application application = applicationRepository.findById(request.applicationId())
                .orElseThrow(()->new NotFoundException("Заявка не найдено!"));
        String status = request.status().toString().toLowerCase();
        String statusResponse = "";
        switch (status){
            case "approve":
                statusResponse+= Status.APPROVED;
                break;
            case "reject":
                statusResponse+= Status.REJECTED;
                break;
        }
        application.setStatus(Status.valueOf(statusResponse));
        applicationRepository.save(application);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Вы успешно одобрили!")
                .build();
    }
}
