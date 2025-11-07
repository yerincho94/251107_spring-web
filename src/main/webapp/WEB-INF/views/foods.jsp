<%@ page import="kr.java.springweb.model.entity.Food" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Food</title>
</head>
<body>
    <h1>음식 목록</h1>
    <%
        for (Food food : (List<Food>) request.getAttribute("foods")) {
    %>
    <p><%= food %></p>
    <%
        }
    %>
    <h1>음식 등록</h1>
    <form method="post">
        <input name="name" placeholder="음식 이름 입력"><br>
        <input type="number" name="price" placeholder="음식 가격 입력"><br>
        <button>등록</button>
    </form>
</body>
</html>
