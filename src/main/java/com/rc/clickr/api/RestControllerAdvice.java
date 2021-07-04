package com.rc.clickr.api;

import lombok.Builder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.publisher.Mono;

@ControllerAdvice
class RestControllerAdvice {

    @ExceptionHandler(ApiValidationException.class)
    ResponseEntity<Mono<ExceptionResponse>> handleValidationException(ApiValidationException exception){

        return ResponseEntity
                .badRequest()
                .body(Mono.just(
                        ExceptionResponse.builder()
                                .message(exception.getMessage())
                                .build()
                        )
                );
    }
}

@Builder
class ExceptionResponse {
    private String message;
}