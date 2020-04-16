package com.qianlicode.document.dfscore.service.impl;

import com.qianlicode.document.dfscore.dto.FileRequest;
import com.qianlicode.document.dfscore.dto.FileResponse;
import com.qianlicode.document.dfscore.service.FileUploadService;
import org.apache.commons.lang3.StringUtils;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;


/**
 * @Author: yefazhi
 * @Create: 2020/4/16
 * @Version: 1.0
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {
    private Logger logger = LoggerFactory.getLogger(FileUploadServiceImpl.class);

    /**
     *fast—dfs含主机名和端口号
     */
    @Value("${fileServer.url}")
    private String fileServerUrl;

    @Override
    public FileResponse fileUpload(FileRequest request) {
        String fastDFSServerUrl = fileServerUrl;
        FileResponse fileResponse = new FileResponse();

        //服务url获取校验
        if (StringUtils.isBlank(fastDFSServerUrl)) {
            logger.error("文件系统IP获取为空！");
            return fileResponse;
        }

        try {
            String trackerConfig = this.getClass().getResource("/tracker.conf").getFile();
            ClientGlobal.init(trackerConfig);
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getTrackerServer();
            StorageClient storageClient = new StorageClient(trackerServer);

            //获取后缀名
            String fileSuffix = request.getFileSuffix();
            String[] uploadFileArray = storageClient.upload_file(request.getBytes(), fileSuffix, null);

            for (int i = 0; i < uploadFileArray.length; i++) {
                String uploadFilePath = uploadFileArray[i];
                fastDFSServerUrl += "/" + uploadFilePath;
            }
            fileResponse.setSuccess(true);
            fileResponse.setAppCode(request.getAppCode());
            fileResponse.setFileName(fastDFSServerUrl);

            //TODO 将数据插入到数据库中

        } catch (IOException e) {
            logger.error("文件上传：获取TrackerServer对象失败:{}", e);
        }catch (MyException e) {
            logger.error("文件上传：客户端全局变量初始化失败:{}", e);
        }

        return fileResponse;
    }
}
