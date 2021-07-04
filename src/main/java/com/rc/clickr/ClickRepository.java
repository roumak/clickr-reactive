package com.rc.clickr;

import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ClickRepository extends ReactiveCrudRepository<Click, Long> {

    @Modifying
    @Query("UPDATE Click c SET c.click_Count = c.click_Count + 1 WHERE c.user_Name=:userName AND c.session_Id=:sessionId")
    Mono<Click> registerClick(String sessionId, String userName);

    @Query("SELECT * from Click where " +
            "session_id = :sessionId " +
            "AND user_name LIKE :#{ #userName==null || #userName.isEmpty? '%' : '%'+#userName+'%'}")
    Flux<Click> findClickDetailsBy(String sessionId, String userName);

    @Query("select count(*) from Click where session_id=:sessionId")
    Flux<String> getRedBlueStatBySessionId(Long sessionId);

}
