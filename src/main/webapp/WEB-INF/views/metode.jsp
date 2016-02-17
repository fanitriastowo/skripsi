<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/template/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Halaman Daftar Metode</title>

<%@ include file="/WEB-INF/template/css.jsp"%>
</head>
<body>
	<div class="container">

		<%@ include file="/WEB-INF/template/navbar.jsp"%>

		<security:authorize access="hasRole('ROLE_ADMIN')">
			<h3>Tambah Data Metode</h3>
			<button class="btn btn-success" data-toggle="modal" data-target="#addModal">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Tambah</button>
		</security:authorize>
		
		<security:authorize access="isAuthenticated()">
			<a class="btn btn-primary pull-right" href='<spring:url value="/metode/daftar_rangking" />'>
				<span class="glyphicon glyphicon-print" aria-hidden="true" title="Cetak Daftar Rangking Terdahulu"></span> Cetak Laporan</a>
		</security:authorize>

		<div class="panel panel-default">
			<div class="panel-heading"><h3 class="panel-title">Daftar Metode</h3></div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover table-condensed" style="font-size: 0.9em">
						<thead>
							<tr>
								<th width="5%">No.</th>
								<th>Metode</th>
								<th>Materi Pengajaran</th>
								<th>Tujuan Pengajaran</th>
								<th>Waktu Pembelajaran</th>
								<th>Fasilitas</th>
								<th>Kemampuan Guru</th>
								<th>Jumlah Siswa</th>
								<th>Kemampuan Siswa</th>
								<security:authorize access="isAuthenticated()">
								<th width="10%">Aksi</th>
								</security:authorize>
							</tr>
						</thead>
		
						<tbody>
							<c:forEach items="${metodes}" var="metode" varStatus="index">
								<tr>
									<td><c:out value="${index.count }" /></td>
									<td><c:out value="${metode.metode }" /></td>
									<td><c:out value="${metode.materiPengajaran.materi }" /></td>
									<td><c:out value="${metode.tujuanPengajaran.tujuan }" /></td>
									<td><c:out value="${metode.waktuPembelajaran.waktu }" /></td>
									<td><c:out value="${metode.fasilitas.fasilitas }" /></td>
									<td><c:out value="${metode.kemampuanGuru.kemampuan }" /></td>
									<td><c:out value="${metode.jumlahSiswa.jmlSiswa }" /></td>
									<td><c:out value="${metode.kemampuanSiswa.kemampuan }" /></td>
									<security:authorize access="hasRole('ROLE_ADMIN')">
									<td>
										<a href='<spring:url value="/metode/prepare_edit/${metode.id }" />' class="btn btn-xs btn-info btnUpdate" title="Ubah Metode">
											<span class="glyphicon glyphicon-pencil"></span></a> 
										<a href='<spring:url value="/metode/delete/${metode.id }" />' class="btn btn-xs btn-danger btnPrepareDelete" title="Hapus Metode">
											<span class="glyphicon glyphicon-remove"></span></a> 
									</td>
									</security:authorize>
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		<security:authorize access="hasRole('ROLE_ADMIN')">
		<!-- Add Modal -->
		<form:form commandName="metode" action="${pageContext.request.contextPath }/metode/add" method="post" cssClass="addMetodeAdminForm">
		<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="updateModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Tambah Metode</h4>
					</div>
					<div class="modal-body">
					
						<div class="form-group">
							<label for="txtAddMetode" class="control-label">Metode:</label>
							<form:input path="metode" cssClass="form-control" id="txtAddMetode" placeholder="Type Name" />
						</div>
						<div class="form-group">
							<label for="txtAddMateriPengajaran" class="control-label">Materi Pengajaran:</label>
							<form:select path="materiPengajaran" cssClass="form-control" id="txtAddMateriPengajaran" 
										 items="${lookUpMateriPengajaran}" itemValue="id" itemLabel="materi" />
						</div>
						<div class="form-group">
							<label for="txtAddTujuanPengajaran" class="control-label">Tujuan Pengajaran:</label>
							<form:select path="tujuanPengajaran" cssClass="form-control" id="txtAddTujuanPengajaran" 
										 items="${lookUpTujuanPengajaran}" itemValue="id" itemLabel="tujuan" />
						</div>
						<div class="form-group">
							<label for="txtAddWaktuPembelajaran" class="control-label">Waktu Pembelajaran:</label>
							<form:select path="waktuPembelajaran" cssClass="form-control" id="txtAddWaktuPembelajaran" 
										 items="${lookUpWaktuPembelajaran}" itemValue="id" itemLabel="waktu" />
						</div>
						<div class="form-group">
							<label for="txtAddFasilitas" class="control-label">Waktu Pembelajaran:</label>
							<form:select path="fasilitas" cssClass="form-control" id="txtAddFasilitas" 
										 items="${lookUpFasilitas}" itemValue="id" itemLabel="fasilitas" />
						</div>
						<div class="form-group">
							<label for="txtAddKemampuanGuru" class="control-label">Kemampuan Guru:</label>
							<form:select path="kemampuanGuru" cssClass="form-control" id="txtAddKemampuanGuru" 
										 items="${lookUpKemampuanGuru}" itemValue="id" itemLabel="kemampuan" />
						</div>
						<div class="form-group">
							<label for="txtAddJumlahSiswa" class="control-label">Jumlah Siswa:</label>
							<form:select path="jumlahSiswa" cssClass="form-control" id="txtAddJumlahSiswa" 
										 items="${lookUpJumlahSiswa}" itemValue="id" itemLabel="jmlSiswa" />
						</div>
						<div class="form-group">
							<label for="txtAddKemampuanSiswa" class="control-label">Jumlah Siswa:</label>
							<form:select path="kemampuanSiswa" cssClass="form-control" id="txtAddKemampuanSiswa" 
										 items="${lookUpKemampuanSiswa}" itemValue="id" itemLabel="kemampuan" />
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
		</security:authorize>

		<security:authorize access="hasRole('ROLE_ADMIN')">
		<!-- Update Modal -->
		<form:form commandName="metode" action="${pageContext.request.contextPath }/metode/edit" method="post" cssClass="updateMetodeAdminForm">
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
						<div class="form-group">
							<label for="txtUpdateMateriPengajaran" class="control-label">Materi Pengajaran:</label>
							<form:select path="materiPengajaran" cssClass="form-control" id="txtUpdateMateriPengajaran" 
										 items="${lookUpMateriPengajaran}" itemValue="id" itemLabel="materi" />
						</div>
						<div class="form-group">
							<label for="txtUpdateTujuanPengajaran" class="control-label">Tujuan Pengajaran:</label>
							<form:select path="tujuanPengajaran" cssClass="form-control" id="txtUpdateTujuanPengajaran" 
										 items="${lookUpTujuanPengajaran}" itemValue="id" itemLabel="tujuan" />
						</div>
						<div class="form-group">
							<label for="txtUpdateWaktuPembelajaran" class="control-label">Waktu Pembelajaran:</label>
							<form:select path="waktuPembelajaran" cssClass="form-control" id="txtUpdateWaktuPembelajaran" 
										 items="${lookUpWaktuPembelajaran}" itemValue="id" itemLabel="waktu" />
						</div>
						<div class="form-group">
							<label for="txtUpdateFasilitas" class="control-label">Waktu Pembelajaran:</label>
							<form:select path="fasilitas" cssClass="form-control" id="txtUpdateFasilitas" 
										 items="${lookUpFasilitas}" itemValue="id" itemLabel="fasilitas" />
						</div>
						<div class="form-group">
							<label for="txtUpdateKemampuanGuru" class="control-label">Kemampuan Guru:</label>
							<form:select path="kemampuanGuru" cssClass="form-control" id="txtUpdateKemampuanGuru" 
										 items="${lookUpKemampuanGuru}" itemValue="id" itemLabel="kemampuan" />
						</div>
						<div class="form-group">
							<label for="txtUpdateJumlahSiswa" class="control-label">Jumlah Siswa:</label>
							<form:select path="jumlahSiswa" cssClass="form-control" id="txtUpdateJumlahSiswa" 
										 items="${lookUpJumlahSiswa}" itemValue="id" itemLabel="jmlSiswa" />
						</div>
						<div class="form-group">
							<label for="txtUpdateKemampuanSiswa" class="control-label">Kemampuan Siswa:</label>
							<form:select path="kemampuanSiswa" cssClass="form-control" id="txtUpdateKemampuanSiswa" 
										 items="${lookUpKemampuanSiswa}" itemValue="id" itemLabel="kemampuan" />
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
		</security:authorize>
		
		<security:authorize access="hasRole('ROLE_ADMIN')">
		<!-- Modal Delete -->
		<div class="modal fade" id="modalDelete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Tutup</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Hapus Metode</h4>
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
		</security:authorize>

	</div>

	<%@ include file="/WEB-INF/template/footer.jsp"%>
	<%@ include file="/WEB-INF/template/javascript.jsp"%>
	<script src='<spring:url value="/assets/js/jquery.validate.min.js"/>'></script>
	<script type="text/javascript">
		$(document).ready(function() {
			
			// add active class every this page accessed
			$('#metode').addClass('active');

			$(".addMetodeAdminForm").validate({
				rules : {
					metode : {
						required : true,
						minlength : 3
					}
				},
				messages : {
					metode : {
						required : "Metode tidak boleh kosong",
						minlength : "Minimal 3 karakter"
					}
				},
				highlight : function(element) {
					$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
				},
				unhighlight : function(element) {
					$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
				}
			});

			$(".updateMetodeAdminForm").validate({
				rules : {
					metode : {
						required : true,
						minlength : 3
					}
				},
				messages : {
					metode : {
						required : "Metode tidak boleh kosong",
						minlength : "Minimal 3 karakter"
					}
				},
				highlight : function(element) {
					$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
				},
				unhighlight : function(element) {
					$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
				}
			});

			// btnUpdate click event to show modal window and fill its field 
			$('.btnUpdate').click(function(e) {
				e.preventDefault();
				var url = $(this).attr("href");
				$.getJSON(url, function(data) {
					
					// unselect before select
					$('select[id^="txtUpdateMateriPengajaran"] option:selected').attr("selected",null);
					$('select[id^="txtUpdateTujuanPengajaran"] option:selected').attr("selected",null);
					$('select[id^="txtUpdateWaktuPembelajaran"] option:selected').attr("selected",null);
					$('select[id^="txtUpdateFasilitas"] option:selected').attr("selected",null);
					$('select[id^="txtUpdateKemampuanGuru"] option:selected').attr("selected",null);
					$('select[id^="txtUpdateJumlahSiswa"] option:selected').attr("selected",null);
					$('select[id^="txtUpdateKemampuanSiswa"] option:selected').attr("selected",null);

					$('#lblUpdateId').val(data.id);
					$('#txtUpdateMetode').val(data.metode);
					$('select[id^="txtUpdateMateriPengajaran"] option[value="' + data.materiPengajaran["id"] + '"]').attr("selected","selected");
					$('select[id^="txtUpdateTujuanPengajaran"] option[value="' + data.tujuanPengajaran["id"] + '"]').attr("selected","selected");
					$('select[id^="txtUpdateWaktuPembelajaran"] option[value="' + data.waktuPembelajaran["id"] + '"]').attr("selected","selected");
					$('select[id^="txtUpdateFasilitas"] option[value="' + data.fasilitas["id"] + '"]').attr("selected","selected");
					$('select[id^="txtUpdateKemampuanGuru"] option[value="' + data.kemampuanGuru["id"] + '"]').attr("selected","selected");
					$('select[id^="txtUpdateJumlahSiswa"] option[value="' + data.jumlahSiswa["id"] + '"]').attr("selected","selected");
					$('select[id^="txtUpdateKemampuanSiswa"] option[value="' + data.kemampuanSiswa["id"] + '"]').attr("selected","selected");

				});
				$('#updateModal').modal();
			});
			
			// notification before delete metode
			$('.btnPrepareDelete').click(function(e) {
				e.preventDefault();
				$('#modalDelete .btnDelete').attr("href", $(this).attr("href"));
				$('#modalDelete').modal();
			});
		});
	</script>
</body>
</html>