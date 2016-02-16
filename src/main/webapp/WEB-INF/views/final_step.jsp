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
								<th>Vector S</th>
								<th>Jumlah Vector S</th>
								<th width="10%">Vector V</th>
							</tr>
						</thead>
		
						<tbody>
							<c:forEach items="${daftarRangking}" var="spk" varStatus="index">
								<tr>
									<td><c:out value="${index.count }" /></td>
									<td><c:out value="${spk.namaMetode }" /></td>
									<td><c:out value="${spk.materiPengajaran }" /></td>
									<td><c:out value="${spk.tujuanPengajaran }" /></td>
									<td><c:out value="${spk.waktuPembelajaran }" /></td>
									<td><c:out value="${spk.fasilitas }" /></td>
									<td><c:out value="${spk.kemampuanGuru }" /></td>
									<td><c:out value="${spk.jumlahSiswa }" /></td>
									<td><c:out value="${spk.kemampuanSiswa }" /></td>
									<td><c:out value="${spk.vectorS }" /></td>
									<td><c:out value="${spk.jumlahVectorS }" /></td>
									<td><c:out value="${spk.vectorV }" /></td>
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