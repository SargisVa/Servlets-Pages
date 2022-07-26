package com.onlineshop.servlets;

import com.onlineshop.db.Db;
import com.onlineshop.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SearchByUsernameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("searchByUsername");
        if (username != null && !username.isBlank()) {
            User user;
            if ((user = Db.getUserByUsername(username)) != null) {
                req.setAttribute("username", user.getUserName());
                req.setAttribute("postsToShow", user.getPosts());
            } else {
                req.setAttribute("error", true);
            }
        } else {
            req.getSession().setAttribute("postsToShow", Db.posts);
        }
        req.getRequestDispatcher("/WEB-INF/pages/searchByUsername.jsp").forward(req, resp);
    }
}
