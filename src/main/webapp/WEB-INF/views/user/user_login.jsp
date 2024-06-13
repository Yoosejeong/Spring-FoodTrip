<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign in</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/login.css' />">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div class="root">
    <div class="signin-wrapper form active">
        <div class="form-wrapper">
            <h5>Welcome Back  👊</h5>
           <form action ="${pageContext.request.contextPath}/user/login" method="post">
            <input type="text" name="userId" placeholder="Username" class="form-field"></input>
            <input  type="password" name="passwd" placeholder="Password" class="form-field"></input>
            <button type="submit" class="button primary">Sign In</button>
            </form>
            <button class="button secondary" id="click-signup">Sign Up</button>
          
        </div>
    </div>
   
</div>

<script>
document.getElementById("click-signup").addEventListener("click", function() {
    window.location.href = "${pageContext.request.contextPath}/user/join";
});
</script>

</body>
</html>