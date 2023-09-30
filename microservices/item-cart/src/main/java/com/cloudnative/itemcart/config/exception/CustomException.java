package com.cloudnative.itemcart.config.exception;

import com.cloudnative.itemcart.enums.CustomErrorEnum;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomException extends RuntimeException{
    private CustomErrorEnum  customError;
    public CustomException(CustomErrorEnum customError, String message){
        super(message);
        this.customError = customError;
    }

    public CustomErrorEnum getCustomErrorEnum(){
        return  customError;
    }

}
