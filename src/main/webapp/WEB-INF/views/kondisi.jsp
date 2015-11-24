<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/template/taglib.jsp"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Halaman Kondisi</title>
<%@ include file="/WEB-INF/template/css.jsp"%>
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/template/navbar.jsp"%>

		<h3>Tambah Kondisi</h3>

		<!-- Button Tambah Kondisi Kelas -->
		<button type="button" class="btn btn-success" data-toggle="modal" data-target="#addModal">
			<span class="glyphicon glyphicon-plus"></span> Tambah</button>
			
		<br /><br />
		
		<div class="table-responsive">
			<table class="table table-hovered table-bordered table-striped">
				<thead>
					<tr>
						<th width="5%">No.</th>
						<th>Kondisi</th>
						<th>Point</th>
						<th>Operation</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${kondisis }" var="kondisi" varStatus="index">
					<tr>
						<td><c:out value="${index.count }" />. </td>
						<td><c:out value="${kondisi.kondisi}" /> </td>
						<td><c:out value="${kondisi.point }" /> </td>
						<td>
							<a href='<spring:url value="/kondisi/prepare_update/${kondisi.id }" />' class="btn btn-xs btn-primary triggerUpdate">
								<span class="glyphicon glyphicon-pencil"></span> Edit</a>
							<a href='<spring:url value="/kondisi/delete/${kondisi.id }" />' class="btn btn-xs btn-danger triggerDelete">
								<span class="glyphicon glyphicon-remove"></span> Delete</a>
						</td>
					</tr>					
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>

	<!-- Add Modal -->
	<form:form commandName="kondisi" action="${pageContext.request.contextPath }/kondisi/save">
		<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalLabel">Tambah Data Kondisi</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="txtAddFasilitas" class="control-label">Kondisi:</label>
							<form:input path="kondisi" id="txtAddKondisi" cssClass="form-control" placeholder="Type Kondisi" />
						</div>
						<div class="form-group">
							<label for="txtAddPoint" class="control-label">Point:</label>
							<form:input path="point" id="txtAddPoint" cssClass="form-control" placeholder="Type Point"/>
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

	<!-- Update Modal -->
	<form:form commandName="kondisi" action="${pageContext.request.contextPath }/kondisi/update">
		<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalLabel">Update Data Kondisi</h4>
					</div>
					<div class="modal-body">
						<form:hidden path="id" id="txtUpdateLblId"/>
						<div class="form-group">
							<label for="txtUpdateFasilitas" class="control-label">Fasilitas:</label>
							<form:input path="kondisi" id="txtUpdateKondisi" cssClass="form-control" placeholder="Type Kondisi" />
						</div>
						<div class="form-group">
							<label for="txtUpdatePoint" class="control-label">Point:</label>
							<form:input path="point" id="txtUpdatePoint" cssClass="form-control" placeholder="Type Point"/>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							<span class="glyphicon glyphicon-remove-circle"></span> Batal</button>
						<button type="submit" class="btn btn-primary">
							<span class="glyphicon glyphicon-ok-circle"></span> Update</button>
					</div>
				</div>
			</div>
		</div>
	</form:form>
	
	<!-- Delete Modal Notification -->
	<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Tutup</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Hapus Data Kondisi</h4>
				</div>
				<div class="modal-body">
					<strong>Apakah Anda yakin akan menghapus? </strong>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						<span class="glyphicon glyphicon-remove-circle"></span> Batal</button>
					<a href="" class="btn btn-danger btnRemove">
						<span class="glyphicon glyphicon-ok-circle"></span> Hapus</a>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/template/javascript.jsp"%>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$('#master').addClass('active');
		
		// Trigger Delete Confirmation
		$('.triggerDelete').click(function(e) {
			e.preventDefault();
			$('#modalRemove .btnRemove').attr("href", $(this).attr("href"));
			$('#modalRemove').modal();
		});
		
		// Tampilkan update form menggunakan bootstrap modal
		$('.triggerUpdate').click(function(e) {
			e.preventDefault();
			var url = $(this).attr("href");
			
			$.getJSON(url, function(data) {
				$('#txtUpdateLblId').val(data.id);
				$('#txtUpdateKondisi').val(data.kondisi);
				$('#txtUpdatePoint').val(data.point);
			});
			
			$('#updateModal').modal();
		});
	});
</script>
</html>