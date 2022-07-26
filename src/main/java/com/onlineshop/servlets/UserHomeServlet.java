package com.onlineshop.servlets;

import com.onlineshop.db.Db;
import com.onlineshop.models.Post;
import com.onlineshop.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("userPosts",((User)req.getSession().getAttribute("user")).getPosts());
        req.getRequestDispatcher("WEB-INF/pages/userHome.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("LogOut") != null) {
            req.getSession().removeAttribute("user");
            resp.sendRedirect("/");
        } else if (req.getParameter("AddPost") != null) {
            resp.sendRedirect("/addPost");
        } else if (req.getParameter("Light") != null) {
            req.getSession().setAttribute("theme", User.Theme.Light.toString());
            ((User)req.getSession().getAttribute("user")).setTheme(User.Theme.Light);
            resp.sendRedirect("/user");
        } else if (req.getParameter("Dark") != null) {
            req.getSession().setAttribute("theme", User.Theme.Dark.toString());
            ((User)req.getSession().getAttribute("user")).setTheme(User.Theme.Dark);
            resp.sendRedirect("/user");
        } else if (req.getParameter("delete") != null) {
            String[] splits = req.getParameter("postForAction").split("%##%");
            Post post = new Post(splits[0], splits[1]);
            Db.posts.remove(post);
            ((User)req.getSession().getAttribute("user")).getPosts().remove(post);
            resp.sendRedirect("/user");
        } else if (req.getParameter("edit") != null) {
            String[] splits = req.getParameter("postForAction").split("%##%");
            req.setAttribute("postTitle", splits[0]);
            req.setAttribute("postImageUrl", splits[1]);
            req.getRequestDispatcher("/WEB-INF/pages/editPost.jsp").forward(req, resp);
        }
    }
}
