package com.swjd.Interceptor;


import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LgionInterceptor implements HandlerInterceptor {
    //用于登录拦截的方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestUri=request.getRequestURI();//获取请求地址
        //1.如果是登录界面我们放行
        if(requestUri.indexOf("login")>=0||requestUri.indexOf("Login")>=0){
            return true;
        }
        //2.如果用户登录地址
        HttpSession session=request.getSession();
        if(session.getAttribute("activeName")!=null){
            return true;
        }
        //不放行，并且需要回到登录页面
        request.getRequestDispatcher("/toLogin").forward(request,response);

        return false;
    }
}
