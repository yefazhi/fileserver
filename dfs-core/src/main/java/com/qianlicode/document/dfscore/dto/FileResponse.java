package com.qianlicode.document.dfscore.dto;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author: yefazhi
 * @Create: 2020/4/16
 * @Version: 1.0
 */
public class FileResponse implements Serializable{

    /**
     * 文件上传后的存储路径的
     */
    private String fileReturnUrl;
    /**
     * 上传文件的来源：WEB（前端页面录入）， API（api接口请求录入）
     */
    private String fileName;
    /**
     * 上传来源应用
     */
    private String appCode;
    /**
     * 用户名称：页面上传时使用
     */
    private String userName;

    /**
     * 判断请求是否成功,初始设置为失败
     */
    private boolean success = false;

    private Map<String, Object> resultMap;


    public String getFileReturnUrl() {
        return fileReturnUrl;
    }

    public void setFileReturnUrl(String fileReturnUrl) {
        this.fileReturnUrl = fileReturnUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }
}
