<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
������ ���� id�� <%= session.getAttribute("id") %>
������ app count�� <%= application.getAttribute("count") %>
</body>
</html>