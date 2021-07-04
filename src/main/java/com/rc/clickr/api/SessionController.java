package com.rc.clickr.api;

import com.rc.clickr.ClickSession;
import com.rc.clickr.ClickSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/session")
class SessionController {

    @Autowired
    ClickSessionRepository repository;

    @GetMapping
    ResponseEntity<Flux<ClickSession>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }
}
