package com.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/user/*")
public class AuthFilter implements Filter {
    private ServletContext context;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
        this.context.log("AuthFilter initialized");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login.jsp");
        }
        else
            filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {}
}