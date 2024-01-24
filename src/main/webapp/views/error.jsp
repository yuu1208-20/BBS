<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>なんでも掲示板</title>
</head>
<body>
	<h1>なんでも掲示板</h1>
	<p>お手数ですが再度お試しください。</p>
	<form action="<%=request.getContextPath() %>/views/home.jsp">
		<input type="submit" value="ホームに戻る">
	</form>
</body>
</html>