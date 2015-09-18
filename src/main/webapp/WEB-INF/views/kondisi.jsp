<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/template/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Halaman Kondisi Kelas</title>
<%@ include file="/WEB-INF/template/css.jsp"%>

</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/template/navbar.jsp"%>

		<h3>Tambah Kondisi Kelas</h3>
		<button class="btn btn-success" data-toggle="modal" data-target="#addModal">
			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Tambah</button> 
		<br /><br />

		<div class="table-responsive">
			<table class="table table-hovered table-striped table-bordered">
				<thead>
					<tr>
						<th width="5%">No.</th>
						<th>Jumlah Siswa</th>
						<th>Point</th>
						<th>Operation</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${kondisis }" var="kondisi" varStatus="index">
					<tr>
						<td><c:out value="${index.count }" />.</td>
						<td><c:out value="${kondisi.jmlSiswa }" /></td>
						<td><c:out value="${kondisi.point }" /></td>
						<td>
							<a href="#" class="btn btn-xs btn-primary">
								<span class="glyphicon glyphicon-pencil"></span> Update</a>
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
			$('#kondisi_kelas').addClass('active');
		});
	</script>
</body>
</html>