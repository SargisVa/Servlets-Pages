<%--
  Created by IntelliJ IDEA.
  User: sargis
  Date: 25.07.22
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<style>
    <c:choose>
    <c:when test="${sessionScope.theme.equals(\"Dark\")}">
    body {
        background-color: darkcyan;
        color: black;
    }

    </c:when>
    <c:otherwise>
    body {
        background-color: white;
        color: black;
    }

    </c:otherwise>
    </c:choose>
</style>

