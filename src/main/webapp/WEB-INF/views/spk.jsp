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

</head>
<body>

	<div class="container">
		<%@ include file="/WEB-INF/template/navbar.jsp"%>
		
		<h3 class="text-center">Daftar Metode</h3>
		<hr>
		
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
								&nbsp;<a href="#" title='<c:out value="Jumlah Siswa ${metode.jumlahSiswa.jmlSiswa }" />'><span class="fa fa-question fa-xs"></span></a>
							</td>
							<td>
								<c:out value="${metode.kondisi.point }" />
								&nbsp;<a href="#" title='<c:out value="Kondisi Kelas ${metode.kondisi.kondisi }" />'><span class="fa fa-question fa-xs"></span></a>
							</td>
							<td>
								<c:out value="${metode.keaktifan.point }" />
								&nbsp;<a href="#" title='<c:out value="Jumlah siswa aktif ${metode.keaktifan.jmlSiswa }" />'><span class="fa fa-question fa-xs"></span></a>
							</td>
							<td>
								<c:out value="${metode.pengajar.point }" />
								&nbsp;<a href="#" title='<c:out value="Kualitas Pengajar ${metode.pengajar.kualitas }" />'><span class="fa fa-question fa-xs"></span></a>
							</td>
							<td>
								<c:out value="${metode.fasilitas.point }" />
								&nbsp;<a href="#" title='<c:out value="Fasilitas ${metode.fasilitas.fasilitas }" />'><span class="fa fa-question fa-xs"></span></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<%@ include file="/WEB-INF/template/footer.jsp"%>
	<%@ include file="/WEB-INF/template/javascript.jsp"%>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#spk').addClass('active');
		});
	</script>
</body>
</html>