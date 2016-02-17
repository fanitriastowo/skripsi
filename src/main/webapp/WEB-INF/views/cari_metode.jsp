<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/template/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Pencarian Metode</title>

<%@ include file="/WEB-INF/template/css.jsp"%>
</head>
<body>
	<div class="container">

		<%@ include file="/WEB-INF/template/navbar.jsp"%>

		<form:form commandName="metodeSearchResult" action="${pageContext.request.contextPath }/hitung" method="post" cssClass="form-horizontal" id="cariForm">
		<div class="panel panel-default">
			<div class="panel-heading"><h3 class="panel-title">Hitung Metode Pembelajaran</h3></div>
			<div class="panel-body">
				
				<div class="form-group">
					<label for="txtCariMateriPengajaran" class="control-label">: Materi Pengajaran</label>
					<div class="col-sm-10">
						<form:select path="materiPengajaran" cssClass="form-control" id="txtCariMateriPengajaran" 
								 	 items="${lookUpMateriPengajaran }" itemValue="id" itemLabel="materi" />
					</div>
				</div>
				<div class="form-group">
					<label for="txtCariTujuanPengajaran" class="control-label">: Tujuan Pengajaran</label>
					<div class="col-sm-10">
						<form:select path="tujuanPengajaran" cssClass="form-control" id="txtCariTujuanPengajaran" 
									 items="${lookUpTujuanPengajaran }" itemValue="id" itemLabel="tujuan" />
					</div>
				</div>
				<div class="form-group">
					<label for="txtCariWaktuPembelajaran" class="control-label">: Waktu Pembelajaran</label>
					<div class="col-sm-10">
						<form:select path="waktuPembelajaran" cssClass="form-control" id="txtCariWaktuPembelajaran" 
									 items="${lookUpWaktuPembelajaran }" itemValue="id" itemLabel="waktu" />
					</div>
				</div>
				<div class="form-group">
					<label for="txtCariFasilitas" class="control-label">: Fasilitas</label>
					<div class="col-sm-10">
						<form:select path="fasilitas" cssClass="form-control" id="txtCariFasilitas" 
									 items="${lookUpFasilitas }" itemValue="id" itemLabel="fasilitas" />
					</div>
				</div>
				<div class="form-group">
					<label for="txtCariKemampuanGuru" class="control-label">: Kemampuan Guru</label>
					<div class="col-sm-10">
						<form:select path="kemampuanGuru" cssClass="form-control" id="txtCariKemampuanGuru" 
									 items="${lookUpKemampuanGuru }" itemValue="id" itemLabel="kemampuan" />
					</div>
				</div>
				<div class="form-group">
					<label for="txtCariJumlahSiswa" class="control-label">: Jumlah Siswa</label>
					<div class="col-sm-10">
						<form:select path="jumlahSiswa" cssClass="form-control" id="txtCariJumlahSiswa" 
									 items="${lookUpJumlahSiswa }" itemValue="id" itemLabel="jmlSiswa" />
					</div>
				</div>
				<div class="form-group">
					<label for="txtCariKemampuanSiswa" class="control-label">: Kemampuan Siswa</label>
					<div class="col-sm-10">
						<form:select path="kemampuanSiswa" cssClass="form-control" id="txtCariKemampuanSiswa" 
									 items="${lookUpKemampuanSiswa }" itemValue="id" itemLabel="kemampuan" />
					</div>
				</div>
					
			</div>
			<div class="panel-footer">
				<button type="submit" class="btn btn-primary">Hitung</button>
			</div>
			
			<div id="cari-result"></div>
		</div>
		</form:form>
		
	</div>

	<%@ include file="/WEB-INF/template/footer.jsp"%>
	<%@ include file="/WEB-INF/template/javascript.jsp"%>
	<script src='<spring:url value="/assets/js/jquery.validate.min.js"/>'></script>
	<script type="text/javascript">
		$(document).ready(function() {
			
			// add active class every this page accessed
			$('#pencarian').addClass('active');
			
			/*
			$("#cariForm").submit(function(event) {
				
				var materiPengajaran = $('#txtCariMateriPengajaran').val();
				var tujuanPengajaran = $('#txtCariTujuanPengajaran').val();
				var waktuPembelajaran = $('#txtCariWaktuPembelajaran').val();
				var fasilitas = $('#txtCariFasilitas').val();
				var kemampuanGuru = $('#txtCariKemampuanGuru').val();
				var jumlahSiswa = $('#txtCariJumlahSiswa').val(); 
				var kemampuanSiswa = $('#txtCariKemampuanSiswa').val();
				var json = {
							"materiPengajaran" : materiPengajaran,
							"tujuanPengajaran" : tujuanPengajaran,
							"waktuPembelajaran" : waktuPembelajaran,
							"fasilitas" : fasilitas,
							"kemampuanGuru" : kemampuanGuru,
							"jumlahSiswa" : jumlahSiswa,
							"kemampuanSiswa" : kemampuanSiswa
						   };
				$.post({
					data : JSON.stringify(json),
					type : $(this).attr('method'),
					url : $(this).attr('action'),
					success : function(response) {
						console.log(response);
						$('#cari-result').html(response);
					}
				});
				return false;
			});
			*/

		});
	</script>
</body>
</html>