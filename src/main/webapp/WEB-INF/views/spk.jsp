<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/template/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Halaman Perhitungan SPK</title>
<%@ include file="/WEB-INF/template/css.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-slider.css">

</head>
<body>

	<div class="container">
		<%@ include file="/WEB-INF/template/navbar.jsp"%>
		
		<div class="panel panel-default">
			<div class="panel-heading"><h3 class="panel-title">Daftar Metode yang akan dilakukan perhitungan</h3></div>
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
							</tr>
						</thead>
		
						<tbody>
							<c:forEach items="${metodes}" var="metode" varStatus="index">
								<tr>
									<td><c:out value="${index.count }" /></td>
									<td><c:out value="${metode.metode }" /></td>
									<td>
										<c:out value="${metode.materiPengajaran.point }" />
											&nbsp;<a href="#" title='<c:out value="${metode.materiPengajaran.materi }" />'>
											<span class="fa fa-question fa-xs"></span></a>
									</td>
									<td>
										<c:out value="${metode.tujuanPengajaran.point }" />
											&nbsp;<a href="#" title='<c:out value="${metode.tujuanPengajaran.tujuan }" />'>
											<span class="fa fa-question fa-xs"></span></a>
									</td>
									<td>
										<c:out value="${metode.waktuPembelajaran.point }" />
											&nbsp;<a href="#" title='<c:out value="${metode.waktuPembelajaran.waktu }" />'>
											<span class="fa fa-question fa-xs"></span></a>
									</td>
									<td>
										<c:out value="${metode.fasilitas.point }" />
											&nbsp;<a href="#" title='<c:out value="${metode.fasilitas.fasilitas }" />'>
											<span class="fa fa-question fa-xs"></span></a>
									</td>
									<td>
										<c:out value="${metode.kemampuanGuru.point }" />
											&nbsp;<a href="#" title='<c:out value="${metode.kemampuanGuru.kemampuan }" />'>
											<span class="fa fa-question fa-xs"></span></a>
									</td>
									<td>
										<c:out value="${metode.jumlahSiswa.point }" />
											&nbsp;<a href="#" title='<c:out value="${metode.jumlahSiswa.jmlSiswa }" />'>
											<span class="fa fa-question fa-xs"></span></a>
									</td>
									<td>
										<c:out value="${metode.kemampuanSiswa.point }" />
											&nbsp;<a href="#" title='<c:out value="${metode.kemampuanSiswa.kemampuan }" />'>
											<span class="fa fa-question fa-xs"></span></a>
									</td>
									
								</tr>
							</c:forEach>
						</tbody>
						<tfoot style="font-size: 1.2em">
							<tr class="info">
								<td>#</td>
								<td><strong>Bobot</strong></td>
								<td class="text-center" id="bMateriPengajaran"><c:out value="${bobot.materiPengajaran }" /></td>
								<td class="text-center" id="bTujuanPengajaran"><c:out value="${bobot.tujuanPengajaran }" /></td>
								<td class="text-center" id="bWaktuPengajaran"><c:out value="${bobot.waktuPembelajaran }" /></td>
								<td class="text-center" id="bFasilitas"><c:out value="${bobot.fasilitas }" /></td>
								<td class="text-center" id="bKemampuanGuru"><c:out value="${bobot.kemampuanGuru }" /></td>
								<td class="text-center" id="bJumlahSiswa"><c:out value="${bobot.jumlahSiswa }" /></td>
								<td class="text-center" id="bKemampuanSiswa"><c:out value="${bobot.kemampuanSiswa }" /></td>
							</tr>
							<tr class="info">
								<td>#</td>
								<td><strong>Bobot Ter - Normalisasi</strong></td>
								<td class="text-center" ><c:out value="${bobot.nMateriPengajaran }" /></td>
								<td class="text-center" ><c:out value="${bobot.nTujuanPengajaran }" /></td>
								<td class="text-center" ><c:out value="${bobot.nWaktuPembelajaran }" /></td>
								<td class="text-center" ><c:out value="${bobot.nFasilitas }" /></td>
								<td class="text-center" ><c:out value="${bobot.nKemampuanGuru }" /></td>
								<td class="text-center" ><c:out value="${bobot.nJumlahSiswa }" /></td>
								<td class="text-center" ><c:out value="${bobot.nKemampuanSiswa }" /></td>
							</tr>
						</tfoot>
					</table>
				</div>	
			</div>
			<div class="panel-footer">
				<button class="btn btn-default" data-toggle="modal" data-target="#bobotModal">Bobot</button>
				<a class="btn btn-primary pull-right" href='<spring:url value="/spk/step_1" />'>Next</a>
			</div>
		</div>
	</div>
	
	<%-- 
	<form:form commandName="bobotModel" action="${pageContext.request.contextPath }/spk/ubah_bobot" cssClass="form-horizontal">
		<div class="modal fade" id="bobotModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">Tentukan Bobot Kriteria</h4>
					</div>
					<div class="modal-body">
						<form:hidden path="id" />
						<div class="form-group">
							<label for="jumlahSiswaBobot" class="col-sm-6 control-label">Jumlah Siswa:</label>
							<div class="col-sm-6">
								<form:input path="jumlahSiswaBobot" cssClass="form-control slider" value="${tempBobot.jumlahSiswaBobot }" />
							</div>
						</div>
						<div class="form-group">
							<label for="keaktifanSiswaBobot" class="col-sm-6 control-label">Keaktifan Siswa:</label>
							<div class="col-sm-6">
								<form:input path="keaktifanSiswaBobot" cssClass="form-control slider" value="${tempBobot.keaktifanSiswaBobot }" />
							</div>
						</div>
						<div class="form-group">
							<label for="kondisiSekolahBobot" class="col-sm-6 control-label">Kondisi Sekolah:</label>
							<div class="col-sm-6">
								<form:input path="kondisiSekolahBobot" cssClass="form-control slider" value="${tempBobot.kondisiSekolahBobot }" />
							</div>
						</div>
						<div class="form-group">
							<label for="kondisiKelasBobot" class="col-sm-6 control-label">Kondisi Kelas:</label>
							<div class="col-sm-6">
								<form:input path="kondisiKelasBobot" cssClass="form-control slider" value="${tempBobot.kondisiKelasBobot }" />
							</div>
						</div>
						<div class="form-group">
							<label for="fasilitasBobot" class="col-sm-6 control-label">Fasilitas:</label>
							<div class="col-sm-6">
								<form:input path="fasilitasBobot" cssClass="form-control slider" value="${tempBobot.fasilitasBobot }" />
							</div>
						</div>
						<div class="form-group">
							<label for="kualitasPengajarBobot" class="col-sm-6 control-label">Kualitas Pengajar:</label>
							<div class="col-sm-6">
								<form:input path="kualitasPengajarBobot" cssClass="form-control slider" value="${tempBobot.kualitasPengajarBobot }" />
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<input type="submit" class="btn btn-primary" value="Simpan" />
					</div>
				</div>
			</div>
		</div>
	</form:form>
	--%>
	
	<%@ include file="/WEB-INF/template/footer.jsp"%>
	<%@ include file="/WEB-INF/template/javascript.jsp"%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap-slider.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#spk').addClass('active');
			
			/*
			$('#jumlahSiswaBobot').slider({
				min : 1,
				max : 5,
				step : 1,
				orientation : 'horizontal',
				value : $("#bJumlahSiswa").html(),
				selection : 'before',
				tooltip : 'show'
			});
			
			$('#kondisiSekolahBobot').slider({
				min : 1,
				max : 5,
				step : 1,
				orientation : 'horizontal',
				value : $("#bKondisiSekolah").html(),
				selection : 'before',
				tooltip : 'show'
			});
			
			
			$('#kondisiKelasBobot').slider({
				min : 1,
				max : 5,
				step : 1,
				orientation : 'horizontal',
				value : $("#bKondisiKelas").html(),
				selection : 'before',
				tooltip : 'show'
			});
			
			$('#keaktifanSiswaBobot').slider({
				min : 1,
				max : 5,
				step : 1,
				orientation : 'horizontal',
				value : $("#bKeaktifanSiswa").html(),
				selection : 'before',
				tooltip : 'show'
			});
			
			$('#kualitasPengajarBobot').slider({
				min : 1,
				max : 5,
				step : 1,
				orientation : 'horizontal',
				value : $("#bKualitasPengajar").html(),
				selection : 'before',
				tooltip : 'show'
			});
			
			$('#fasilitasBobot').slider({
				min : 1,
				max : 5,
				step : 1,
				orientation : 'horizontal',
				value : $("#bFasilitas").html(),
				selection : 'before',
				tooltip : 'show'
			});
			*/
			
		});
	</script>
</body>
</html>