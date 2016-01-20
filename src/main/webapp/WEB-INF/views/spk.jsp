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
		
		<h3>Daftar Metode</h3>
		
		<div class="table-responsive">
			<table class="table table-hovered table-bordered table-striped">
				
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