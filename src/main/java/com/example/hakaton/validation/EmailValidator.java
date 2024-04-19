package com.example.hakaton.validation;

import com.example.hakaton.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmailValidator implements ConstraintValidator<EmailValid, String> {
    private final UserRepository userInfoRepository;
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = userInfoRepository.findByEmail(s).isEmpty();
        if(!isValid){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Пользователь с таким адресом электронной почты уже существует!")
                    .addConstraintViolation();
        }
        return isValid;
    }
}
