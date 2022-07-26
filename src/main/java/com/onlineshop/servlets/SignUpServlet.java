package com.onlineshop.servlets;

import com.onlineshop.db.Db;
import com.onlineshop.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/pages/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user =
                new User.UserBuilder(req.getParameter("firstName"), req.getParameter("lastName"))
                        .username(req.getParameter("userName"))
                        .email(req.getParameter("email"))
                        .password(req.getParameter("password"))
                        .build();
        if (Db.userNameExists(user)) {
            resp.sendRedirect("/signUp?error");
        } else {
            Db.users.add(user);
            resp.sendRedirect("/logIn");
        }

    }
}
