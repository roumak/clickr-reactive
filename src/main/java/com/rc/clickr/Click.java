package com.rc.clickr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Click {
    @Id
    @Column("id")
    Long id;

    @NonNull
    @Column("user_name")
    String userName;

    @Column("user_type")
    String userType;

    @NonNull
    @Column("session_id")
    String sessionId;

    @NonNull
    @Column("creation_timestamp")
    LocalDateTime creationDateTime;

    @NonNull
    String colour;

    @Column("click_count")
    long clickCount;
}
