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
				<select name="fruit_grade">
					<option value="A+">A+</option>
					<option value="A">A</option>
					<option value="B">B</option>
					<option value="C">C</option>
					<option value="D">D</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>국가코드</th>
			<td>
				<select name="country_id" >
				<c:forEach items="${countries}" var="country">
					<option value="${country.country_id}">${country.country_name}</option>
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