package com.net.soft.controller.club;

import com.net.soft.service.impl.UserLoginServiceImpl;
import com.net.soft.utils.UserCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author yangdajiang
 * @date 2020/3/11 10:32
 * @Email:786742736@qq.com
 */

@Controller
@RequestMapping(value = "")
public class UserLoginController {

    private final UserLoginServiceImpl userLoginService;

    @Autowired
    public UserLoginController(UserLoginServiceImpl userLoginService) {
        this.userLoginService = userLoginService;
    }

    @PostMapping(value = "/login")
    public ModelAndView Login(@RequestParam(name = "userName") String userName,
                              @RequestParam(name = "password") String password,
                              HttpServletRequest request, HttpServletResponse response){
        String msg = userLoginService.userLogin(userName,password);
        ModelAndView modelAndView = new ModelAndView();
        if(msg.equals("登陆成功")){
            HttpSession session = request.getSession();
            session.setAttribute("flag",true);
            session.setAttribute("type", UserCheck.userType(userName));
            modelAndView.setViewName("admin/common/index");
            return modelAndView;
        }else {
            modelAndView.setViewName("user/login");
            modelAndView.addObject("msg",msg);
            return modelAndView;
        }
    }

    @PostMapping(value = "/register")
    public ModelAndView register(@RequestParam(name = "phone") String phone,
                                 @RequestParam(name = "userName" )String userName,
                                 @RequestParam(name = "password")String password){
        String msg = userLoginService.userRegister(phone,userName,password);
        ModelAndView modelAndView = new ModelAndView();
        if(msg.equals("注册成功")){
            modelAndView.setViewName("/user/login");
            modelAndView.addObject("msg",msg);
            return modelAndView;
        }else {
            modelAndView.setViewName("user/register");
            modelAndView.addObject("msg",msg);
            return modelAndView;
        }
    }

}
