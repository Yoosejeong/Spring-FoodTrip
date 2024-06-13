<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../menubar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/boardlist.css">
<title>게시판</title>

</head>
<body>
	<h2>📋게시판</h2>
	<hr class="hr1">
	<%@ include file="../menubar.jsp"%>
	<form>
		<span>📌 총 ${boardList.size()}개의 게시물이 있습니다. <br><br></span> <span class="right">
			<br>
		</span>
	</form>
<div>
        <button class = "custom-button" onclick="location.href='${pageContext.request.contextPath}/board/list'">전체</button>
        <button class = "custom-button" onclick="location.href='${pageContext.request.contextPath}/board/list/한식'">한식</button>
        <button class = "custom-button" onclick="location.href='${pageContext.request.contextPath}/board/list/중식'">중식</button>
        <button class = "custom-button" onclick="location.href='${pageContext.request.contextPath}/board/list/양식'">양식</button>
        <button class = "custom-button" onclick="location.href='${pageContext.request.contextPath}/board/list/일식'">일식</button>
   		<button class = "custom-button"  onclick="location.href='${pageContext.request.contextPath}/board/list/기타'">기타</button>
    </div>
	<br>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>카테고리</th>
			<th>글쓴이</th>
			<th>일시</th>
			<th>조회수</th>
		</tr>
		<!-- 게시물 목록을 반복문을 사용하여 표시 -->
		<c:forEach var="board" items="${boardList}" varStatus="status">
			<tr>
				<td class="center"><c:out value="${status.index + 1}" /></td>
				<td class="left"><a
					href="${pageContext.request.contextPath}/board/${board.boardId}"><c:out
							value="${board.title}" /></a></td>
				<td class="center"><c:out value="${board.category}" /></td>
				<td class="center"><c:out value="${board.nickname}" /></td>
				<td class="center"><c:out value="${board.updatedAt}" /></td>
				<td class="center"><c:out value="${board.views}" /></td>
			</tr>
		</c:forEach>
	</table>


	<span class="right"> 
		<input type="button" value="글쓰기" class="gradient"
		onclick="location.href='${pageContext.request.contextPath}/board/write'">
	</span>

</body>
</html>