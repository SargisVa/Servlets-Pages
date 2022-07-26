package com.onlineshop.filters;

import com.onlineshop.models.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ThemeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        if (session.getAttribute("user") == null) {
            chain.doFilter(request, response);
            return;
        }
        User.Theme theme = ((User)session.getAttribute("user")).getTheme();

        switch (theme) {
            case Dark:
                session.setAttribute("theme", User.Theme.Dark.toString());
                break;
            case Light:
                session.setAttribute("theme", User.Theme.Light.toString());
                break;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
