package com.net.soft.controller.club;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yangdajiang
 * @date 2020/3/10 0:11
 * @Email:786742736@qq.com
 */
@Controller
@RequestMapping(value = "/club")
public class ClubController {

    @GetMapping(value = "/index")
    public ModelAndView index(){
        return new ModelAndView("user/index");
    }

    @GetMapping(value = "/Introduction")
    public ModelAndView introduction(){
        return new ModelAndView("user/Introduction");
    }

    @GetMapping(value = "/xian")
    public ModelAndView xian(){
        return new ModelAndView("user/xian");
    }

    @GetMapping(value = "/info")
    public ModelAndView info(){
        return new ModelAndView("user/info");
    }

    @GetMapping(value = "/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        String msg = "";
        modelAndView.addObject("msg",msg);
        modelAndView.setViewName("user/login");
        return modelAndView;
    }
    @GetMapping(value = "/register")
    public ModelAndView register(){
        return new ModelAndView("user/register");
    }

}
