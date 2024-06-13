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
	href="${pageContext.request.contextPath}/resources/boardwrite.css">
<title>게시글 작성</title>
</head>
<body>
	<h2>📝게시글 작성</h2>
	<%@ include file="../menubar.jsp"%>
	<div class="panel-body">
		<form method="post"
			action="${pageContext.request.contextPath}/board/write">
			<div class="form-group">
				<label>👤작성자</label>
				<!-- <input class="form-control" name="userId" value="${sessionScope.userId}" readonly> -->
				<input class="form-control" name="userId" value="${nickname}"
					readonly>
			</div>
			<div class="form-group">
				<label>📌제목</label> <input class="form-control" name="title" required>
			</div>
			<div class="form-group">
				<label>📃내용</label>
				<textarea class="form-control" rows="3" name="content" required></textarea>
			</div>
			<div class="form-group">
				<label>🖇️카테고리</label>
				<select id = "category" name="category" required>
                    <option value="한식">한식</option>
                    <option value="중식">중식</option>
                    <option value="일식">일식</option>
                    <option value="양식">양식</option>
                     <option value="기타">기타</option>
                  </select>
			</div>
			<div class="form-group">
				<label>⭐평점</label> <input class="form-control" type="number"
					name="rating" min="1" max="5" step="0.5" required>
			</div>

			<input type="submit" class="btn btn-default" value="글 등록하기"
				style="margin-top: 50px;"> <input type="button"
				class="btn btn-default" value="목록보기"
				onClick="location.href='${pageContext.request.contextPath}/board/list'"
				style="margin-top: 50px;">
		</form>
	</div>
</body>
</html>