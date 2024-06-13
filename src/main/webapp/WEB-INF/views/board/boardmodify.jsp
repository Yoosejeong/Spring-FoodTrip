<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../menubar.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/boardwrite.css">
    <title>게시글 수정</title>
</head>
<body>
    <h2>📝게시글 수정</h2>
	<%@ include file="../menubar.jsp"%>
    <div class="panel-body">
        <form method="post" action="${pageContext.request.contextPath}/board/modify/${board.boardId}">
            <div class="form-group">
                <label>👤작성자</label> 
                <!-- 작성자 정보를 수정하지 않으므로 readonly 속성 추가 -->
                <input class="form-control" name="nickname" value="${board.nickname}" readonly> 
            </div>
            <div class="form-group">
                <label>📌제목</label> 
                <!-- 기존 제목을 입력 폼에 넣어줌 -->
                <input class="form-control" name="title" value="${board.title}" required>
            </div>
            <div class="form-group">
                <label>📃내용</label>
                <!-- 기존 내용을 입력 폼에 넣어줌 -->
                <textarea class="form-control" rows="3" name="content" required>${board.content}</textarea>
            </div>
            <div class="form-group">
                <label>🖇️카테고리</label> 
                <!-- 기존 카테고리를 입력 폼에 넣어줌 -->
                <input class="form-control" name="category" value="${board.category}" required>
            </div>
            <div class="form-group">
                <label>⭐평점</label> 
                <!-- 기존 평점을 입력 폼에 넣어줌 -->
                <input class="form-control" type="number" name="rating" min="1" max="5" step="0.5" value="${board.rating}" required>
            </div>
        
            <input type="submit" class="btn btn-default" value="글 수정하기" style="margin-top: 50px;">
            <input type="button" class="btn btn-default" value="취소" 
                   onClick="location.href='${pageContext.request.contextPath}/board/list'" style="margin-top: 50px;">
        </form>
    </div>
</body>
</html>