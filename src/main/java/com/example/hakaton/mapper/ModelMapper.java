package com.example.hakaton.mapper;

import com.example.hakaton.dto.request.ExamRequest;
import com.example.hakaton.dto.request.FormRequest;
import com.example.hakaton.entity.Exam;
import com.example.hakaton.entity.Form;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Mapper
public interface ModelMapper {
    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);
    @Mapping(source = "examPaper.multipartFile", target = "examPaper.file", qualifiedByName = "getBytes")
    Exam toExam(ExamRequest examRequest);
    @Named("getBytes")
    default byte[] getBytes(MultipartFile file) throws IOException {
        return file != null ? file.getBytes() : null;
    }
    Form toForm(FormRequest formRequest);
}
