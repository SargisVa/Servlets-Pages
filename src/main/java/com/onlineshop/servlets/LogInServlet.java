package com.onlineshop.servlets;

import com.onlineshop.db.Db;
import com.onlineshop.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/logIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User.UserBuilder()
                .username(req.getParameter("username"))
                .password(req.getParameter("password"))
                .build();
        User tmp = Db.getUserByUsername(user.getUserName());
        if (tmp != null) {
            req.getSession().setAttribute("user", tmp);
            req.getSession().setAttribute("theme", tmp.getTheme());
            resp.sendRedirect("/");
        } else {
            resp.sendRedirect("/logIn?error");
        }
    }
}
