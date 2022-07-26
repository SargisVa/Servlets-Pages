<%--
  Created by IntelliJ IDEA.
  User: sargis
  Date: 08.07.22
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>OnlineShop</title>
    <jsp:include page="header.jsp" />
    <style>
        .log-out {
            color: #2da1c1;
            font-size: medium;
            text-decoration: none;
            float: right;
        }
        .log-out:hover
        {
            color: #f90;
            text-decoration: underline;
        }
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
        .post {
            width: 600px;
            height: 300px;
            display: flex;
            margin-top: 10px;
        }

        .post img {
            margin-top: 20px;
            width: 200px;
            height: 200px;
        }

        .post h3 {
            margin: 0 0 0 20px;
            margin-top: 20px;
        }
        .delete {
            width: 27px;
            height: 27px;
            margin-top: 20px;
            font-size: medium;
            text-decoration: none;
            float: right;
            color: red;
        }
        .delete:hover {
            color: #f90;
            text-decoration: underline;
        }
        .edit {
            width: 45px;
            height: 27px;
            margin-left: 50px;
            margin-right: 10px;
            margin-top: 20px;
            font-size: medium;
            text-decoration: none;
            float: right;
            color: cornflowerblue;
        }
        .edit:hover {
            color: #f90;
            text-decoration: underline;
        }
    </style>
</head>
<body>
<a href="${pageContext.request.contextPath}/" class="home">Home</a>
<form method="post" >
        <input type="submit" class="log-out" value="LogOut" name="LogOut">
        <input type="submit" class="log-out" value="AddPost" name="AddPost">
        <input type="submit" class="log-out" value="Light" name="Light">
        <input type="submit" class="log-out" value="Dark" name="Dark">
        <c:forEach var="post" items="${sessionScope.userPosts}">
            <div class="post">
                <img alt="image" src="${post.imageUrl}"/>
                <h3>${post.title}</h3>
                <input type="hidden" value="${post.title}%##%${post.imageUrl}" name="postForAction">
                <input type="submit" class="edit" value="edit" name="edit">
                <input type="submit" class="delete" value="x" name="delete">
            </div>
        </c:forEach>
    </form>
</body>
</html>
