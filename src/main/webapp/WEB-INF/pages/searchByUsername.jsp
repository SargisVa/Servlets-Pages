<%--
  Created by IntelliJ IDEA.
  User: sargis
  Date: 11.07.22
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>OnlineShop</title>
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
        .post {
            width: 600px;
            height: 300px;
            display: flex;
            margin-top: 10px;
        }

        .post img {
            width: 200px;
            height: 200px;
        }

        .post h3 {
            margin: 0 0 0 20px;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
<a href="${pageContext.request.contextPath}/" class="home">Home</a>

<c:choose>
    <c:when test="${error != null}">
        <p class="error">no search result</p>
    </c:when>
    <c:when test="${postsToShow != null}">
        <c:if test="${username != null}">
            <h3>${username} posts</h3>
        </c:if>
        <c:forEach var="post" items="${postsToShow}">
            <div class="post">
                <img alt="image" src="${post.imageUrl}"/>
                <h3>${post.title}</h3>
            </div>
        </c:forEach>
    </c:when>
</c:choose>
</body>
</html>
