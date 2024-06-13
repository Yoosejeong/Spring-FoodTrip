<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../menubar.jsp"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/board.css">
<title>게시글 조회</title>
</head>
<body>
	<%@ include file="../menubar.jsp"%>
	<div class="container">
		<div class="board-header">
			<h2>게시글 조회</h2>
		</div>
		<div class="board-content">
			<h3>${board.title}</h3>
			<p>
				<span class="label">👤작성자 </span> <span class="info">${board.nickname}</span>
			</p>

			<p>
				<span class="label">📃내용 </span> <span class="info">${board.content}</span>
			</p>
			<p>
				<span class="label">🖇️카테고리 </span> <span class="info">
					${board.category}</span>
			</p>
			<p>
				<span class="label">⭐별점 </sapn> <span class="info">
						${board.rating} </span>
			</p>

			<p>
				<span class="label">📆날짜 </span> <span class="info">${board.updatedAt}</span>
			</p>
		</div>

		<div class="center">
			<c:choose>
				<c:when test="${board.nickname == sessionScope.nickname}">
					<div class="btn-group">
						<form
							action="${pageContext.request.contextPath}/board/delete/${board.boardId}"
							method="GET">
							<input type="submit" value="삭제" class="btn">
						</form>
					</div>
					<div class="btn-group">
						<form
							action="${pageContext.request.contextPath}/board/modify/${board.boardId}"
							method="GET">
							<input type="submit" value="수정" class="btn">
						</form>
					</div>
				</c:when>
				<c:otherwise>
					<!-- 다른 사용자인 경우 수정/삭제 버튼을 표시하지 않음 -->
				</c:otherwise>
			</c:choose>
			<div class="btn-group">
				<input type="button" value="목록" class="btn"
					onclick="location.href='${pageContext.request.contextPath}/board/list'">
			</div>
		</div>
	</div>
	
</body>
</html>