package com.onlineshop.servlets;

import com.onlineshop.models.Post;
import com.onlineshop.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditPostServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputTitle = req.getParameter("title");
        String inputImageUrl = req.getParameter("imageUrl");

        String[] splits = req.getParameter("postForAction").split("%##%");

        String title = splits[0];
        String imageUrl = splits[1];
        Post post = ((User) req.getSession().getAttribute("user")).getPostByTitleAndImageUrl(title, imageUrl);

        if (post == null) return;
        if (inputTitle != null && !inputTitle.isBlank()) {
            post.setTitle(inputTitle);
        }
        if (inputImageUrl != null && !inputImageUrl.isBlank()) {
            post.setImageUrl(inputImageUrl);
        }

        resp.sendRedirect("/user");
    }
}
