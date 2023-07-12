package com.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;

@WebFilter(urlPatterns = "/user/*")

    public class AuthFilter implements Filter {
        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                throws IOException {
            if (((HttpServletRequest) request).getSession() == null ||
                    ((HttpServletRequest) request).getSession().getAttribute("user") == null) {
                ((HttpServletResponse) response).sendRedirect("/login.jsp");
            }
        }
    }