package com.qianlicode.document.dfscore.service;

import com.alibaba.fastjson.JSONObject;
import com.qianlicode.document.dfscore.dto.FileRequest;
import com.qianlicode.document.dfscore.dto.FileResponse;

/**
 * @Author: yefazhi
 * @Create: 2020/4/16
 * @Version: 1.0
 */
public interface FileUploadService {

    FileResponse fileUpload(FileRequest request);
}
