package com.qianlicode.document.dfscore.dto;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.Serializable;

/**
 * @Author: yefazhi
 * @Create: 2020/4/16
 * @Version: 1.0
 */
public class FileRequest extends CommonsMultipartFile implements Serializable{

    /**
     * 上传文件路径的url
     */
    private String uploadFileUrl;
    /**
     * 上传文件的来源：WEB（前端页面录入）， API（api接口请求录入）
     */
    private String resource;
    /**
     * 上传来源应用
     */
    private String appCode;

    /**
     * 用户名称：页面上传时使用
     */
    private String userName;

    /**
     * 文件后缀
     */
    private String fileSuffix;

    /**
     * 文件名称
     */
    private String fileName;

    public FileRequest(FileItem fileItem) {
        super(fileItem);
    }

    public String getUploadFileUrl() {
        return uploadFileUrl;
    }

    public void setUploadFileUrl(String uploadFileUrl) {
        this.uploadFileUrl = uploadFileUrl;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
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

    /**
     * 获取文件后缀
     * @return
     */
    public String getFileSuffix() {
        fileSuffix = StringUtils.substringAfter(this.uploadFileUrl, ".");
        return fileSuffix;
    }

    /**
     * 获取文件名称，含后缀
     * @return
     */
    public String getFileName() {
        String[] splitArray = uploadFileUrl.split("/");
        //获取fileName
        this.fileName = splitArray[splitArray.length - 1];
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
