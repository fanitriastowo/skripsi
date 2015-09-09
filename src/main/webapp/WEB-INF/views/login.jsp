<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/taglib.jsp" %>
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

		<c:if test="${success eq false }">
			<div class="alert alert-danger alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				Username atau Password tidak valid !
			</div>
		</c:if>
		
		<form action='<spring:url value="/j_spring_security_check" />' class="form-signin" method="post">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="j_username" class="sr-only">Email address</label> 
			<input type="text" id="j_username" name="j_username" class="form-control" placeholder="Email address" required autofocus> 
			<label for="j_password" class="sr-only">Password</label> 
			<input type="password" id="j_password" name="j_password" class="form-control" placeholder="Password" required>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		</form>
	</div>

	<%@ include file="/WEB-INF/template/javascript.jsp"%>
	<script type="text/javascript">
		$('#login').addClass('active');
	</script>
</body>
</html>