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

		<div class="panel panel-default">
			<div class="panel-heading"><h3 class="panel-title">Daftar Metode</h3></div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover table-condensed" style="font-size: 0.9em">
						<thead>
							<tr>
								<th width="5%">No.</th>
								<th>Metode</th>
								<th>Jumlah Siswa</th>
								<th>Keaktifan Siswa</th>
								<th>Kondisi Sekolah</th>
								<th>Kondisi Kelas</th>
								<th>Fasilitas</th>
								<th>Kualitas Pengajar</th>
								<th width="10%">Aksi</th>
							</tr>
						</thead>
		
						<tbody>
							<c:forEach items="${metodes}" var="metode" varStatus="index">
								<tr>
									<td><c:out value="${index.count }" /></td>
									<td><c:out value="${metode.metode }" /></td>
									<td><c:out value="${metode.jumlahSiswa.jmlSiswa }" /></td>
									<td><c:out value="${metode.keaktifan.jmlSiswa }" /></td>
									<td><c:out value="${metode.kondisiSekolah.kondisi }" /></td>
									<td><c:out value="${metode.kondisiKelas.kondisi }" /></td>
									<td><c:out value="${metode.fasilitas.fasilitas }" /></td>
									<td><c:out value="${metode.pengajar.kualitas }" /></td>
									<security:authorize access="hasRole('ROLE_ADMIN')">
									<td>
										<a href='<spring:url value="/metode/prepare_edit/${metode.id }" />' class="btn btn-xs btn-info btnUpdate" title="Ubah Metode">
											<span class="glyphicon glyphicon-pencil"></span></a> 
										<a href='<spring:url value="/metode/delete/${metode.id }" />' class="btn btn-xs btn-danger btnPrepareDelete" title="Hapus Metode">
											<span class="glyphicon glyphicon-remove"></span></a> 
									</td>
									</security:authorize>
									
									<security:authorize access="hasRole('ROLE_GURU')">
									<td>
										<a href='<spring:url value="/metode/prepare_edit_guru/${metode.id }" />' class="btn btn-xs btn-info btnUpdateGuru" title="Ubah Metode">
											<span class="glyphicon glyphicon-pencil"></span></a> 
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
		<form:form commandName="metode" action="${pageContext.request.contextPath }/metode/add" method="post">
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
							<label for="txtAddJumlahSiswa" class="control-label">Jumlah Siswa:</label>
							<form:select path="jumlahSiswa" cssClass="form-control" id="txtAddJumlahSiswa" items="${lookUpJumlahSiswa }" itemValue="id" itemLabel="jmlSiswa" />
						</div>
						<div class="form-group">
							<label for="txtAddKeaktifanSiswa" class="control-label">Keaktifan Siswa:</label>
							<form:select path="keaktifan" cssClass="form-control" id="txtAddKeaktifanSiswa" items="${lookUpkeaktifanSiswa }" itemValue="id" itemLabel="jmlSiswa" />
						</div>
						<div class="form-group">
							<label for="txtAddKondisiSekolah" class="control-label">Kondisi Sekolah:</label>
							<form:select path="kondisiSekolah" cssClass="form-control" id="txtAddKondisiSekolah" items="${lookUpKondisiSekolah }" itemValue="id" itemLabel="kondisi" />
						</div>
						<div class="form-group">
							<label for="txtAddKondisiKelas" class="control-label">Kondisi Kelas:</label>
							<form:select path="kondisiKelas" cssClass="form-control" id="txtAddKondisiKelas" items="${lookUpKondisiKelas }" itemValue="id" itemLabel="kondisi" />
						</div>
						<div class="form-group">
							<label for="txtAddFasilitas" class="control-label">Fasilitas:</label>
							<form:select path="fasilitas" cssClass="form-control" id="txtAddFasilitas" items="${lookUpFasilitas }" itemValue="id" itemLabel="fasilitas" />
						</div>
						<div class="form-group">
							<label for="txtAddKualitasPengajar" class="control-label">Kualitas Pengajar:</label>
							<form:select path="pengajar" cssClass="form-control" id="txtAddKualitasPengajar" items="${lookUpPengajar }" itemValue="id" itemLabel="kualitas" />
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
							<label for="txtUpdateMetode" class="control-label" >Metode:</label>
							<form:input path="metode" cssClass="form-control" id="txtUpdateMetode" placeholder="Type Name" />
						</div>
						<div class="form-group">
							<label for="txtUpdateJumlahSiswa" class="control-label">Jumlah Siswa:</label>
							<form:select path="jumlahSiswa" cssClass="form-control" id="txtUpdateJumlahSiswa" items="${lookUpJumlahSiswa}" itemValue="id" itemLabel="jmlSiswa" />
						</div>
						<div class="form-group">
							<label for="txtUpdateKeaktifanSiswa" class="control-label">Keaktifan Siswa:</label>
							<form:select path="keaktifan" cssClass="form-control" id="txtUpdateKeaktifanSiswa" items="${lookUpkeaktifanSiswa }" itemValue="id" itemLabel="jmlSiswa" />
						</div>
						<div class="form-group">
							<label for="txtUpdateKondisiSekolah" class="control-label">Kondisi Sekolah:</label>
							<form:select path="kondisiSekolah" cssClass="form-control" id="txtUpdateKondisiSekolah" items="${lookUpKondisiSekolah }" itemValue="id" itemLabel="kondisi" />
						</div>
						<div class="form-group">
							<label for="txtUpdateKondisiKelas" class="control-label">Kondisi Kelas:</label>
							<form:select path="kondisiKelas" cssClass="form-control" id="txtUpdateKondisiKelas" items="${lookUpKondisiKelas }" itemValue="id" itemLabel="kondisi" />
						</div>
						<div class="form-group">
							<label for="txtUpdateFasilitas" class="control-label">Fasilitas:</label>
							<form:select path="fasilitas" cssClass="form-control" id="txtUpdateFasilitas" items="${lookUpFasilitas }" itemValue="id" itemLabel="fasilitas" />
						</div>
						<div class="form-group">
							<label for="txtUpdateKualitasPengajar" class="control-label">Kualitas Pengajar:</label>
							<form:select path="pengajar" cssClass="form-control" id="txtUpdateKualitasPengajar" items="${lookUpPengajar }" itemValue="id" itemLabel="kualitas" />
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
		
		<security:authorize access="hasRole('ROLE_GURU')">
		<!-- Update Modal -->
		<form:form commandName="metode" action="${pageContext.request.contextPath }/metode/edit_guru" method="post">
		<div class="modal fade" id="updateModalGuru" tabindex="-1" role="dialog" aria-labelledby="updateModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Update Metode</h4>
					</div>
					<div class="modal-body">
						<form:hidden id="lblGuruUpdateId" path="id" />
						<div class="form-group">
							<label for="txtGuruUpdateMetode" class="control-label">Metode:</label>
							<form:input path="metode" cssClass="form-control" id="txtGuruUpdateMetode" placeholder="Type Name" />
						</div>
						<div class="form-group">
							<label for="txtGuruUpdateJumlahSiswa" class="control-label">Jumlah Siswa:</label>
							<form:select path="jumlahSiswa" cssClass="form-control" id="txtGuruUpdateJumlahSiswa" items="${lookUpJumlahSiswa}" itemValue="id" itemLabel="jmlSiswa" />
						</div>
						<div class="form-group">
							<label for="txtGuruUpdateKeaktifanSiswa" class="control-label">Keaktifan Siswa:</label>
							<form:select path="keaktifan" cssClass="form-control" id="txtGuruUpdateKeaktifanSiswa" items="${lookUpkeaktifanSiswa }" itemValue="id" itemLabel="jmlSiswa" />
						</div>
						<div class="form-group">
							<label for="txtGuruUpdateKondisiSekolah" class="control-label">Kondisi Sekolah:</label>
							<form:select path="kondisiSekolah" cssClass="form-control" id="txtGuruUpdateKondisiSekolah" items="${lookUpKondisiSekolah }" itemValue="id" itemLabel="kondisi" />
						</div>
						<div class="form-group">
							<label for="txtGuruUpdateKondisiKelas" class="control-label">Kondisi Kelas:</label>
							<form:select path="kondisiKelas" cssClass="form-control" id="txtGuruUpdateKondisiKelas" items="${lookUpKondisiKelas }" itemValue="id" itemLabel="kondisi" />
						</div>
						<div class="form-group">
							<label for="txtGuruUpdateFasilitas" class="control-label">Fasilitas:</label>
							<form:select path="fasilitas" cssClass="form-control" id="txtGuruUpdateFasilitas" items="${lookUpFasilitas }" itemValue="id" itemLabel="fasilitas" />
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
	<script type="text/javascript">
		$(document).ready(function() {
			
			// add active class every this page accessed
			$('#metode').addClass('active');
			
			// btnUpdate click event to show modal window and fill its field 
			$('.btnUpdate').click(function(e) {
				e.preventDefault();
				var url = $(this).attr("href");
				$.getJSON(url, function(data) {

					// unselect before select
					$('select[id^="txtUpdateJumlahSiswa"] option:selected').attr("selected",null);
					$('select[id^="txtUpdateKeaktifanSiswa"] option:selected').attr("selected",null);
					$('select[id^="txtUpdateKondisiSekolah"] option:selected').attr("selected",null);
					$('select[id^="txtUpdateKondisiKelas"] option:selected').attr("selected",null);
					$('select[id^="txtUpdateFasilitas"] option:selected').attr("selected",null);
					$('select[id^="txtUpdateKualitasPengajar"] option:selected').attr("selected",null);

					$('#lblUpdateId').val(data.id);
					$('#txtUpdateMetode').val(data.metode);
					$('select[id^="txtUpdateJumlahSiswa"] option[value="' + data.jumlahSiswa["id"] + '"]').attr("selected","selected");
					$('select[id^="txtUpdateKeaktifanSiswa"] option[value="' + data.keaktifan["id"] + '"]').attr("selected","selected");
					$('select[id^="txtUpdateKondisiSekolah"] option[value="' + data.kondisiSekolah["id"] + '"]').attr("selected","selected");
					$('select[id^="txtUpdateKondisiKelas"] option[value="' + data.kondisiKelas["id"] + '"]').attr("selected","selected");
					$('select[id^="txtUpdateFasilitas"] option[value="' + data.fasilitas["id"] + '"]').attr("selected","selected");
					$('select[id^="txtUpdateKualitasPengajar"] option[value="' + data.pengajar["id"] + '"]').attr("selected","selected");

				});
				$('#updateModal').modal();
			});
			
			// btnUpdateGuru 
			$('.btnUpdateGuru').click(function(e) {
				e.preventDefault();
				var url = $(this).attr("href");
				$.getJSON(url, function(data) {

					// unselect before select
					$('select[id^="txtGuruUpdateJumlahSiswa"] option:selected').attr("selected",null);
					$('select[id^="txtGuruUpdateKeaktifanSiswa"] option:selected').attr("selected",null);
					$('select[id^="txtGuruUpdateKondisiSekolah"] option:selected').attr("selected",null);
					$('select[id^="txtGuruUpdateKondisiKelas"] option:selected').attr("selected",null);
					$('select[id^="txtGuruUpdateFasilitas"] option:selected').attr("selected",null);

					$('#lblGuruUpdateId').val(data.id);
					$('#txtGuruUpdateMetode').val(data.metode);
					$('select[id^="txtGuruUpdateJumlahSiswa"] option[value="' + data.jumlahSiswa["id"] + '"]').attr("selected","selected");
					$('select[id^="txtGuruUpdateKeaktifanSiswa"] option[value="' + data.keaktifan["id"] + '"]').attr("selected","selected");
					$('select[id^="txtGuruUpdateKondisiSekolah"] option[value="' + data.kondisiSekolah["id"] + '"]').attr("selected","selected");
					$('select[id^="txtGuruUpdateKondisiKelas"] option[value="' + data.kondisiKelas["id"] + '"]').attr("selected","selected");
					$('select[id^="txtGuruUpdateFasilitas"] option[value="' + data.fasilitas["id"] + '"]').attr("selected","selected");

				});
				$('#updateModalGuru').modal();
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