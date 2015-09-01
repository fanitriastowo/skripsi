<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<%@ include file="/WEB-INF/template/css.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/login.css">
<title>Login Page</title>

</head>
<body>

	<div class="container">
		<%@ include file="/WEB-INF/template/navbar.jsp"%>

		<form class="form-signin">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputEmail" class="sr-only">Email address</label> 
			<input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus> 
			<label for="inputPassword" class="sr-only">Password</label> 
			<input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		</form>
	</div>

	<%@ include file="/WEB-INF/template/javascript.jsp"%>

</body>
</html>