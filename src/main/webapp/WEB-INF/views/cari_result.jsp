<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/template/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Hasil Perhitungan Metode</title>

<%@ include file="/WEB-INF/template/css.jsp"%>
</head>
<body>
	<div class="container">

		<%@ include file="/WEB-INF/template/navbar.jsp"%>

		<form:form commandName="metodeSearchResult" action="${pageContext.request.contextPath }/cari" method="post" cssClass="form-horizontal" id="cariForm">
		<div class="panel panel-default">
			<div class="panel-heading"><h3 class="panel-title">Hasil Perhitungan Metode Pembelajaran</h3></div>
			<div class="panel-body">
				<table class="table table-stripped table-bordered">
					<thead>
						<tr>
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
						<tr>
							<td><c:out value="${metode.metode }" /></td>
							<td><c:out value="${metode.materiPengajaran.materi }" /></td>
							<td><c:out value="${metode.tujuanPengajaran.tujuan }" /></td>
							<td><c:out value="${metode.waktuPembelajaran.waktu }" /></td>
							<td><c:out value="${metode.fasilitas.fasilitas }" /></td>
							<td><c:out value="${metode.kemampuanGuru.kemampuan }" /></td>
							<td><c:out value="${metode.jumlahSiswa.jmlSiswa }" /></td>
							<td><c:out value="${metode.kemampuanSiswa.kemampuan }" /></td>
						</tr>
					</tbody>
				</table>
			</div>
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
			
		});
	</script>
</body>
</html>