package com.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.http.HttpRequest;

@WebFilter(urlPatterns = "/user/*")

    public class AuthFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
        // Get init parameter
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");
        // Print the init parameter
        System.out.println("Username : " + username);
        System.out.println("Password : " + password);
    }
@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
    if (((HttpServletRequest) request).getSession().getAttribute("user") == null) {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
    }
