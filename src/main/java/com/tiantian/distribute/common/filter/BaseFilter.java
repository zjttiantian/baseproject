package com.tiantian.distribute.common.filter;

import com.tiantian.distribute.common.App;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class BaseFilter implements Filter {
    private App app;
    public BaseFilter(App app){
        this.app=app;
    }

    public void destroy() {
        System.out.println("Stopping filter");
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter called with: " + request);

        chain.doFilter(request, response);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        ApplicationContext ac= WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
        app.setApplicationContext(ac);
        Enumeration<String> enums = filterConfig.getInitParameterNames();

        while (enums.hasMoreElements()) {
            String param = (String) enums.nextElement();
            System.out.println(param + ":" + filterConfig.getInitParameter(param));
        }
    }
}