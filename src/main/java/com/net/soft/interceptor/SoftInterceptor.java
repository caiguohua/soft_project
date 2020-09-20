package com.net.soft.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class SoftInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(SoftInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        Object flag = session.getAttribute("flag");
        if(flag != null){
            logger.info("登录成功！");
            return true;
        }else {
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
