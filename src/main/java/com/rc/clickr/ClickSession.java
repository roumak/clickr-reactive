package com.rc.clickr;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table("click_session")
public class ClickSession {
    @Id
    Long id;

    @NonNull
    @Column("session_id")
    String sessionId;

    @NonNull
    @Column("creation_timestamp")
    LocalDateTime creationDateTime;

    @NonNull
    @Column("created_by")
    String createdBy;
}
