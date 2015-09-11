<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/template/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>metode</title>

<%@ include file="/WEB-INF/template/css.jsp"%>
</head>
<body>
	<div class="container">

		<%@ include file="/WEB-INF/template/navbar.jsp"%>

		<h3>Tambah Data Metode</h3>
		<button class="btn btn-success">Tambah</button>
		<br /> <br />

		<div class="table-responsive">
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th width="5%">No.</th>
						<th>Nama Metode</th>
						<th>Aksi</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${metodes}" var="metode" varStatus="index">
						<tr>
							<td><c:out value="${index.count }" /></td>
							<td><c:out value="${metode.metode }" /></td>
							<td>
								<a href='<spring:url value="/metode/prepare_edit/${metode.id }" />' class="btn btn-xs btn-primary btnUpdate">Edit</a> 
								<a class="btn btn-xs btn-danger">Hapus</a> 
								<a class="btn btn-xs btn-info">Detail</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<!-- Update Modal -->
		<form:form commandName="metode" action="${pageContext.request.contextPath }/metode/edit" method="post">
		<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="updateModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Update Metode</h4>
					</div>
					<div class="modal-body">
						<form:hidden id="lblUpdateId" path="id" />
						<div class="form-group">
							<label for="txtUpdateMetode" class="control-label">Metode:</label>
							<form:input path="metode" cssClass="form-control" id="txtUpdateMetode" placeholder="Type Name" />
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Update</button>
					</div>
				</div>
			</div>
		</div>
		</form:form>

	</div>
	<%@ include file="/WEB-INF/template/javascript.jsp"%>
	<script type="text/javascript">
		$(document).ready(function() {
			
			// add active class every this page accessed
			$('#metode').addClass('active');
			
			// btnUpdate click event to show modal window and fill its field 
			$('.btnUpdate').click(function(e) {
				e.preventDefault();
				var url = $(this).attr("href");
				
				$.getJSON(url, function(data) {
					$('#lblUpdateId').val(data.id);
					$('#txtUpdateMetode').val(data.metode);
				});
				
				$('#updateModal').modal();
			});
		});
	</script>
</body>
</html>