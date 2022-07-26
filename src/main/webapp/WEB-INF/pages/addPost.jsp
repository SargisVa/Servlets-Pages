<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form method="post">
    <label>
        Title <input type="text" name="title"/>
    </label>
    <label>
        Image <input type="text" name="imageUrl"/>
    </label>
    <input type="submit" value="Add post"/>
</form>
</body>
</html>
