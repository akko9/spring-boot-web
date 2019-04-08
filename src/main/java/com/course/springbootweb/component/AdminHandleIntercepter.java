package com.course.springbootweb.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminHandleIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object isAdmin= request.getSession().getAttribute("isAdmin");

        Integer.parseInt(isAdmin.toString());
        if (isAdmin.equals(1)){
            request.setAttribute("msg","未有权限浏览!");
            request.getRequestDispatcher("/main.html").forward(request,response);
            return  false;
        }else {
            return true;
        }

    }
}
