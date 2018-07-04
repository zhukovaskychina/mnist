package com.zhukovasky.mnist.tensorflow.util;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * rest请求返回值(JSON)
 */
public class ReturnJson<T> {
    private final String resultCode;

    private final String resultMesg;

    private final T data;


    public ReturnJson() {
        this.resultCode = CommConstant.SUCCESS_CODE;
        this.resultMesg = CommConstant.SUCCESS_MESG;
        this.data = null;
    }

    public ReturnJson(String resultCode, String resultMesg, T data) {
        this.resultCode = resultCode;
        this.resultMesg = resultMesg;
        this.data = data;
    }

    public static ReturnJson json(ResponseCode responseCode, Object data) {
        return new ReturnJson<>(responseCode.getCode(), responseCode.getMesg(), data);
    }

    public static ReturnJson json(ResponseCode responseCode) {
        return new ReturnJson<>(responseCode.getCode(), responseCode.getMesg(), null);
    }

    /**
     * 返回成功的JSON串
     *
     * @param data 有参数
     * @return ReturnJson
     */
    public static ReturnJson success(Object data) {
        if (data instanceof ResponseCode) {
            return json((ResponseCode) data);
        }
        return ReturnJson.json(CommConstant.SUCCESS, data);
    }

    /**
     * 返回成功的JSON串
     */
    public static ReturnJson success() {
        return ReturnJson.success(null);
    }


    /**
     * 返回默认失败的JSON串
     *
     * @param data 返回值
     * @return json串
     */
    public static ReturnJson fail(Object data) {
        if (data instanceof ResponseCode) {
            return json((ResponseCode) data);
        }
        return ReturnJson.json(CommConstant.SYSTEM_FAIL, data);
    }


    /**
     * 返回失败的JSON串,数据体为null
     *
     * @return ReturnJson
     */
    public static ReturnJson fail(Exception exception) {
        if (exception == null) {
            return ReturnJson.fail(null);
        }
        CommonResult commonResult = new CommonResult();
        commonResult.setErrorMessage(exception.getMessage());
        commonResult.setExceptionName(exception.getClass().getSimpleName());
        commonResult.setStackTrace(ExceptionUtils.getStackTrace(exception));
        return ReturnJson.fail(commonResult);
    }

    /**
     * 根据结果码、结果信息、数据体生成实体
     *
     * @param resultCode 结果码
     * @param resultMesg 结果信息
     * @param data       数据体
     * @return 实体
     */
    public static ReturnJson json(String resultCode, String resultMesg, Object data) {
        return new ReturnJson<>(resultCode, resultMesg, data);
    }


    /**
     * 根据结果码判断请求是否处理成功
     *
     * @return isSuccess
     */
    @JsonIgnore
    public boolean isSuccess() {
        return CommConstant.SUCCESS_CODE.equalsIgnoreCase(resultCode);
    }

    @JsonIgnore
    public ResponseCode getResponseCode() {
        return new ResponseCode(resultCode, resultMesg);
    }

    /**
     * 返回结果code
     *
     * @return getResultCode
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * 返回结果具体信息
     *
     * @return getResultMesg
     */
    public String getResultMesg() {
        return resultMesg;
    }

    /**
     * 返回结果的具体数据
     *
     * @return getData
     */
    public T getData() {
        return data;
    }

}
