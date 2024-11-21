package com.example.cqrs.exception;

import lombok.Getter;

@Getter
public class EventReplayException extends RuntimeException {

    public EventReplayException(String message, Throwable cause) {
        super(message, cause);
    }

}