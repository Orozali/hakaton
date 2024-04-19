package com.example.hakaton.service.impl;

import com.example.hakaton.dto.request.FormRequest;
import com.example.hakaton.entity.Form;
import com.example.hakaton.mapper.ModelMapper;
import com.example.hakaton.repository.ExamRepository;
import com.example.hakaton.repository.FormRepository;
import com.example.hakaton.service.IFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FormServiceImpl implements IFormService {
    private final FormRepository formRepository;
    private final ExamRepository examRepository;

    @Override
    public void createForm(List<FormRequest> formRequests) {
        List<Form> forms = formRequests.stream().map(this::toForm).toList();
        formRepository.saveAll(forms);
    }

    private Form toForm(FormRequest formRequest) {
        Form form = ModelMapper.INSTANCE.toForm(formRequest);
        form.setExam(examRepository.findById(formRequest.getExamId()).orElseThrow());
        return form;
    }
}
