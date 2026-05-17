package com.huangzichun.socialmediausermoduledomain.exception;

public class DomainException extends RuntimeException {
    public DomainException(BaseExceptionInterface exception) {
        super(exception);
    }
    public DomainException(String message) {
        super(message);
    }
}
