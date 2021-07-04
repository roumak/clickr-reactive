package com.rc.clickr.api;

import com.rc.clickr.Click;
import com.rc.clickr.ClickRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequestMapping("/api/data")
class ClickDataController {

    @Autowired
    private ClickRepository repository;

    @GetMapping
    public ResponseEntity<Flux<Click>> getAndFilterBySession(@RequestParam(name = "session_id",required = false) String sessionId,
                                                             @RequestParam(name = "user_name",required = false) String userName) {
        log.info("getting data filtered by sessionId={}, userName={}",sessionId,userName);
        validate(sessionId,userName);
        if(sessionId==null){
            return ResponseEntity.ok(repository.findAll());
        }
        return ResponseEntity.ok(repository.findClickDetailsBy(sessionId,userName));
    }

    private void validate(String sessionId, String userName) {
        if(sessionId==null && userName!=null ){
            throw RequestParamValidationException.of("if session_id is null, user_name must also be null");
        }
    }


}
