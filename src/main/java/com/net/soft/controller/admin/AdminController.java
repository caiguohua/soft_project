package com.net.soft.controller.admin;

import com.net.soft.from.ClubInfoForm;
import com.net.soft.from.UserInfoForm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author caiguohua
 * @date 2020/3/8 1:30
 * @Email:cai.beyond@qq.com
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @PostMapping("/login")
    public ModelAndView login(@Valid UserInfoForm form,
                              BindingResult bindingResult,
                              Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/soft/admin/index");
            return new ModelAndView("admin/common/error", map);
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(form.getName(), form.getPassword());
        try {
            subject.login(token);
            Session session = subject.getSession();
            session.setAttribute("subject", subject);
            map.put("url", "/soft/clubInfo/list");
            return new ModelAndView("admin/common/success", map);
        } catch (AuthenticationException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/soft/admin/login");
            return new ModelAndView("admin/common/error", map);
        }
    }

    @GetMapping("/login")
    public ModelAndView login(Map<String, Object> map) {
        return new ModelAndView("admin/common/login", map);
    }

    @GetMapping("/index")
    public ModelAndView index(Map<String, Object> map) {
        return new ModelAndView("admin/common/index", map);
    }
}
