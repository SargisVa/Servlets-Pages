<%--
  Created by IntelliJ IDEA.
  User: sargis
  Date: 12.07.22
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.onlineshop.models.User" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="header.jsp" />
    <style>
       a.home {
            color: #2da1c1;
            font-size: medium;
            text-decoration: none;
            float: right;
        }

        a.home:hover {
            color: #f90;
            text-decoration: underline;
        }
    </style>
</head>
<body>
<a href="${pageContext.request.contextPath}/" class="home">Home</a>
<form method="post" action="${pageContext.request.contextPath}/editPost">
    <label>
        Title <input type="text" name="title"/>
    </label>
    <label>
        Image <input type="text" name="imageUrl"/>
    </label>
    <input type="hidden" value="${postTitle}%##%${postImageUrl}" name="postForAction">
    <input type="submit" value="edit post"/>
</form>
</body>
</html>