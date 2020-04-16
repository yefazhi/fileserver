package com.qianlicode.document.dfscore.common.enumutil;


public enum ReturnCodeEnum {
	// 公共返回码定义
	SUCCESS("200", "成功"),
	ERROR("500", "服务器内部错误"),
    PARAM_ERROR("100", "参数错误"),
    DUPLICATE_REQUEST("107", "重复请求"),
    NOT_FILE("410","文件不存在"),
    OTHER("504", "其他异常"),
    NO_PARTNERCODE("505", "请选择合作方"),
    NO_TASK("210","无任务"),

    // 安全相关的返回码定义
    UNAUTHORIZED("401", "未授权"),
    AUTHENTICATION_ERROR("420", "鉴权错误"),
    PASSWD_ERROR("421", "密码不正确"),
    EPOCH_INVALID("422", "epoch已失效"),
    LINE_ALL_USED("406", "当前线路已占满，请稍后再试"),

    // 双呼
    FLOW_CHECK_FAIL("600", "流量校验失败"),
    CALLING("601", "呼叫中"),
    NO_AVAILAVE_CALL_RESOURCE("602", "无可用的外呼资源"),
    CALL_CHANNEL_ERROR("603", "外呼通道异常"),
    NO_CASE("604", "无匹配的案件"),
    CASE_RETURN("605", "案件已结案"),
    HIT_BLACKLIST("513","命中运营商黑名单"),
    PHONE_NUMBER_STATUS_UNUSUAL("514","号码状态异常"),

    // 用户
    USER_NOT_FOUND("620","该用户未找到"),
    USER_ALREADY_EXIST("621", "该用户已经存在"),
    USER_FORBIDDEN("622","账号被禁用或删除"),
    SESSION_EXPIRED("623","session失效")

	;
	private String reasonCode;
	private String retMsg;

	ReturnCodeEnum(String reasonCode, String retMsg) {
	    this.reasonCode = reasonCode;
		this.retMsg = retMsg;
	}

    public String getRetCode() {
        return this.name();
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

}
