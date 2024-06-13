<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ include file="menubar.jsp"%>
<html>
<head>
<title>Home</title>
<style>
.popular-container, .recent-container {
	display: flex;
	flex-wrap: wrap;
	gap: 10px;
	margin-top: 20px;
	max-width: 800px; /* 최대 너비 설정 */
	margin: 0 auto; /* 중앙 정렬 */
	justify-content: space-between; /* 아이템들을 여백을 두고 나열 */
}

.item-container {
	flex: 1 1 calc(40% - 10px); /* 아이템 컨테이너 크기 조절 */
	background-color: #f0f0f0;
	padding: 10px;
	border: 1px solid #ddd;
	border-radius: 4px;
	text-align: center;
}

.item-container h3 {
	font-size: 1.2em;
	margin-bottom: 10px;
}

.hr1 {
	width: 100%;
	height: 1px;
	background-color: #ddd;
	border: none;
	margin: 20px 0;
}

.container-border {
	border: 2px solid #ddd;
	border-radius: 8px;
	padding: 12px;
	width: 800px;
	margin: 0 auto;
}
</style>
</head>
<body>
	<div style="text-align: center;">
		<h1>🤗${nickname}님, FoodTrip에 오신 걸 환영합니다!🤗</h1>
		<p>여러 사용자들과 함께 다양한 맛집을 공유해보세요!</p>

		<h2>🔥 인기 게시글</h2>
		<div class="container-border">
			<div class="popular-container">
				<c:forEach var="board" items="${popularBoards}" varStatus="status">
					<c:if test="${status.index < 4}">
						<div class="item-container">
							<h3>
								<a
									href="${pageContext.request.contextPath}/board/${board.boardId}">${board.title}</a>
							</h3>
							<p>조회수: ${board.views}</p>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>

		<h2>📅 최신 게시글</h2>
		<div class="container-border">
			<div class="recent-container">
				<c:forEach var="board" items="${recentBoards}" varStatus="status">
					<c:if test="${status.index < 4}">
						<div class="item-container">
							<h3>
								<a
									href="${pageContext.request.contextPath}/board/${board.boardId}">${board.title}</a>
							</h3>
							<p>조회수: ${board.views}</p>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>