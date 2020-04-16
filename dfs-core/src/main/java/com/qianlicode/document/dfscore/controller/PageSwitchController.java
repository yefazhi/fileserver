package com.qianlicode.document.dfscore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: yefazhi
 * @Create: 2020/4/16
 * @Version: 1.0
 */
@Controller
public class PageSwitchController {

    /**
     * 切换到index页面
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    /**
     * 切换到图片上传页面
     * @retuen
     */
    @RequestMapping("/upload")
    public String upload(){
        return "upload";
    }

}
