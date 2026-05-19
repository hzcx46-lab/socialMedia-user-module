package com.huangzichun.socialmediausermoduledomain.exception;

public class DomainException extends BizException {
    public DomainException(BaseExceptionInterface exception) {super(exception);}
    public DomainException(String message) {super(message);}
}
