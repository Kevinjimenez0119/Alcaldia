package com.app.alcaldia.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.alcaldia.api.utils.ValidationException;

@RestControllerAdvice
public class AppExceptionHandler {

	@ResponseBody
    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<?> handleException(ValidationException exception) {
        return ResponseEntity.status(exception.getStatus()).body(exception.getMsg());
    }
	
}
