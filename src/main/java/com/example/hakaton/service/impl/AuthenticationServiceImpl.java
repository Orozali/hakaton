package com.example.hakaton.service.impl;

import com.example.hakaton.config.jwt.JwtService;
import com.example.hakaton.dto.request.AuthenticateRequest;
import com.example.hakaton.dto.request.RegisterRequest;
import com.example.hakaton.dto.response.AuthenticationResponse;
import com.example.hakaton.entity.Student;
import com.example.hakaton.entity.User;
import com.example.hakaton.entity.enums.Role;
import com.example.hakaton.exception.exceptions.MessageSendingException;
import com.example.hakaton.repository.StudentRepository;
import com.example.hakaton.service.AuthenticationService;
import com.example.hakaton.utils.ImageUtils;
import freemarker.template.Template;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import freemarker.template.Configuration;
import org.mapstruct.ap.shaded.freemarker.template.TemplateException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final JavaMailSender javaMailSender;
    private final Configuration config;
    private final StudentRepository studentRepository;
    private final JwtService jwtService;

    private static final int PASSWORD_LENGTH = 10;


    @Override
    public AuthenticationResponse signUp(RegisterRequest request) throws IOException {
        Student student = Student.builder()
                .name(request.name())
                .surName(request.surName())
                .address(request.address())
                .telNumber(request.telNumber())
                .university(request.university())
                .faculty(request.faculty())
                .profession(request.profession())
                .dateFrom(request.dateFrom())
                .dateTo(request.dateTo())
                .image(request.image().getBytes())
                .diplom(request.diploma().getBytes())
                .build();

        com.example.hakaton.entity.User user = com.example.hakaton.entity.User.builder()
                .student(student)
                .role(Role.STUDENT)
                .email(request.email())
                .build();
        sendMessage(user, request.email());
        studentRepository.save(student);
        String token = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .roles(user.getRole())
                .accessToken(token)
                .email(user.getEmail())
                .build();
    }

    @Override
    public AuthenticationResponse signIn(AuthenticateRequest request) {
        return null;
    }

    private void sendMessage(User user, String email){
        String uniqueCode = generatePassword();
        user.setPassword(uniqueCode);
        Map<String, Object> model = new HashMap<>();
        model.put("code", uniqueCode);

        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            Template template = config.getTemplate("mail_template/password.html");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            mimeMessageHelper.setTo(email);
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

    private String generatePassword() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[PASSWORD_LENGTH];
        secureRandom.nextBytes(randomBytes);
        return Base64.getEncoder().encodeToString(randomBytes);
    }
}
