package com.audi.ssm.util;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//CsrfInterceptor 对于post请求进行拦截，检测csrfToken是否匹配
public class CsrfInterceptor extends HandlerInterceptorAdapter {
	 
    private static final Logger logger = LoggerFactory
            .getLogger(CsrfInterceptor.class);
 
//    @Autowired
//    WebUser webUser;
 
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
 
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String CsrfToken = CsrfTokenManager.getTokenFromRequest(request);
            if (CsrfToken == null
                    || !CsrfToken.equals(request.getSession().getAttribute(
                            CsrfTokenManager.CSRF_TOKEN_FOR_SESSION_ATTR_NAME))) {
                String reLoginUrl = "/login?backurl="
                        + URLEncoder.encode(getCurrentUrl(request), "utf-8");
 
                response.sendRedirect(reLoginUrl);
                return false;
            }
        }
 
        return true;
    }
 
    private String getCurrentUrl(HttpServletRequest request) {
        String currentUrl = request.getRequestURL().toString();
        if (!StringUtils.isEmpty(request.getQueryString())) {
            currentUrl += "?" + request.getQueryString();
        }
 
        return currentUrl;
    }
}
