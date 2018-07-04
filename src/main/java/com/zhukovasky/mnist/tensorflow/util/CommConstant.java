package com.zhukovasky.mnist.tensorflow.util;

import java.io.Serializable;

public class CommConstant implements Serializable {
    public static final ResponseCode SUCCESS = new ResponseCode("000000", "请求处理成功");
    public static final ResponseCode SYSTEM_FAIL = new ResponseCode("-1", "系统异常, 请联系系统管理员");
    public static final ResponseCode ARGUMENT_INVALID = new ResponseCode("-2", "请求参数错误");

    public static final String SUCCESS_CODE = "000000";
    public static final String SUCCESS_MESG = "请求处理成功";

    


}
