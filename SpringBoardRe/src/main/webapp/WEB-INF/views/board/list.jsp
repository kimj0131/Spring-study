<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<c:url value="/assets/board/css/list.css" var="listCSS" />
		<meta charset="UTF-8" />
		<title>게시판 목록</title>
		<link rel="stylesheet" href="${listCSS}" />
	</head>
	<body>
		<h1>목록</h1>

		<c:if test="${!empty boards}">
			<div class="board-list">
				<div>[no]</div>
				<div>[title]</div>
				<div>[writer]</div>
				<div>[view]</div>
				<div>[write date]</div>
				<c:forEach items="${boards}" var="board">
					<c:set value="${board.board_id}" var="bid" />
					<div class="board-id">${bid}</div>
					<div class="board-title">
						<a href="./detail?board_id=${bid}">${board.board_title}</a>
						<a href="">[${empty board.reply_count ? 0 : board.reply_count}]</a>
					</div>
					<div class="board-writer">${board.board_writer}</div>
					<div class="view-count">${board.view_count}</div>
					<div class="write-date">${board.write_date}</div>
				</c:forEach>
			</div>
		</c:if>

		<a href="./write" style="color: white">글쓰기</a>
	</body>
</html>
