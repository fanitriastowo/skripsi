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
							<a href='<spring:url value="/kondisi/delete/${kondisi.id }" />' class="btn btn-xs btn-danger triggerDelete">
								<span class="glyphicon glyphicon-remove"></span> Delete</a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<!-- Modal Remove -->
	<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Tutup</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Hapus Data Kondisi Kelas</h4>
				</div>
				<div class="modal-body">
					<strong>Apakah Anda yakin akan menghapus? </strong>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						<span class="glyphicon glyphicon-remove-circle"></span> Batal</button>
					<a href="" class="btn btn-danger btnRemove">
						<span class="glyphicon glyphicon-ok-circle"></span> Delete</a>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/template/javascript.jsp"%>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$('#kondisi_kelas').addClass('active');
		
		// tampilkan notifikasi sebelum menghapus
		$('.triggerDelete').click(function(e) {
			e.preventDefault();
			$('#modalRemove .btnRemove').attr("href", $(this).attr("href"));
			$('#modalRemove').modal();
		});
	});
</script>
</html>