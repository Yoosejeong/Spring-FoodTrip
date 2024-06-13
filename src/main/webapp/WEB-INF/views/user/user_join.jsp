<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>Sign Up</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/login.css">
</head>
<body>
	<div class="root">
		<div class="signup-wrapper form active">
			<div class="form-wrapper">
				<h5>👋 Hello</h5>
				<c:if test="${not empty error}">
					<div style="color: red;">${error}</div>
				</c:if>
				<form action="${pageContext.request.contextPath}/user/join"
					method="post">
					<input type="text" name="userId" placeholder="Username"
						class="form-field" required> <input type="email"
						name="email" placeholder="Email" class="form-field" required>
					<input type="password" name="passwd" placeholder="Password"
						class="form-field" required> <input type="text"
						name="phone" placeholder="Phone" class="form-field" required>
					<input type="text" name="nickname" placeholder="Nickname"
						class="form-field" required>
					<button type="submit" class="button primary">Sign Up</button>
				</form>
				<button class="button secondary" id="click-signin">Sign In</button>

			</div>
		</div>
	</div>

	<script>
		document
				.getElementById("click-signin")
				.addEventListener(
						"click",
						function() {
							window.location.href = "${pageContext.request.contextPath}/";
						});
	</script>

</body>
</html>