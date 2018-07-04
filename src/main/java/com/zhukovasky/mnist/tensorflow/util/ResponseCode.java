package com.zhukovasky.mnist.tensorflow.util;

import java.io.Serializable;

/**
 * 2017/3/3.
 */
public class ResponseCode implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1703255433851094042L;
	private String code;
    private String mesg;

    public ResponseCode(String code, String mesg) {
        this.code = code;
        this.mesg = mesg;
    }

    public String getCode() {
        return code;
    }

    public String getMesg() {
        return mesg;
    }

    @Override
    public String toString() {
        return "ResponseCode{" +
                "code='" + code + '\'' +
                ", mesg='" + mesg + '\'' +
                '}';
    }
}
