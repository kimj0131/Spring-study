<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>새 게시물 작성</title>
		<c:if test="${result == 0}">
			<script>
				alert("오류가 발생했습니다...");
			</script>
		</c:if>
	</head>
	<body>
		<button onclick="location.href='./list'">돌아가기</button>
		<hr />
		<h3>글쓰기</h3>

		<form action="./write" method="post" id="writeForm">
			글 제목 : <input type="text" name="board_title" /> <br />
			글쓴이 : <input type="text" name="board_writer" /> 글 비밀번호 :
			<input type="password" name="board_password" /> <br />
			<textarea name="board_content" cols="50" rows="20"></textarea>
		</form>
		<button type="submit" form="writeForm">글쓰기</button>
		<button onclick="location.href = './list'">글 목록</button>
	</body>
</html>
