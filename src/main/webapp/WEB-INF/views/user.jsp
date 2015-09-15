<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Halaman User</title>
<%@ include file="/WEB-INF/template/css.jsp"%>

</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/template/navbar.jsp"%>

		<h3>Tambah User</h3>
		<button class="btn btn-success" data-toggle="modal" data-target="#addModal">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Tambah</button> 	
		
		<br /><br />
		
		<!-- Add Modal -->
		<form:form commandName="user" action="${pageContext.request.contextPath }/user/add" method="post">
		<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="updateModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Tambah User</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="txtAddUsername" class="control-label">Username:</label>
							<form:input path="username" cssClass="form-control" id="txtAddUsername" placeholder="Type Username" />
						</div>
						<div class="form-group">
							<label for="txtAddPassword" class="control-label">Password:</label>
							<form:password path="password" cssClass="form-control" id="txtAddPassword" placeholder="Type Password" />
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							<span class="glyphicon glyphicon-remove-circle"></span> Close</button>
						<button type="submit" class="btn btn-primary">
							<span class="glyphicon glyphicon-ok-circle"></span> Save</button>
					</div>
				</div>
			</div>
		</div>
		</form:form>
		
		<div class="table-responsive">
			<table class="table table-hover table-bordered table striped">
				<thead>
					<tr>
						<th width="5%">No.</th>
						<th>Username</th>
						<th>Operation</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users }" var="user" varStatus="index">
					<tr>
						<td><c:out value="${index.count }" /> </td>
						<td><c:out value="${user.username }" /> </td>
						<td>
							<a href="#" class="btn btn-xs btn-info">
								<span class="glyphicon glyphicon-menu-hamburger"></span> Detail</a> 
							<a href="#" class="btn btn-xs btn-primary">
								<span class="glyphicon glyphicon-pencil"></span> Edit</a> 
							<a href="#" class="btn btn-xs btn-danger">
								<span class="glyphicon glyphicon-remove"></span> Delete</a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>		
		</div>
		
	</div>
	
	<%@ include file="/WEB-INF/template/javascript.jsp"%>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#user').addClass('active');
		});
	</script>
</body>
</html>