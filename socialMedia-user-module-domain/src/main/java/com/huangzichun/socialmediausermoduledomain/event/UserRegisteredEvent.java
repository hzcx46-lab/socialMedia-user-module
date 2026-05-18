package com.huangzichun.socialmediausermoduledomain.event;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserRegisteredEvent {
    private final String eventId;
    private final LocalDateTime occurredOn;
    private final Long userId;
    private final String mobile;

    public UserRegisteredEvent(Long userId, String mobile) {
        this.eventId = UUID.randomUUID().toString();
        this.occurredOn = LocalDateTime.now();
        this.userId = userId;
        this.mobile = mobile;
    }
}