package com.example.hakaton.exception.exceptionHandler;

import com.example.hakaton.exception.exceptionResponse.ExceptionResponse;
import com.example.hakaton.exception.exceptions.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler{

    private final MessageSource messageSource;


    @ExceptionHandler(AuthenticationFailException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionResponse authenticationFail(AuthenticationFailException exception) {
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .exceptionClassName(exception.getClass().getSimpleName())
                .message(exception.getMessage())
                .build();
    }


    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ExceptionResponse notFound(NotFoundException exception) {
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.NOT_FOUND)
                .exceptionClassName(exception.getClass().getSimpleName())
                .message(exception.getMessage())
                .build();
    }


    @ExceptionHandler(AlreadyExistException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionResponse alreadyExist(AlreadyExistException exception) {
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .exceptionClassName(exception.getClass().getSimpleName())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionResponse methodArgumentNotValid(MethodArgumentNotValidException exception) {
        FieldError fieldError = Objects.requireNonNull(exception.getFieldError());
        String defaultMessage = fieldError.getDefaultMessage();
        assert defaultMessage != null;
        String localizedMessage = messageSource.getMessage(defaultMessage, null, LocaleContextHolder.getLocale());

        System.out.println(exception.getClass().getSimpleName());
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .exceptionClassName(exception.getClass().getSimpleName())
                .message(localizedMessage)
                .build();
    }


    @ExceptionHandler(BadCredentialException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ExceptionResponse badCredential(BadCredentialException exception) {
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .exceptionClassName(exception.getClass().getSimpleName())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionResponse badCredential(BadRequestException exception) {
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .exceptionClassName(exception.getClass().getSimpleName())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(MessageSendingException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionResponse messageSending(MessageSendingException exception){
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .exceptionClassName(exception.getClass().getSimpleName())
                .message(exception.getMessage())
                .build();
    }
}
