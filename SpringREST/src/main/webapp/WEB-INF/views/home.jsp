<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/resources/js/home.js" var="homeJS" />
<c:url value="/resources/js/homeQuiz.js" var="homeQuizJS" />
<c:url value="/resources/js/homeQuiz2.js" var="homeQuiz2JS" />
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<h1>Home!</h1>

		<h3>
			Quiz. 추첨 버튼을 누르면 랜덤으로 10명의 사원을 골라와서 화면에 출력해주는 기능을 만들어보세요(JSON버전과
			XML버전 한번씩)
		</h3>

		<button id="refBtnJSON">추첨(JSON)</button>
		<button id="refBtnXML">추첨(XML)</button>

		<div id="refResultDiv1" style="display: grid; grid-template-columns: 1fr 1fr 1fr"></div>
		<hr />
		<div id="refResultDiv2" style="display: grid; grid-template-columns: 1fr 1fr 1fr"></div>
		<hr />

		<hr />
		<h3>Quiz2. REST방식으로 과일 테이블에 INSERT, UPDATE, DELETE를 구현해 보세요</h3>
		<hr />

		<h4>INSERT</h4>
		과일 이름 : <input id="fruit_name_in" type="text" /> <br />
		과일 가격 : <input id="fruit_price_in" type="number" /> <br />
		과일 등급 :
		<c:set value="A+/A/B/C/D" var="grades" />
		<select id="fruit_grade_in">
			<c:forTokens items="${grades}" delims="/" var="grade">
				<c:choose>
					<c:when test="${grade == fruit.fruit_grade}">
						<option value="${grade}" selected>${grade}</option>
					</c:when>
					<c:otherwise>
						<option value="${grade}">${grade}</option>
					</c:otherwise>
				</c:choose>
			</c:forTokens>
		</select>
		<br />
		국가 코드 :
		<select id="country_id_in">
			<c:forEach items="${countries}" var="country">
				<c:choose>
					<c:when test="${country.country_id == fruit.country_id}">
						<option value="${country.country_id}" selected>${country.country_name}</option>
					</c:when>
					<c:otherwise>
						<option value="${country.country_id}">${country.country_name}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		<br />
		<button id="fruitInsertBtn">INSERT</button>
		<hr />

		<h4>UPDATE</h4>
		번호 :
		<select id="fruit_id_up">
			<c:forEach items="${fruits}" var="fruit">
				<option value="${fruit.fruit_id}">${fruit.fruit_id}</option>
			</c:forEach>
		</select>
		<br />
		과일 이름 : <input id="fruit_name_up" type="text" /> <br />
		과일 가격 : <input id="fruit_price_up" type="number" /> <br />
		과일 등급 :
		<c:set value="A+/A/B/C/D" var="grades" />
		<select id="fruit_grade_up">
			<c:forTokens items="${grades}" delims="/" var="grade">
				<c:choose>
					<c:when test="${grade == fruit.fruit_grade}">
						<option value="${grade}" selected>${grade}</option>
					</c:when>
					<c:otherwise>
						<option value="${grade}">${grade}</option>
					</c:otherwise>
				</c:choose>
			</c:forTokens>
		</select>
		<br />
		국가 코드 :
		<select id="country_id_up">
			<c:forEach items="${countries}" var="country">
				<c:choose>
					<c:when test="${country.country_id == fruit.country_id}">
						<option value="${country.country_id}" selected>${country.country_name}</option>
					</c:when>
					<c:otherwise>
						<option value="${country.country_id}">${country.country_name}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		<br />
		<button id="fruitUpdateBtn">UPDATE</button>

		<hr />

		<h4>DELETE</h4>

		<button id="fruitDeleteBtn">DELETE</button>
		<hr />

		<hr />

		<button id="btn1">버튼1</button>
		<button id="btn2">버튼2(JSON)</button>
		<button id="btn3">버튼3(XML)</button>
		<hr />
		<button id="btn4">버튼4(PUT방식 xhttp 요청)</button>

		<div id="out"></div>
		<div id="employees" style="display: grid; grid-template-columns: 1fr 1fr 1fr"></div>

		<script type="text/javascript" src="${homeJS}"></script>
		<script type="text/javascript" src="${homeQuizJS}"></script>
		<script type="text/javascript" src="${homeQuiz2JS}"></script>
	</body>
</html>
