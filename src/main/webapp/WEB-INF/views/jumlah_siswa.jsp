<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/template/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Halaman Jumlah Siswa</title>
<%@ include file="/WEB-INF/template/css.jsp"%>

</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/template/navbar.jsp"%>

		<h3>Tambah Jumlah Siswa</h3>
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
					<c:forEach items="${jumlahSiswas }" var="jumlahSiswa" varStatus="index">
					<tr>
						<td><c:out value="${index.count }" />.</td>
						<td><c:out value="${jumlahSiswa.jmlSiswa }" /></td>
						<td><c:out value="${jumlahSiswa.point }" /></td>
						<td>
							<a href='<spring:url value="/jumlah_siswa/prepare_update/${jumlahSiswa.id }" />' class="btn btn-xs btn-primary triggerUpdate">
								<span class="glyphicon glyphicon-pencil"></span> Update</a>
							<a href='<spring:url value="/jumlah_siswa/delete/${jumlahSiswa.id }" />' class="btn btn-xs btn-danger triggerDelete">
								<span class="glyphicon glyphicon-remove"></span> Delete</a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<!-- Add Modal -->
	<form:form commandName="jumlahSiswa" action="${pageContext.request.contextPath }/jumlah_siswa/save" >
	<div class="modal fade" id="addModal" tabindex = "-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Tutup</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Add Data Jumlah Siswa</h4>
				</div>
				<div class="modal-body">
					
					<div class="form-group">
						<label for="txtAddJmlSiswa" class="control-label">Jumlah Siswa:</label>
						<form:input id="txtAddJmlSiswa" path="jmlSiswa" cssClass="form-control" placeholder="Type Jumlah Siswa"/>
					</div>	
						
					<div class="form-group">
						<label for="txtAddPoint" class="control-label">Point:</label>
						<form:input id="txtAddPoint" path="point" cssClass="form-control" placeholder="Type Point"/>
					</div>	
						
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						<span class="glyphicon glyphicon-remove-circle"></span> Batal</button>
					<button type="submit" class="btn btn-danger btnRemove">
						<span class="glyphicon glyphicon-ok-circle"></span> Save</button>
				</div>
			</div>
		</div>
	</div>
	</form:form>
	
	<!-- Update Modal -->
	<form:form commandName="jumlahSiswa" action="${pageContext.request.contextPath }/jumlah_siswa/update" >
	<div class="modal fade" id="updateModal" tabindex = "-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Tutup</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Update Data Jumlah Siswa</h4>
				</div>
				<div class="modal-body">
					<form:hidden path="id" id="lblUpdateId"/>
					<div class="form-group">
						<label for="txtUpdateJmlSiswa" class="control-label">Jumlah Siswa:</label>
						<form:input id="txtUpdateJmlSiswa" path="jmlSiswa" cssClass="form-control" placeholder="Type Jumlah Siswa"/>
					</div>	
						
					<div class="form-group">
						<label for="txtUpdatePoint" class="control-label">Point:</label>
						<form:input id="txtUpdatePoint" path="point" cssClass="form-control" placeholder="Type Point"/>
					</div>	
						
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						<span class="glyphicon glyphicon-remove-circle"></span> Batal</button>
					<button type="submit" class="btn btn-danger btnRemove">
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
					<h4 class="modal-title" id="myModalLabel">Hapus Data</h4>
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
		$('#master').addClass('active');
		
		// tampilkan notifikasi sebelum menghapus
		$('.triggerDelete').click(function(e) {
			e.preventDefault();
			$('#modalRemove .btnRemove').attr("href", $(this).attr("href"));
			$('#modalRemove').modal();
		});
		
		// tampilkan dialog update
		$('.triggerUpdate').click(function(e) {
			e.preventDefault();
			var url = $(this).attr("href");
			
			$.getJSON(url, function(data) {
				$('#lblUpdateId').val(data.id);
				$('#txtUpdateJmlSiswa').val(data.jmlSiswa);
				$('#txtUpdatePoint').val(data.point);
			});
			
			$('#updateModal').modal();
		});
	});
</script>
</html>