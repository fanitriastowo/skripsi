<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/template/taglib.jsp"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Halaman Keaktifan Siswa</title>
<%@ include file="/WEB-INF/template/css.jsp"%>
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/template/navbar.jsp"%>

		<h3>Tambah Keaktifan Siswa</h3>

		<!-- Button Tambah Keaktifan Kelas -->
		<button type="button" class="btn btn-success" data-toggle="modal" data-target="#addModal">
			<span class="glyphicon glyphicon-plus"></span> Tambah</button>
			
		<br /><br />
		
		<div class="table-responsive">
			<table class="table table-hovered table-bordered table-striped">
				<thead>
					<tr>
						<th width="5%">No.</th>
						<th>Jml Siswa Aktif</th>
						<th>Point</th>
						<th>Operation</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${keaktifans }" var="keaktifan" varStatus="index">
					<tr>
						<td><c:out value="${index.count }" />. </td>
						<td><c:out value="${keaktifan.jmlSiswa }" /> </td>
						<td><c:out value="${keaktifan.point }" /> </td>
						<td>
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

	<!-- Add Modal -->
	<form:form commandName="keaktifan" action="${pageContext.request.contextPath }/keaktifan/save">
		<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalLabel">Tambah Data Kraktifan Siswa</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="txtAddJmlSiswa" class="col-sm-2 control-label">Jumlah Siswa Aktif:</label>
							<div class="col-sm-10">
								<form:input path="jmlSiswa" id="txtAddJmlSiswa" cssClass="form-control" placeholder="Type Jumlah" />
							</div>
						</div>
						<div class="form-group">
							<label for="txtAddPoint" class="col-sm-2 control-label">Point:</label>
							<div class="col-sm-10">
								<form:input path="point" id="txtAddPoint" cssClass="form-control" placeholder="Type Point"/>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							<span class="glyphicon glyphicon-remove-circle"></span> Batal</button>
						<button type="submit" class="btn btn-primary">
							<span class="glyphicon glyphicon-ok-circle"></span> Save</button>
					</div>
				</div>
			</div>
		</div>
	</form:form>

	<%@ include file="/WEB-INF/template/javascript.jsp"%>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$('#keaktifan_siswa').addClass('active');
	});
</script>
</html>