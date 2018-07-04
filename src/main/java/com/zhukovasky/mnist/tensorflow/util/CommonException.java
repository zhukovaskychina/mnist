package com.zhukovasky.mnist.tensorflow.util;

public class CommonException extends RuntimeException {
    private final ResponseCode responseCode;

    /**
     * Source Throwable, message, status code and info about the cause
     */
    public CommonException(Throwable throwable, ResponseCode responseCode) {
        super(responseCode.getMesg(), throwable);
        this.responseCode = responseCode;
    }

    /**
     * error message, status code and info about the cause
     */
    public CommonException(ResponseCode responseCode) {
        super(responseCode.getMesg());
        this.responseCode = responseCode;
    }

    public CommonException(String code, String mesg) {
        super(mesg);
        ResponseCode temp = new ResponseCode(code, mesg);
        this.responseCode = temp;
    }

    public CommonException(Throwable throwable, String mesg) {
        super(mesg, throwable);
        ResponseCode temp = new ResponseCode("-1", mesg);
        this.responseCode = temp;
    }


    public ResponseCode getResponseCode() {
        return responseCode;
    }
}
