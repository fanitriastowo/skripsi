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
		
		<h3 class="text-center">Daftar Metode</h3>
		<hr>
		
		<div class="panel panel-default">
			<div class="panel-heading"><h3 class="panel-title">Daftar Metode yang akan dilakukan dalam perhitungan</h3></div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover table-condensed" style="font-size: 0.9em">
						<thead>
							<tr>
								<th width="5%">No.</th>
								<th>Metode</th>
								<th>Jumlah Siswa</th>
								<th>Kondisi Kelas</th>
								<th>Keaktifan Siswa</th>
								<th>Kualitas Pengajar</th>
								<th>Fasilitas</th>
							</tr>
						</thead>
		
						<tbody>
							<c:forEach items="${metodes}" var="metode" varStatus="index">
								<tr>
									<td><c:out value="${index.count }" /></td>
									<td><c:out value="${metode.metode }" /></td>
									<td>
										<c:out value="${metode.jumlahSiswa.point }" />
											&nbsp;<a href="#" title='<c:out value="Jumlah Siswa ${metode.jumlahSiswa.jmlSiswa }" />'>
											<span class="fa fa-question fa-xs"></span></a>
									</td>
									<td>
										<c:out value="${metode.kondisi.point }" />
											&nbsp;<a href="#" title='<c:out value="Kondisi Kelas ${metode.kondisi.kondisi }" />'>
											<span class="fa fa-question fa-xs"></span></a>
									</td>
									<td>
										<c:out value="${metode.keaktifan.point }" />
											&nbsp;<a href="#" title='<c:out value="Jumlah siswa aktif ${metode.keaktifan.jmlSiswa }" />'>
											<span class="fa fa-question fa-xs"></span></a>
									</td>
									<td>
										<c:out value="${metode.pengajar.point }" />
											&nbsp;<a href="#" title='<c:out value="Kualitas Pengajar ${metode.pengajar.kualitas }" />'>
											<span class="fa fa-question fa-xs"></span></a>
									</td>
									<td>
										<c:out value="${metode.fasilitas.point }" />
											&nbsp;<a href="#" title='<c:out value="Fasilitas ${metode.fasilitas.fasilitas }" />'>
											<span class="fa fa-question fa-xs"></span></a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr class="info">
								<td>#</td>
								<td><strong>Bobot</strong></td>
								<td class="text-center" id="bJumlahSiswa"><c:out value="${tempBobot.jumlahSiswaBobot }" /></td>
								<td class="text-center" id="bKondisiKelas"><c:out value="${tempBobot.kondisiKelasBobot }" /></td>
								<td class="text-center" id="bKeaktifanSiswa"><c:out value="${tempBobot.keaktifanSiswaBobot }" /></td>
								<td class="text-center" id="bKualitasPengajar"><c:out value="${tempBobot.kualitasPengajarBobot }" /></td>
								<td class="text-center" id="bFasilitas"><c:out value="${tempBobot.fasilitasBobot }" /></td>
							</tr>
						</tfoot>
					</table>
				</div>	
			</div>
			<div class="panel-footer">
				<button class="btn btn-default" data-toggle="modal" data-target="#bobotModal">Bobot</button>
				<button class="btn btn-primary pull-right">Next</button>
			</div>
		</div>
	</div>
	
	<form:form commandName="bobotModel" action="${pageContext.request.contextPath }/bobot/ubah_bobot" cssClass="form-horizontal">
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
								<form:input path="jumlahSiswaBobot" cssClass="form-control slider"/>
							</div>
						</div>
						<div class="form-group">
							<label for="kondisiKelasBobot" class="col-sm-6 control-label">Kondisi Kelas:</label>
							<div class="col-sm-6">
								<form:input path="kondisiKelasBobot" cssClass="form-control slider"/>
							</div>
						</div>
						<div class="form-group">
							<label for="keaktifanSiswaBobot" class="col-sm-6 control-label">Keaktifan Siswa:</label>
							<div class="col-sm-6">
								<form:input path="keaktifanSiswaBobot" cssClass="form-control slider"/>
							</div>
						</div>
						<div class="form-group">
							<label for="kualitasPengajarBobot" class="col-sm-6 control-label">Kualitas Pengajar:</label>
							<div class="col-sm-6">
								<form:input path="kualitasPengajarBobot" cssClass="form-control slider"/>
							</div>
						</div>
						<div class="form-group">
							<label for="fasilitasBobot" class="col-sm-6 control-label">Fasilitas:</label>
							<div class="col-sm-6">
								<form:input path="fasilitasBobot" cssClass="form-control slider"/>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<input type="submit" class="btn btn-primary" value="Next" />
					</div>
				</div>
			</div>
		</div>
	</form:form>
	
	<%@ include file="/WEB-INF/template/footer.jsp"%>
	<%@ include file="/WEB-INF/template/javascript.jsp"%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap-slider.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#spk').addClass('active');
			
			$('#jumlahSiswaBobot').slider({
				min : 1,
				max : 5,
				step : 1,
				orientation : 'horizontal',
				value : $("#bJumlahSiswa").html(),
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
			
		});
	</script>
</body>
</html>