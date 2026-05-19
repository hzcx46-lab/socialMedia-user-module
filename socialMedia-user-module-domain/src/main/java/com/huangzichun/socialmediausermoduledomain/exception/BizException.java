package com.huangzichun.socialmediausermoduledomain.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BizException extends RuntimeException {
    // 错误码
    private String errorCode;
    // 错误信息
    private String errorMessage;

    public BizException(BaseExceptionInterface exception) {
        this.errorCode = exception.getErrorCode();
        this.errorMessage = exception.getErrorMessage();
    }

    //todo 需要收敛这几个构造方法
    public BizException(String errorCode) {
        this.errorCode = errorCode;
    }

    public BizException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BizException(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}
