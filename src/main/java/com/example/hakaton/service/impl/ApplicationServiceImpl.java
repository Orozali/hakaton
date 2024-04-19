package com.example.hakaton.service.impl;

import com.example.hakaton.config.jwt.JwtService;
import com.example.hakaton.dto.request.ApplicationRequest;
import com.example.hakaton.dto.response.ApplicationResponse;
import com.example.hakaton.dto.response.SimpleResponse;
import com.example.hakaton.entity.Application;
import com.example.hakaton.entity.Student;
import com.example.hakaton.entity.User;
import com.example.hakaton.entity.enums.Status;
import com.example.hakaton.exception.exceptions.MessageSendingException;
import com.example.hakaton.exception.exceptions.NotFoundException;
import com.example.hakaton.repository.ApplicationRepository;
import com.example.hakaton.service.ApplicationService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final JavaMailSender javaMailSender;
    private final Configuration config;


    @Override
    public SimpleResponse approve(ApplicationRequest request) {
        Application application = applicationRepository.findById(request.applicationId())
                .orElseThrow(()->new NotFoundException("Заявка не найдено!"));
        String status = request.status().toString().toLowerCase();
        String statusResponse = "";
        switch (status){
            case "approved":
                statusResponse+= Status.APPROVED.toString();
                break;
            case "rejected":
                statusResponse+= Status.REJECTED.toString();
                break;
        }
        Student student = application.getStudent();
        application.setStatus(Status.valueOf(statusResponse));
        sendMessage(student, statusResponse);
        applicationRepository.save(application);

        if(statusResponse.equals(Status.APPROVED.toString())){
            return SimpleResponse.builder()
                    .httpStatus(HttpStatus.OK)
                    .message("Вы успешно одобрили!")
                    .build();
        }
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Вы успешно отклонили!")
                .build();

    }

    @Override
    public List<ApplicationResponse> getAllApplication() {
        List<ApplicationResponse> responses = new ArrayList<>();
        applicationRepository.findAll()
                .forEach(application ->{

                });
        return null;
    }


    private void sendMessage(Student student, String status){
        Map<String, Object> model = new HashMap<>();
        model.put("name", student.getName());
        model.put("status", status);
        model.put("university", student.getUniversity());
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            Template template = config.getTemplate("mail_template/approval.html");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            mimeMessageHelper.setTo(student.getEmail());
            mimeMessageHelper.setText(html, true);
            mimeMessageHelper.setSubject("Medcheck");
            mimeMessageHelper.setFrom("ilyazovorozali08@gmail.com");
            javaMailSender.send(message);
        } catch (IOException | MessagingException e) {
            throw new MessageSendingException("Ошибка при отправке сообщения!");
        } catch (freemarker.template.TemplateException e) {
            throw new RuntimeException(e);
        }
    }

}
