package com.cloudnative.itemcart.enums;

public enum CustomErrorEnum {
    ERROR_C01("Value not found"),
    ERROR_C02("System Error");

    private final String description;

    CustomErrorEnum(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
