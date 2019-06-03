package com.freedom.interceptor;

import com.freedom.pojo.UserInfo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String uri = httpServletRequest.getRequestURI();
        //1.如果是登录或者注册页面的请求则不拦截返回true
        if (uri.equals("/login.html")||uri.equals("/reg.html")||uri.equals("/thelogin")||uri.equals("/registCon")){
            return true;
        }
        //2.如果其它的请求有了"令牌"也不拦截
        UserInfo userinfo = (UserInfo) httpServletRequest.getSession().getAttribute("userinfo");
        if (userinfo!=null){
            return true;
        }
        //3.其它情况一律拦截
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
