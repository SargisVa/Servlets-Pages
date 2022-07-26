package com.onlineshop.servlets;

import com.onlineshop.db.Db;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("posts", Db.posts);
        req.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
    }
}
