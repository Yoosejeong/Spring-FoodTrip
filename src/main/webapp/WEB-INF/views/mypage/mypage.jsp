<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ include file="../menubar.jsp"%>
<html>
<head>
<title>Mypage</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/mypage.css">
</head>
<body>
	<h2>⚙️마이 페이지</h2>
	<hr class="hr1">
	<%@ include file="../menubar.jsp"%>
	<div class="container">
		<div class="mypage-header"></div>
		<div class="mypage-content">
			<h3>👤${user.nickname}</h3>
			<p>
				<span class="label">🆔 사용자 ID </span> <span class="info">${user.userId}</span>
			</p>
			<p>
				<span class="label">🔒 비밀번호 </span> <span class="info">${user.passwd}</span>
			</p>
			<p>
				<span class="label">📞 전화번호 </span> <span class="info">${user.phone}</span>
			</p>
			<p>
				<span class="label">📧 이메일 </span> <span class="info">${user.email}</span>
			</p>

		</div>
		<div class="center">
			<div class="btn-group">
				<form
					action="${pageContext.request.contextPath}/user/drop/${user.userId}"
					method="get">
					<input type="submit" value="회원 탈퇴" class="btn">
				</form>
			</div>
		</div>
	</div>

</body>
</html>