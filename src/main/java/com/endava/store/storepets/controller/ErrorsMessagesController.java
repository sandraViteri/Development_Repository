package com.endava.store.storepets.controller;

import com.endava.store.storepets.dto.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice(annotations = RestController.class)
public class ErrorsMessagesController {
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ValidationError> handleException(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getAllErrors()
                .stream()
                .map(this::mapError)
                .collect(Collectors.toList());
    }

    private ValidationError mapError(ObjectError objectError) {
        if (objectError instanceof FieldError) {
            return new ValidationError(((FieldError) objectError).getField(),
                    objectError.getDefaultMessage());
        }
        return new ValidationError(objectError.getObjectName(), objectError.getDefaultMessage());
    }

}
