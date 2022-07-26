<%--
  Created by IntelliJ IDEA.
  User: sargis
  Date: 08.07.22
  Time: 11:22
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
        .error {
            color: red;
        }
    </style>
</head>
<body>
<a href="${pageContext.request.contextPath}/" class="home">Home</a>
<c:if test="${param['error'] != null}">
    <p class="error">Invalid username or password</p>
</c:if>
<form method="post">
    <label>
        FirstName <input type="text" name="firstName"/><br>
    </label>
    <label>
        LastName <input type="text" name="lastName"/><br>
    </label>
    <label>
        Username <input type="text" name="userName"/><br>
    </label>
    <label>
        Email <input type="text" name="email"/><br>
    </label>
    <label>
        Password <input type="password" name="password"/><br>
    </label>
    <input type="submit" value="SignUp"/>
</form>
</body>
</html>
