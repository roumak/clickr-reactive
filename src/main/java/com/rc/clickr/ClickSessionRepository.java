package com.rc.clickr;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ClickSessionRepository extends ReactiveCrudRepository<ClickSession,Long> {

}
