package com.onlineshop.filters;

import com.onlineshop.models.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        User user = ((User) session.getAttribute("user"));
        if (user != null) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect("/logIn");
        }
    }

    @Override
    public void destroy() {}
}
