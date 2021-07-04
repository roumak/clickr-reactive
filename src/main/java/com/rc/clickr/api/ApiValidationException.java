package com.rc.clickr.api;

class ApiValidationException extends RuntimeException {
    private static final String MESSAGE_PREFIX = "API Validation Exception, ";

    protected ApiValidationException(String message){
        super(message);
    }

    public static ApiValidationException of(String message){
        return new ApiValidationException(MESSAGE_PREFIX +message);
    }
}
