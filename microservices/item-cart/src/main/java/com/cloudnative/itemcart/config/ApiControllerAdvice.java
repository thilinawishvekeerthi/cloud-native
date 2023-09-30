package com.cloudnative.itemcart.config;

import com.cloudnative.itemcart.config.exception.CustomException;
import com.cloudnative.itemcart.dto.CustomErrorDto;
import com.cloudnative.itemcart.dto.CustomResponse;
import com.cloudnative.itemcart.enums.CustomErrorEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiControllerAdvice {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomResponse> handleCustomException(CustomException ex){
        ex.printStackTrace();
        return new ResponseEntity<>(new CustomResponse(false, null,new CustomErrorDto(ex.getCustomErrorEnum().name(), ex.getCustomErrorEnum().getDescription())), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomResponse> handleException(Exception ex){
        ex.printStackTrace();
        return new ResponseEntity<>(new CustomResponse(false, null,new CustomErrorDto(CustomErrorEnum.ERROR_C02.name(), CustomErrorEnum.ERROR_C02.getDescription()+" SYSTEM EX :"+ ex.getMessage())), HttpStatus.BAD_REQUEST);
    }
}
