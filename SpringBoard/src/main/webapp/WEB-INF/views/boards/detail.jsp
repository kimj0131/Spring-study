<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>${detail.board_title}</title>
		<c:if test="${param.result == 1}">
			<script>
				alert("작성 완료!");
				location.href = "./detail?board_id=${detail.board_id}";
			</script>
		</c:if>

		<c:if test="${param.result == 0}">
			<script>
				alert("작업에 문제가 있었습니다...");
				location.href = "./detail?board_id=${detail.board_id}";
			</script>
		</c:if>
	</head>
	<body>
		<button onclick="location.href='./list'">돌아가기</button>
		<hr />
		<h3>${detail.board_title}</h3>
		<div>작성자 : ${detail.board_writer}</div>
		<div>제목 : ${detail.board_title} / 조회수 : ${detail.view_count}</div>

		<div>
			<textarea style="resize: none" rows="20" cols="50" disabled>${detail.board_content}</textarea>
		</div>
		<div>
			<input id="inputPassword" name="board_password" type="password" placeholder="비밀번호" />
			<button id="updateBtn">게시글 수정</button>
			<button id="delBtn">게시글 삭제</button>
		</div>
		<form action="./delete" method="post" id="delForm">
			<input type="hidden" name="board_id" value="${detail.board_id}" />
			<input type="hidden" name="check_password" value="${detail.board_password}" />
			<input id="hiddenPassword" type="hidden" name="board_password" />
		</form>

		<hr />

		<c:choose>
			<c:when test="${replies.size() == 0}">
				<div>※ 댓글이 아직 없습니다</div>
			</c:when>
			<c:when test="${replies.size() > 0}">
				<c:forEach items="${replies}" var="reply">
					<div>
						<form action=""></form>
						<input name="reply_id" type="hidden" value="${reply.reply_id}">
						<div id="replyWarp">[${reply.reply_writer}] | ${reply.reply_content} | <span>${reply.reply_date}</span> <button id="replyUpdBtn">수정</button><button id="replyDelBtn">삭제</button></div>
						<div id="replyUpdateWarp" hidden>[${reply.reply_writer}] | <input type="text" value="${reply.reply_content}"></div>
					</div>
				</c:forEach>
			</c:when>
		</c:choose>

		<hr />

		<div id="replyWriteDiv">
			<textarea id="replyContent" name="reply_content" id="" cols="80" rows="5" form="replyForm"></textarea>
			<br />
			댓글쓴이<input id="replyWriter" type="text" name="reply_writer" form="replyForm" /> <br />
			비밀번호<input id="replyPassword" type="password" name="reply_password" form="replyForm" />
			<button id="replyWriteBtn" form="replyForm">댓글 쓰기</button>
		</div>

		<form id="replyForm" action="./reply/write" method="post">
			<input type="hidden" name="board_id" value="${detail.board_id}" />
		</form>

		<script>
			const boardPassword = "${detail.board_password}";
			const board_id = ${detail.board_id};
		</script>

		<c:url value="/resources/boards/js/sha256.js" var="sha256JS" />
		<c:url value="/resources/boards/js/detail.js" var="detailJS" />
		<script src="${sha256JS}"></script>
		<script src="${detailJS}"></script>
	</body>
</html>
