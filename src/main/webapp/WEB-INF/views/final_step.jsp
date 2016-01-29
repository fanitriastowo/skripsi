<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/template/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Final Step</title>
<%@ include file="/WEB-INF/template/css.jsp"%>

</head>
<body>

	<div class="container">
		<%@ include file="/WEB-INF/template/navbar.jsp"%>
		
		<div class="panel panel-default">
			<div class="panel-heading"><h3 class="panel-title">Final Step :: Hasil Metode yang cocok berdasarkan bobot dan kriteria</h3></div>
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
								<th>Vector S</th>
								<th>Jumlah Vector S</th>
								<th width="10%">Vector V</th>
							</tr>
						</thead>
		
						<tbody>
							<c:forEach items="${Spk}" var="spk" varStatus="index">
								<tr>
									<td><c:out value="${index.count }" /></td>
									<td><c:out value="${spk.namaMetode }" /></td>
									<td><c:out value="${spk.jumlahSiswa }" /></td>
									<td><c:out value="${spk.keaktifanSiswa }" /></td>
									<td><c:out value="${spk.kondisiSekolah }" /></td>
									<td><c:out value="${spk.kondisiKelas }" /></td>
									<td><c:out value="${spk.fasilitas }" /></td>
									<td><c:out value="${spk.kualitasPengajar }" /></td>
									<td><c:out value="${spk.vectorS }" /></td>
									<td><c:out value="${spk.jumlahVectorS }" /></td>
									<td><c:out value="${spk.vectorV }" /></td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr class="info">
								<td>#</td>
								<td><strong>Bobot</strong></td>
								<td class="text-center" ><c:out value="${tempBobot.jumlahSiswaBobot }" /></td>
								<td class="text-center" ><c:out value="${tempBobot.keaktifanSiswaBobot }" /></td>
								<td class="text-center" ><c:out value="${tempBobot.kondisiKelasBobot }" /></td>
								<td class="text-center" ><c:out value="${tempBobot.kondisiSekolahBobot }" /></td>
								<td class="text-center" ><c:out value="${tempBobot.kualitasPengajarBobot }" /></td>
								<td class="text-center" ><c:out value="${tempBobot.fasilitasBobot }" /></td>
							</tr>
							<tr class="info">
								<td>#</td>
								<td><strong>Bobot Ter - Normalisasi</strong></td>
								<td class="text-center" ><c:out value="${tempBobot.nJumlahSiswaBobot }" /></td>
								<td class="text-center" ><c:out value="${tempBobot.nKeaktifanSiswaBobot }" /></td>
								<td class="text-center" ><c:out value="${tempBobot.nKondisiSekolahBobot }" /></td>
								<td class="text-center" ><c:out value="${tempBobot.nKondisiKelasBobot }" /></td>
								<td class="text-center" ><c:out value="${tempBobot.nKualitasPengajarBobot }" /></td>
								<td class="text-center" ><c:out value="${tempBobot.nFasilitasBobot }" /></td>
							</tr>
						</tfoot>
					</table>
					
				</div>	
			</div>
			<div class="panel-footer">
				<p>* Hasil perhitungan telah tersimpan ke dalam Database. Anda dapat mencetak hasil perhitungan untuk keperluan laporan</p>
			</div>
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