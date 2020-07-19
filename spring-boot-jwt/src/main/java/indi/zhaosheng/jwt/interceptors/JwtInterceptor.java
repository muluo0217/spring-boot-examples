package indi.zhaosheng.jwt.interceptors;

import indi.zhaosheng.jwt.util.JwtUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author muluo
 * @description
 * @date 2020/7/19 22:55
 */
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            throw new RuntimeException("请传入token");
        }
        JwtUtil.verifyToken(token);
        return true;
    }
}
