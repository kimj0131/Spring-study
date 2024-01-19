<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/resources/js/home.js" var="homeJS" />
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<h1>Home!</h1>

		<button id="btn1">버튼1</button>
		<button id="btn2">버튼2(JSON)</button>
		<button id="btn3">버튼2(XML)</button>

		<div id="out"></div>
		<div id="employees" style="display: grid; grid-template-columns: 1fr 1fr 1fr"></div>

		<script type="text/javascript" src="${homeJS}"></script>
	</body>
</html>
