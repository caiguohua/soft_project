package com.net.soft.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author yangdajiang
 * @date 2020/3/11 14:40
 * @Email:786742736@qq.com
 */
public class InterceptorConfig implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.print("拦截器");
        HttpSession session = request.getSession();
        Object flag = session.getAttribute("flag");
        if(flag != null){
            System.out.print("已登录");
            return true;
        }else {
            System.out.print("未登录");
            response.sendRedirect("/soft/club/login");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
