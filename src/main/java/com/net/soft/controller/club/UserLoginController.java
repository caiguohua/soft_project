package com.net.soft.controller.club;

import com.net.soft.model.UserInfoDO;
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
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangdajiang
 * @date 2020/3/11 10:32
 * @Email:786742736@qq.com
 */

@Controller
@RequestMapping(value = "")
public class  UserLoginController {

    private final UserLoginServiceImpl userLoginService;

    @Autowired
    public UserLoginController(UserLoginServiceImpl userLoginService) {
        this.userLoginService = userLoginService;
    }

    @PostMapping(value = "/login")
    public ModelAndView Login(@RequestParam(name = "userName") String userName,
                              @RequestParam(name = "password") String password,
                              HttpServletRequest request,
                              HttpServletResponse response,
                              Map<String,Object> map){
        if(userName.equals("") || password.equals("")){
            map.put("msg","请输入正确的用户名和密码");
            return new ModelAndView("user/login");
        }
        HashMap<String, UserInfoDO> userMap = userLoginService.userLogin(userName,password);
        if(userMap.get("success") != null){
            HttpSession session = request.getSession();
            session.setAttribute("flag",true);
            session.setAttribute("type", UserCheck.userType(userName));
            UserInfoDO userInfoDO = userMap.get("success");
            map.put("uid",userInfoDO.getId());
            if(userInfoDO.getType().equals(2)){
                return new ModelAndView("admin/common/index",map);
            }
            String url = "redirect:http://localhost:8080/soft/user/list?uid="+userInfoDO.getId();
            return new ModelAndView(url);

        }else {
            map.put("msg","用户名不存在或密码错误");
            return new ModelAndView("user/login",map);
        }
    }

    @PostMapping(value = "/register")
    public ModelAndView register(@RequestParam(name = "phone") String phone,
                                 @RequestParam(name = "userName" )String userName,
                                 @RequestParam(name = "password")String password,
                                 Map<String,Object> map){
        if(phone.equals("") || userName.equals("") || password.equals("")){
            return new ModelAndView("user/register");
        }
        String msg = userLoginService.userRegister(phone,userName,password);
        if(msg.equals("注册成功")){
            map.put("msg",msg);
            return new ModelAndView("user/login",map);
        }else {
            map.put("msg",msg);
            return new ModelAndView("user/register",map);
        }
    }

}
