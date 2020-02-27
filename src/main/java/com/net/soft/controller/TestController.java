package com.net.soft.controller;

import com.net.soft.exception.SoftException;
import com.net.soft.utils.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @author caiguohua
 * @date 2020/2/27 18:45
 * @Email:cai.beyond@qq.com
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public Object test(@RequestParam("id") Integer id){
        if(id == 0){
            throw new SoftException(0,"error");
        }
        return ResultUtil.successResult("hello world!");
    }
}
