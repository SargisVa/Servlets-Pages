package com.onlineshop.servlets;

import com.onlineshop.db.Db;
import com.onlineshop.models.Post;
import com.onlineshop.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/addPost.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Post newPost = new Post(req.getParameter("title"), req.getParameter("imageUrl"));
        user.getPosts().add(newPost);
        Db.posts.add(newPost);
        resp.sendRedirect("/user");
    }
}
