package com.kutuphane.kutuphaneotomasyon.Core.utilities.exceptions.handlers;


import com.kutuphane.kutuphaneotomasyon.Core.utilities.exceptions.problemDetails.BusinessProblemDetails;
import com.kutuphane.kutuphaneotomasyon.Core.utilities.exceptions.problemDetails.ValidationProblemDetails;
import com.kutuphane.kutuphaneotomasyon.Core.utilities.exceptions.types.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleBusinessException(BusinessException exception){
        BusinessProblemDetails businessProblemDetails = new BusinessProblemDetails();
        businessProblemDetails.setDetail(exception.getMessage());
        return businessProblemDetails;
    }


    @ExceptionHandler({ MethodArgumentNotValidException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException exception) {

        Map<String,String> validationErrors = new HashMap<>();

        exception.getBindingResult().getFieldErrors().stream().map(error ->
                validationErrors.put(error.getField(),error.getDefaultMessage())
        ).collect(Collectors.toList());

        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
        validationProblemDetails.setErrors(validationErrors);
        return validationProblemDetails;
    }

}
