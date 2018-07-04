package com.zhukovasky.mnist.tensorflow.util;

import java.io.Serializable;

public class CommConstant implements Serializable {
    public static final ResponseCode SUCCESS = new ResponseCode("000000", "请求处理成功");
    public static final ResponseCode SYSTEM_FAIL = new ResponseCode("-1", "系统异常, 请联系系统管理员");
    public static final ResponseCode ARGUMENT_INVALID = new ResponseCode("-2", "请求参数错误");

    public static final String SUCCESS_CODE = "000000";
    public static final String SUCCESS_MESG = "请求处理成功";

    /**
     * 常用网站ID
     */
    public static final int SITE_ID_TUIGUANGJIA = 100;
    public static final int SITE_ID_AILABA = 101;
    public static final int SITE_ID_QIDU = 102;
    public static final int SITE_ID_C_C = 103;
    public static final int SITE_ID_587766 = 104;
    public static final int SITE_ID_TAOJINDI = 105;
    public static final int SITE_ID_99INF = 106;
    public static final int SITE_ID_258 = 107;
    public static final int SITE_ID_ZK71 = 108;

    /**
     * 判断是否是异步调用的网站
     */
    public static boolean isAsyncSite(Integer siteId) {
        return SITE_ID_TAOJINDI == siteId || SITE_ID_258 == siteId || SITE_ID_ZK71 == siteId;
    }

    /**
     * 当前用户session的KEY值
     */
    public static final String CURRENT_LOGIN_USER = "loginInfo";
    public static final String CURRENT_RECOMM_USER_ID = "recommUserId";

    /**
     * 有效标志:0无效 1有效
     */
    public static final String VALID = "1";
    public static final String INVALID = "0";
    /**
     * 有效标志:0无效 1有效
     */
    //会员续费
    public static final String MEM_CONSUME = "consume";
    //开通会员
    public static final String MEM_RECHARGE = "recharge";
    //发布信息
    public static final String MEM_SEND = "send";
    /**
     * 有效标志:0无效 1有效
     */
    public static final String FLAG_Y = "1";
    public static final String FLAG_N = "0";
    /**
     * 是否展示:0无效 1有效
     */
    public static final String SHOW = "1";
    public static final String HIDE = "0";
    /**
     * 最新审核状态（0未审核/1审核中/2成功/3失败）
     */
    public static final String AUTH_INIT = "0";
    public static final String AUTH_BEING = "1";
    public static final String AUTH_SUCCESS = "2";
    public static final String AUTH_FAIL = "3";
    /**
     * 发布状态（0未发布/1发布中/2成功/3失败/5等待审核）
     * batchId=-1 是表示当前正在等待队列
     */
    public static final String PUBLISH_INIT = "0";//batchId=0
    public static final String PUBLISH_BEING = "1";
    public static final String PUBLISH_SUCCESS = "2";
    public static final String PUBLISH_FAIL = "3";
    public static final String PUBLISH_WAIT_AUTH = "5";

    /**
     * 审核类型
     */
    public static final String AUTH_TYPE_COMPANY = "COMPANY";
    public static final String AUTH_TYPE_PERSON = "PERSON";
    public static final String AUTH_TYPE_MATERIAL = "MATERIAL";

    /**
     * 方式 1 自选 2 套餐
     */
    public static final String CHOOSE_TYPE_SELF = "1";
    public static final String CHOOSE_TYPE_COMBO = "2";

//    黄金版
//    白金版
//    钻石版
    /**
     * 会员类型
     */
    //免费会员
    public static final String MEMBER_LEVEL_FREE = "free";
    //黄金版会员
    public static final String MEMBER_LEVEL_GOLD = "gold";
    //白金版会员
    public static final String MEMBER_LEVEL_PLAT = "plat";
    //钻石版会员
    public static final String MEMBER_LEVEL_DIAM = "diam";
    //保持会员
    public static final String MEMBER_LEVEL_MAINTAIN = "maintain";
    //进取会员
    public static final String MEMBER_LEVEL_EAGER = "eager";
    //超越会员
    public static final String MEMBER_LEVEL_SUPERIOR = "superior";
    //智慧会员
    public static final String MEMBER_LEVEL_WISDOM = "wisdom";
    //自选会员
    public static final String MEMBER_LEVEL_SELF = "self";

    /**
     * 代理商
     */
    public static final String SUB_SYSTEM_AGENT = "AGENT";
    /**
     * 合作商
     */
    public static final String SUB_SYSTEM_USER = "USER";
    /**
     * 合作网站
     */
    public static final String SUB_SYSTEM_WEB_MASTER = "WEB_MASTER";
    /**
     * 后台管理
     */
    public static final String SUB_SYSTEM_MANAGER = "MANAGER";

    /**
     * 用户登录相关错误码
     */
    public static final ResponseCode CAPTCHA_VALIDATE_FAIL = new ResponseCode("010100", "验证码校验失败");
    public static final ResponseCode LOGIN_VALIDATE_FAIL = new ResponseCode("010101", "用户名密码校验失败");
    public static final ResponseCode ROLE_VALIDATE_FAIL = new ResponseCode("010102", "用户未授权访问");
    public static final ResponseCode RESOURCE_VALIDATE_FAIL = new ResponseCode("010103", "用户未授权访问系统资源");
    public static final ResponseCode USER_NO_LOGIN = new ResponseCode("010104", "用户未登录");
    public static final ResponseCode USER_SYSTEM_ERROR = new ResponseCode("010105", "用户未授权");
    /**
     * 其他相关错误码
     */
    public static final ResponseCode MEMBER_PAYMEENT_ADD_FAIL = new ResponseCode("020101", "用户名和公司名不匹配");
    public static final ResponseCode BALANCE_FAIL = new ResponseCode("020102", "余额不足");
}
