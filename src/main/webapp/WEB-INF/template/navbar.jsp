<%@ include file="taglib.jsp"%>
<div class="masthead">
	<h3 class="text-muted">SPK Menentukan Metode Pembelajaran</h3>
	<nav>
		<ul class="nav nav-justified">
			<li id="home"><a href=' <spring:url value="/" />	'>Home</a></li>
			<li id="metode"><a href=' <spring:url value="/metode" />'>Metode</a></li>

			<li id="kriteria" class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
				aria-expanded="false"> Kriteria&nbsp;<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href=' <spring:url value="/jumlah_siswa" />'>Jumlah Siswa</a></li>
					<li><a href=' <spring:url value="/kondisi" /> '>Kondisi Kelas</a></li>
					<li><a href=' <spring:url value="/keaktifan" />	'>Keaktifan Siswa</a></li>
					<li><a href=' <spring:url value="/pengajar" />	'>Pengajar</a></li>
					<li><a href=' <spring:url value="/fasilitas" />	'>Fasilitas</a></li>
				</ul></li>

			<li id="user"><a href=' <spring:url value="/user" />'>User</a></li>
			<li id="spk"><a href=' <spring:url value="/spk" />'>Hitung SPK</a></li>

			<security:authorize access="!isAuthenticated()">
				<li id="login"><a href=' <spring:url value="/login" />'>Login</a></li>
			</security:authorize>

			<security:authorize access="isAuthenticated()">
				<li><a href=' <spring:url value="/logout" /> '>Logout</a></li>
			</security:authorize>
		</ul>
	</nav>
</div>