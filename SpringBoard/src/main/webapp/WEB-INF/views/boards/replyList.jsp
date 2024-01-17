<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board_id}번게시글의 댓글</title>
</head>
<body>
    <button onclick="window.close()">닫기</button>
    <hr>

	<c:choose>
			<c:when test="${replies.size() == 0}">
				<div>※ 댓글이 아직 없습니다</div>
			</c:when>
			<c:when test="${replies.size() > 0}">
				<c:forEach items="${replies}" var="reply">
					<div>
						<form action=""></form>
						<input name="reply_id" type="hidden" value="${reply.reply_id}">
						<div id="replyWarp">[${reply.reply_writer}] | ${reply.reply_content} | <span>${reply.reply_date}</span> </div>
					</div>
				</c:forEach>
			</c:when>
		</c:choose>
</body>
</html>