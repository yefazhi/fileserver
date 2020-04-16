package com.qianlicode.document.dfscore.controller;

import com.qianlicode.document.dfscore.common.WebResponse;
import com.qianlicode.document.dfscore.common.enumutil.ReturnCodeEnum;
import com.qianlicode.document.dfscore.dto.FileRequest;
import com.qianlicode.document.dfscore.dto.FileResponse;
import com.qianlicode.document.dfscore.service.FileUploadService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 来自页面的图片上传
 * @Author: yefazhi
 * @Create: 2020/4/16
 * @Version: 1.0
 */
@Controller
public class PictureUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    /**
     * 文件上传方法
     * @param fileRequest
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/fileUpload")
    @ResponseBody
    public WebResponse fileUpload(@RequestParam(value = "fileRequest") FileRequest fileRequest){
        WebResponse response = paramCheck(fileRequest);
        if (!response.getSuccess()) {
            return response;
        }
        FileResponse fileResponse = fileUploadService.fileUpload(fileRequest);
        if (!fileResponse.isSuccess()) {
            return WebResponse.fail(ReturnCodeEnum.ERROR.getReasonCode(), "文件上传失败！");
        }
        return WebResponse.switchResponse(fileResponse);
    }

    /**
     * 用于参数校验
     * @param fileRequest
     * @return
     */
    private WebResponse  paramCheck(FileRequest fileRequest){
        Assert.isNull(fileRequest, "传入的参数有误");
        String fileUrl = fileRequest.getUploadFileUrl();
        String appCode = fileRequest.getAppCode();
        String userName = fileRequest.getUserName();
        if (StringUtils.isAnyBlank(fileUrl, appCode, userName)){
            return WebResponse.fail(ReturnCodeEnum.PARAM_ERROR.getReasonCode(), "必要参数不能为空！");
        }
        fileRequest.setResource("WEB");
        return WebResponse.success();
    }

}
