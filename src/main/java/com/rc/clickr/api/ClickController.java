package com.rc.clickr.api;

import com.rc.clickr.ClickRepository;
import com.rc.clickr.Click;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@Slf4j
@RequestMapping("/api")
class ClickController {

    @Autowired
    ClickRepository repository;


    @PostMapping("/click")
    public ResponseEntity<Mono<Click>> registerClick(@RequestBody ClickDto clickDto) {
        log.info("clicking sessionId={}, userId={}",clickDto.getSession(),clickDto.getUserName());
        return ResponseEntity.ok(repository.registerClick(clickDto.getSession(), clickDto.getUserName()));
    }

    @PostMapping("/register")
    public ResponseEntity<Mono<Click>> registerUser(@RequestBody ClickRegisterDto clickDto) {
        return ResponseEntity.ok(repository.save(new Click(clickDto.getUserName(), clickDto.getSession(), LocalDateTime.now(), clickDto.getColour())));
    }

}
