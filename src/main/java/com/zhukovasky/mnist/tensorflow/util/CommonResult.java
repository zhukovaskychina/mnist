package com.zhukovasky.mnist.tensorflow.util;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 接口调用失败的异常信息
 */
public class CommonResult implements Serializable {
    private static final int STACK_TRACE_MAX_LEN = 2000;

    /**
     * 异常类
     */
    private String exceptionName;
    /**
     * 错误原因
     */
    private String errorMessage;
    /**
     * 详细错误信息
     */
    private String stackTrace;

    public String getExceptionName() {
        return exceptionName;
    }

    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        if (StringUtils.length(stackTrace) > STACK_TRACE_MAX_LEN) {
            stackTrace = StringUtils.substring(stackTrace, 0, STACK_TRACE_MAX_LEN);
        }
        this.stackTrace = stackTrace;
    }
}