<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/template/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Daftar Rangking</title>
<%@ include file="/WEB-INF/template/css.jsp"%>

</head>
<body>

	<div class="container">
		<%@ include file="/WEB-INF/template/navbar.jsp"%>
		
		<div class="panel panel-default">
			<div class="panel-heading"><h3 class="panel-title">Daftar Rangking:: Hasil Metode yang cocok berdasarkan bobot dan kriteria</h3></div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover table-condensed" style="font-size: 0.9em">
						<thead>
							<tr>
								<th width="5%">No.</th>
								<th>Tanggal</th>
								<th>Total</th>
								<th width="5%">Aksi</th>
							</tr>
						</thead>
		
						<tbody>
							<c:forEach items="${daftarRangking}" var="spk" varStatus="index">
								<tr>
									<td><c:out value="${index.count }" /></td>
									<td><c:out value="${spk.tanggal }" /></td>
									<td><c:out value="" /></td>
									<td>
										<a class="btn btn-xs btn-primary">
											<span class="glyphicon glyphicon-print"></span></a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
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
			$('#metode').addClass('active');
		});
	</script>
</body>
</html>