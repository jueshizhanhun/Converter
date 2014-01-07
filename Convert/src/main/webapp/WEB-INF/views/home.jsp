<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="<c:url value='flex/'/>">文件页面</a>
<a href="<c:url value='video/'/>">视频页面</a>
<br>
<a href="<c:url value='flex/page'/>">文件上传页面</a>
<a href="<c:url value='video/page'/>">视频上传页面</a>
</body>
</html>
