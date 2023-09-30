package com.cloudnative.itemcart.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomResponse {
    private boolean valid;
    private Object result;
    private Object error;

    public CustomResponse(Object result){
        this.valid = true;
        this.result = result;
    }
}
