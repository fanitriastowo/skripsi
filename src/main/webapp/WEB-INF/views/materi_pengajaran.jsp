<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/template/taglib.jsp"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Halaman Materi Pengajaran</title>
<%@ include file="/WEB-INF/template/css.jsp"%>
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/template/navbar.jsp"%>

		<h3>Tambah Materi Pengajaran</h3>

		<!-- Button Tambah Keaktifan Kelas -->
		<button type="button" class="btn btn-success" data-toggle="modal" data-target="#addModal">
			<span class="glyphicon glyphicon-plus"></span> Tambah</button>
		<hr>
		
		<div class="table-responsive">
			<table class="table table-hovered table-bordered table-striped">
				<thead>
					<tr>
						<th width="5%">No.</th>
						<th>Materi Pengajaran</th>
						<th>Point</th>
						<th>Operation</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${materis }" var="materi" varStatus="index">
					<tr>
						<td><c:out value="${index.count }" />. </td>
						<td><c:out value="${materi.materi }" /> </td>
						<td><c:out value="${materi.point }" /> </td>
						<td>
							<a href='<spring:url value="/materi_pengajaran/prepare_update/${materi.id }" />' class="btn btn-xs btn-primary triggerUpdate">
								<span class="glyphicon glyphicon-pencil"></span> Edit</a>
							<a href='<spring:url value="/materi_pengajaran/delete/${materi.id }" />' class="btn btn-xs btn-danger triggerDelete">
								<span class="glyphicon glyphicon-remove"></span> Delete</a>
						</td>
					</tr>					
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>

	<!-- Add Modal -->
	<form:form commandName="materiPengajaran" action="${pageContext.request.contextPath }/materi_pengajaran/save" cssClass="addMateriPengajaranForm">
		<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalLabel">Tambah Data Materi Pengajaran</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="txtAddMateriPengajaran" class="control-label">Materi Pengajaran:</label>
							<form:input path="materi" cssClass="form-control" placeholder="Type Materi Pengajaran" />
						</div>
						<div class="form-group">
							<label for="txtAddPoint" class="control-label">Point:</label>
							<form:input path="point" cssClass="form-control" placeholder="Type Point"/>
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
	<form:form commandName="materiPengajaran" action="${pageContext.request.contextPath }/materi_pengajaran/update" cssClass="updateMateriPengajaranForm">
		<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalLabel">Update Data Materi Pengajaran</h4>
					</div>
					<div class="modal-body">
						<form:hidden path="id" id="txtUpdateLblId"/>
						<div class="form-group">
							<label for="txtUpdateMateriPengajaran" class="control-label">Materi Pengajaran:</label>
							<form:input path="materi" id="txtUpdateMateriPengajaran" cssClass="form-control" placeholder="Type Materi" />
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
					<h4 class="modal-title" id="myModalLabel">Hapus Data Materi Pengajaran</h4>
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

	<%@ include file="/WEB-INF/template/footer.jsp"%>
	<%@ include file="/WEB-INF/template/javascript.jsp"%>
	<script src='<spring:url value="/assets/js/jquery.validate.min.js"/>'></script>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$('#kriteria').addClass('active');
		
		$(".addMateriPengajaranForm").validate({
			rules : {
				materi : {
					required : true,
					minlength : 3
				},
				point : {
					required : true,
					min : 1,
					number : true
				}
			},
			messages : {
				materi : {
					required : "Field Materi tidak boleh kosong",
					minlength : "Minimal 3 karakter"
				},
				point : {
					required : "Field Point tidak boleh kosong",
					min : "Point Minimal 1",
					number : "Inputan harus berupa angka"
				}
			},
			highlight : function(element) {
				$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
			},
			unhighlight : function(element) {
				$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
			}
		});
		
		
		$(".updateMateriPembelajaranForm").validate({
			rules : {
				materi : {
					required : true,
					minlength : 3
				},
				point : {
					required : true,
					min : 1,
					number : true
				}
			},
			messages : {
				materi : {
					required : "Field Fasilitas tidak boleh kosong",
					minlength : "Minimal 3 karakter"
				},
				point : {
					required : "Field Point tidak boleh kosong",
					min : "Point Minimal 1",
					number : "Inputan harus berupa angka"
				}
			},
			highlight : function(element) {
				$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
			},
			unhighlight : function(element) {
				$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
			}
		});
		
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
				$('#txtUpdateMateriPengajaran').val(data.materi);
				$('#txtUpdatePoint').val(data.point);
			});
			
			$('#updateModal').modal();
		});
	});
</script>
</html>