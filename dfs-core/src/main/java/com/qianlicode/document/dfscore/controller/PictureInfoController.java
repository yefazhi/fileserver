package com.qianlicode.document.dfscore.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yefazhi
 * @Create: 2020/4/16
 * @Version: 1.0
 */
@Controller
public class PictureInfoController {

    @RequestMapping("/getPictures")
    @ResponseBody
    public JSONObject getPictureList(String userUuid){

        return new JSONObject();
    }

}
