<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/template/taglib.jsp"%>

<fmt:parseNumber integerOnly="true" type="number" value="${bobot.materiPengajaran }" var="materiPengajaran" />
<fmt:parseNumber integerOnly="true" type="number" value="${bobot.tujuanPengajaran }" var="tujuanPengajaran" />
<fmt:parseNumber integerOnly="true" type="number" value="${bobot.waktuPembelajaran }" var="waktuPembelajaran" />
<fmt:parseNumber integerOnly="true" type="number" value="${bobot.fasilitas }" var="fasilitas" />
<fmt:parseNumber integerOnly="true" type="number" value="${bobot.kemampuanGuru }" var="kemampuanGuru" />
<fmt:parseNumber integerOnly="true" type="number" value="${bobot.jumlahSiswa }" var="jumlahSiswa" />
<fmt:parseNumber integerOnly="true" type="number" value="${bobot.kemampuanSiswa }" var="kemampuanSiswa" />

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Halaman Perhitungan SPK</title>
<%@ include file="/WEB-INF/template/css.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-slider.min.css">

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
								<td class="text-center" id="bMateriPengajaran"><c:out value="${materiPengajaran }" /></td>
								<td class="text-center" id="bTujuanPengajaran"><c:out value="${tujuanPengajaran }" /></td>
								<td class="text-center" id="bWaktuPengajaran"><c:out value="${waktuPembelajaran }" /></td>
								<td class="text-center" id="bFasilitas"><c:out value="${fasilitas }" /></td>
								<td class="text-center" id="bKemampuanGuru"><c:out value="${kemampuanGuru }" /></td>
								<td class="text-center" id="bJumlahSiswa"><c:out value="${jumlahSiswa }" /></td>
								<td class="text-center" id="bKemampuanSiswa"><c:out value="${kemampuanSiswa }" /></td>
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
							<label for="materiPengajaran" class="col-sm-6 control-label">Materi Pengajaran</label>
							<div class="col-sm-6">
								<form:input path="materiPengajaran" cssClass="form-control" value="${materiPengajaran }" data-slider-min="1" data-slider-max="5" data-slider-step="1" data-slider-value="${materiPengajaran}"/>
							</div>
						</div>
						<div class="form-group">
							<label for="tujuanPengajaran" class="col-sm-6 control-label">Tujuan Pengajaran</label>
							<div class="col-sm-6">
								<form:input path="tujuanPengajaran" cssClass="form-control" value="${tujuanPengajaran }" data-slider-min="1" data-slider-max="5" data-slider-step="1" data-slider-value="${tujuanPengajaran}"/>
							</div>
						</div>
						<div class="form-group">
							<label for="waktuPembelajaran" class="col-sm-6 control-label">Waktu Pembelajaran</label>
							<div class="col-sm-6">
								<form:input path="waktuPembelajaran" cssClass="form-control" value="${waktuPembelajaran }" data-slider-min="1" data-slider-max="5" data-slider-step="1" data-slider-value="${waktuPembelajaran}"/>
							</div>
						</div>
						<div class="form-group">
							<label for="fasilitas" class="col-sm-6 control-label">Fasilitas</label>
							<div class="col-sm-6">
								<form:input path="fasilitas" cssClass="form-control" value="${fasilitas }" data-slider-min="1" data-slider-max="5" data-slider-step="1" data-slider-value="${fasilitas}"/>
							</div>
						</div>
						<div class="form-group">
							<label for="kemampuanGuru" class="col-sm-6 control-label">Kemampuan Guru</label>
							<div class="col-sm-6">
								<form:input path="kemampuanGuru" cssClass="form-control" value="${kemampuanGuru }" data-slider-min="1" data-slider-max="5" data-slider-step="1" data-slider-value="${kemampuanGuru}"/>
							</div>
						</div>
						<div class="form-group">
							<label for="jumlahSiswa" class="col-sm-6 control-label">Jumlah Siswa</label>
							<div class="col-sm-6">
								<form:input path="jumlahSiswa" cssClass="form-control" value="${jumlahSiswa }" data-slider-min="1" data-slider-max="5" data-slider-step="1" data-slider-value="${jumlahSiswa}"/>
							</div>
						</div>
						<div class="form-group">
							<label for="kemampuanSiswa" class="col-sm-6 control-label">Kemampuan Siswa</label>
							<div class="col-sm-6">
								<form:input path="kemampuanSiswa" cssClass="form-control" value="${kemampuanSiswa }" data-slider-min="1" data-slider-max="5" data-slider-step="1" data-slider-value="${kemampuanSiswa}"/>
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
	
	<%@ include file="/WEB-INF/template/footer.jsp"%>
	<%@ include file="/WEB-INF/template/javascript.jsp"%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap-slider.min.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#spk').addClass('active');
			$('#materiPengajaran').slider();
			$('#tujuanPengajaran').slider();
			$('#waktuPembelajaran').slider();
			$('#fasilitas').slider();
			$('#kemampuanGuru').slider();
			$('#jumlahSiswa').slider();
			$('#kemampuanSiswa').slider();
		});
	</script>
</body>
</html>