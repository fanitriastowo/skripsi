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
		<button class="btn btn-success">Tambah</button><br /><br />

		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nama Metode</th>
					<th>Aksi</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${metodes}" var="metode">
					<tr>
						<td><c:out value="${metode.id }" /></td>
						<td><c:out value="${metode.metode }" /></td>
						<td>
							<a class="btn btn-xs btn-primary">Edit</a>
							<a class="btn btn-xs btn-danger">Hapus</a>
							<a class="btn btn-xs btn-info">Detail</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>




	</div>
	<%@ include file="/WEB-INF/template/javascript.jsp"%>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#metode').addClass('active');
		});
	</script>
</body>
</html>