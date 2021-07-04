package com.rc.clickr.api;

class RequestParamValidationException extends ApiValidationException {
    private static final String MESSAGE_PREFIX = "RequestParam exception, ";

    protected RequestParamValidationException(String s) {
        super(s);
    }

    public static RequestParamValidationException of(String message){
        return  new RequestParamValidationException(MESSAGE_PREFIX + message);
    }

}
