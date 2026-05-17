package com.huangzichun.socialmediausermoduledomain.event;

import java.time.LocalDateTime;

public interface DomainEvent {
    String getEventId();

    LocalDateTime getOccurredOn();
}