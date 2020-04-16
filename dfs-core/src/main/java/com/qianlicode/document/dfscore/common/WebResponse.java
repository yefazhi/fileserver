package com.qianlicode.document.dfscore.common;

import com.google.common.collect.Maps;
import com.qianlicode.document.dfscore.common.enumutil.ReturnCodeEnum;
import com.qianlicode.document.dfscore.dto.FileResponse;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebResponse<T> implements Serializable {

    private static final long serialVersionUID = -1463052985903224681L;

    private T                 data;

    // 参考之前继承自BaseResponse的各个类，目前只指定一个code属性，如果需要增加其它属性（如errorMsg,success等），可根据需要添加
    private String            code;


    // 前后端分离重构，新定义的属性success、total、msg，属性code复用
    private Boolean           success;
    // 列表总条数
    private Integer           total;

    private String            msg;

    /**
     * 当前页码
     */
    private Integer currentPage;
    /**
     * 每页条数
     */
    private Integer pageSize;


    public void setData(T data) {
        this.data = data;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public String getCode() {
        return code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 不需要data
     * @return
     */
    public static WebResponse success(){
        WebResponse webResponse = new WebResponse();
        webResponse.setCode(ReturnCodeEnum.SUCCESS.getReasonCode());
        webResponse.setMsg(ReturnCodeEnum.SUCCESS.name());
        webResponse.setSuccess(true);

        return webResponse;
    }

    public static WebResponse success(String code, String msg){
        WebResponse webResponse = new WebResponse();
        webResponse.setCode(code);
        webResponse.setMsg(msg);
        webResponse.setSuccess(true);

        return webResponse;
    }

    /**
     * web重构列表统一返回-请求处理成功时，调用该方法，返回响应数据，泛型方法
     *
     * @param t 要返回的业务数据
     */
    public static <T> WebResponse<T> successList(T t, int total) {
        WebResponse<T> result = new WebResponse<>();
        result.setData(t);
        result.setSuccess(true);
        result.setTotal(total);
        result.setCode(ReturnCodeEnum.SUCCESS.getReasonCode());
        result.setMsg(ReturnCodeEnum.SUCCESS.name());

        return result;
    }

    public static <T> WebResponse<T> successNoData(int total) {
        WebResponse<T> result = new WebResponse<>();
        result.setData((T)  new ArrayList());
        result.setSuccess(true);
        result.setTotal(total);
        result.setCode(ReturnCodeEnum.SUCCESS.getReasonCode());
        result.setMsg("没有查询到数据");

        return result;
    }

    /**
     * web重构非列表统一返回-请求处理成功时，调用该方法，返回响应数据，泛型方法
     *
     * @param t 要返回的业务数据
     */
    public static <T> WebResponse<T> successData(T t) {
        WebResponse<T> result = new WebResponse<>();
        result.setData(t);
        result.setCode(ReturnCodeEnum.SUCCESS.name());
        result.setMsg(ReturnCodeEnum.SUCCESS.getRetMsg());
        result.setSuccess(true);

        return result;
    }

    /**
     * web重构非列表统一返回-请求处理成功时，调用该方法，返回响应数据，泛型方法
     *
     * @param t 要返回的业务数据
     */
    public static <T> WebResponse<T> successData(T t,String code, String msg) {
        WebResponse<T> result = new WebResponse<>();
        result.setData(t);
        result.setCode(code);
        result.setMsg(msg);
        result.setSuccess(true);

        return result;
    }

    /**
     * web重构-失败
     * @param code
     * @param msg
     * @return
     */
    public static WebResponse fail(String code, String msg){
        WebResponse webResponse = new WebResponse();
        webResponse.setCode(code);
        webResponse.setMsg(msg);
        webResponse.setSuccess(false);

        return webResponse;
    }

    /**
     * web重构-失败
     * @param  reasonCodeEnum
     * @return
     */
    public static WebResponse fail(ReturnCodeEnum reasonCodeEnum){
        WebResponse webResponse = new WebResponse();
        webResponse.setCode(reasonCodeEnum.getReasonCode());
        webResponse.setMsg(reasonCodeEnum.getReasonCode());
        webResponse.setSuccess(false);

        return webResponse;
    }

    /**
     * 需要返回页码
     * @param t
     * @param total
     * @param currentPage
     * @param pageSize
     * @param <T>
     * @return
     */
    public static<T> WebResponse<T> successPage(T t, int total,int currentPage,int pageSize){
        WebResponse<T> result = new WebResponse<>();
        result.setData(t);
        result.setCurrentPage(currentPage);
        result.setPageSize(pageSize);
        result.setSuccess(true);
        result.setTotal(total);
        result.setCode(ReturnCodeEnum.SUCCESS.name());
        result.setMsg(ReturnCodeEnum.SUCCESS.getRetMsg());

        return result;
    }

    public static WebResponse switchResponse(FileResponse response){
        Map<Object, Object> responseMap = Maps.newHashMap();
        responseMap.put(response.getFileName(), response.getFileReturnUrl());

        WebResponse webResponse = new WebResponse();
        if (response.isSuccess()) {
            webResponse.setCode(ReturnCodeEnum.SUCCESS.getReasonCode());
            webResponse.setMsg(ReturnCodeEnum.SUCCESS.name());
        } else {
            webResponse.setCode(ReturnCodeEnum.ERROR.getReasonCode());
            webResponse.setMsg(ReturnCodeEnum.ERROR.name());
        }
        webResponse.setSuccess(response.isSuccess());
        return webResponse;
    }
}
