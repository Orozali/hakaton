package com.example.hakaton.service.impl;

import com.example.hakaton.entity.Application;
import com.example.hakaton.entity.Student;
import com.example.hakaton.entity.enums.Status;
import com.example.hakaton.repository.ApplicationRepository;
import com.example.hakaton.repository.StudentRepository;
import com.example.hakaton.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class DataLoader implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final ApplicationRepository applicationRepository;
    private final ResourceLoader resourceLoader;

    public DataLoader(StudentRepository studentRepository, ApplicationRepository applicationRepository, ResourceLoader resourceLoader) {
        this.studentRepository = studentRepository;
        this.applicationRepository = applicationRepository;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void run(String... args) throws Exception {
//        int count = 2000;
//        for (int i = 0; i < 5; i++) {
//            String email = ++count + ".0101@manas.edu.kg";
//            Student student = createStudent(email);
//            Application application = Application.builder()
//                    .status(Status.PENDING)
//                    .student(student)
//                    .build();
//
//            applicationRepository.save(application);
//            studentRepository.save(student);
//        }
    }

//    private Student createStudent(String email) throws IOException {
//        byte[] imageBytes = getImageBytes("static/img/student.png");
//        byte[] diplomaBytes = getImageBytes("static/img/diploma.jpeg");
//
//        return Student.builder()
//                .name("John")
//                .surName("Doe")
//                .telNumber("+996551553552")
//                .university("Example University")
//                .faculty("Computer Science")
//                .profession("Software Engineer")
//                .dateFrom(2018)
//                .dateTo(2022)
//                .email(email)
//                .address("123 Example St, Example City")
//                .image(imageBytes)
//                .diplom(diplomaBytes)
//                .build();
//    }

//    private byte[] getImageBytes(String filePath) throws IOException {
//        Resource resource = resourceLoader.getResource("classpath:" + filePath);
//        return Files.readAllBytes(resource.getFile().toPath());
//    }
}
