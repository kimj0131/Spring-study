<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${fruit.fruit_id}번 과일 수정 페이지</title>
</head>
<body>

	<h3>${fruit.fruit_id}번 과일의 정보</h3>
	
	<form action="./update" method="post">
	<table border="3">
		<tr>
			<th>과일번호</th>
			<td>
				${fruit.fruit_id}
				<input name="fruit_id" type="hidden" value="${fruit.fruit_id}">
			</td>
		</tr>
		<tr>
			<th>과일 이름</th>
			<td><input name="fruit_name" type="text" value="${fruit.fruit_name}"></td>
		</tr>
		<tr>
			<th>과일 가격</th>
			<td><input name="fruit_price" type="number" value="${fruit.fruit_price}" step="100"></td>
		</tr>
		<tr>
			<th>과일 등급</th>
			<td>
				<c:set value="A+/A/B/C/D" var="grades"/>
				<select name="fruit_grade" >
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
			</td>
		</tr>
		<tr>
			<th>국가코드</th>
			<td>
				<select name="country_id" >
				<c:forEach items="${countries}" var="country">
				<c:choose>
					<c:when test="${country.country_id == fruit.country_id}">
						<option value="${country.country_id}" selected>${country.country_name}</option>
					</c:when>
					<c:otherwise>
						<option value="${country.country_id}">${country.country_name}</option>
					</c:otherwise>
				</c:choose>
					<!-- <option value="AR">Argentina</option>
					<option value="BE">Belgium</option>
					<option value="BR">Brazil</option>
					<option value="CA">Canada</option>
					<option value="CH">Switzerland</option> -->
				</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정하기">
			</td>
		</tr>
	</table>
	</form>

</body>
</html>