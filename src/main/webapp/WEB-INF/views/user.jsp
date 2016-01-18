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
		<hr>
		
		<!-- Add Modal -->
		<form:form commandName="user" action="${pageContext.request.contextPath }/user/add" method="post">
		<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
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
						<div class="form-group">
							<label for="txtAddNamaLengkap" class="control-label">Nama Lengkap:</label>
							<form:input path="namaLengkap" cssClass="form-control" id="txtAddNamaLengkap" placeholder="Type Nama Lengkap" />
						</div>
						<div class="form-group">
							<label for="txtAddNoTelp" class="control-label">No. Telp:</label>
							<form:input path="noTelp" cssClass="form-control" id="txtAddNoTelp" placeholder="Type Phone" />
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
						<th>Nama Lengkap</th>
						<th>No. Telp</th>
						<th>Username</th>
						<th>Operation</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users }" var="user" varStatus="index">
					<tr>
						<td><c:out value="${index.count }" />. </td>
						<td><c:out value="${user.namaLengkap }" /> </td>
						<td><c:out value="${user.noTelp }" /> </td>
						<td><c:out value="${user.username }" /> </td>
						<td>
							<a href="#" class="btn btn-xs btn-info">
								<span class="glyphicon glyphicon-menu-hamburger"></span> Detail</a> 
							<a href='<spring:url value="/user/prepare_update/${user.id }" />' class="btn btn-xs btn-primary btnUpdate">
								<span class="glyphicon glyphicon-pencil"></span> Edit</a> 
							<a href='<spring:url value="/user/delete/${user.id }" />' class="btn btn-xs btn-danger triggerRemove">
								<span class="glyphicon glyphicon-remove"></span> Delete</a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>		
		</div>
		
		<!-- Update Modal -->
		<form:form commandName="user" action="${pageContext.request.contextPath }/user/update" method="post">
		<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="updateModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Update User</h4>
					</div>
					<div class="modal-body">
						<form:hidden path="id" id="lblUpdateId"/>
						<div class="form-group">
							<label for="txtUpdateUsername" class="control-label">Username:</label>
							<form:input path="username" cssClass="form-control" id="txtUpdateUsername" placeholder="Type Username" />
						</div>
						<div class="form-group">
							<label for="txtUpdateNamaLengkap" class="control-label">Nama Lengkap:</label>
							<form:input path="namaLengkap" cssClass="form-control" id="txtUpdateNamaLengkap" placeholder="Type Nama Lengkap" />
						</div>
						<div class="form-group">
							<label for="txtUpdateNoTelp" class="control-label">No. Telp:</label>
							<form:input path="noTelp" cssClass="form-control" id="txtUpdateNoTelp" placeholder="Type Phone" />
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							<span class="glyphicon glyphicon-remove-circle"></span> Close</button>
						<button type="submit" class="btn btn-primary">
							<span class="glyphicon glyphicon-ok-circle"></span> Update</button>
					</div>
				</div>
			</div>
		</div>
		</form:form>
		
		<!-- Modal Remove -->
		<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Tutup</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Hapus Data User</h4>
					</div>
					<div class="modal-body">
						<strong>Apakah Anda yakin akan menghapus? </strong>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							<span class="glyphicon glyphicon-remove-circle"></span> Batal</button>
						<a href="" class="btn btn-danger btnDelete">
							<span class="glyphicon glyphicon-ok-circle"></span> Hapus</a>
					</div>
				</div>
			</div>
		</div>
		
	</div>
	
	<%@ include file="/WEB-INF/template/footer.jsp"%>
	<%@ include file="/WEB-INF/template/javascript.jsp"%>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#user').addClass('active');
			
			// Update Modal
			$('.btnUpdate').click(function (e) {
				e.preventDefault();
				var updateURL = $(this).attr("href");
				$.getJSON( updateURL, function( data ) {
					$('#lblUpdateId').val(data.id);
					$('#txtUpdateUsername').val(data.username);
					$('#txtUpdateNamaLengkap').val(data.namaLengkap);
					$('#txtUpdateNoTelp').val(data.noTelp);
				});
				$('#updateModal').modal();
			});
			
			// Delete Modal Event
			$('.triggerRemove').click(function(e) {
				e.preventDefault();
				$('#modalRemove .btnDelete').attr("href", $(this).attr("href"));
				$('#modalRemove').modal();
			});
		});
	</script>
</body>
</html>