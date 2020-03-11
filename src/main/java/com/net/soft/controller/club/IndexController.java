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
public class IndexController {

    @GetMapping(value = "/index")
    public ModelAndView index(){
        return new ModelAndView("user/index");
    }

    @GetMapping(value = "/Introduction")
    public ModelAndView introduction(){
        return new ModelAndView("user/nullClub");
    }


    @GetMapping(value = "/login")
    public ModelAndView login(){
        return new ModelAndView("user/login");
    }

    @GetMapping(value = "/regedit")
    public ModelAndView register(){
        return new ModelAndView("user/regedit");
    }

    @GetMapping(value = "/info")
    public ModelAndView info(){
        return new ModelAndView("user/info");
    }

}
