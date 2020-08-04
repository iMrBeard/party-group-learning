package com.learning.demo.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        fixCrossDomain(request,response);
        HttpSession httpSession = request.getSession();
        String Uri = request.getRequestURI();
        //页面放行
        if (Uri.contains("/admin")) {
            if (Uri.contains("/login") || (httpSession.getAttribute("userLoginInfo")!=null)) {
                return true;
            } else {
                response.sendRedirect("../login");
                return false;
            }
        }
        return true;
    }
    public void fixCrossDomain(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "*");
    }
}
