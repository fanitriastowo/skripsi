<%@ include file="taglib.jsp"%>
<div class="masthead">
	<h3 class="text-muted">SPK Menentukan Metode Pembelajaran</h3>
	<nav>
		<ul class="nav nav-justified">
			<li id="home"><a href=' <spring:url value="/" />	'>Home</a></li>
			
			<security:authorize access="hasRole('ROLE_GURU')">
			<li id="pencarian"><a href=' <spring:url value="/cari_metode" />'>Hitung</a></li>
			</security:authorize>
			
			<security:authorize access="hasRole('ROLE_ADMIN')">
				<li id="metode"><a href=' <spring:url value="/metode" />'>Metode</a></li>
				<li id="kriteria" class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
					   aria-expanded="false">Kriteria&nbsp;<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href=' <spring:url value="/materi_pengajaran" />'>Materi Pengajaran</a></li>
						<li><a href=' <spring:url value="/tujuan_pengajaran" />'>Tujuan Pengajaran</a></li>
						<li><a href=' <spring:url value="/waktu_pembelajaran" />'>Waktu Pembelajaran</a></li>
						<li><a href=' <spring:url value="/fasilitas" />'>Fasilitas</a></li>
						<li><a href=' <spring:url value="/kemampuan_guru" />'>Kemampuan Guru</a></li>
						<li><a href=' <spring:url value="/jumlah_siswa" />'>Jumlah Siswa</a></li>
						<li><a href=' <spring:url value="/kemampuan_siswa" />'>Kemampuan Siswa</a></li>
					</ul>
				</li>
	
				<li id="user"><a href=' <spring:url value="/user" />'>User</a></li>
				<li id="spk"><a href=' <spring:url value="/spk" />'>Hitung SPK</a></li>
			</security:authorize>

			<security:authorize access="!isAuthenticated()">
				<li id="login"><a href=' <spring:url value="/login" />'>Login</a></li>
			</security:authorize>

			<security:authorize access="isAuthenticated()">
				<li><a href=' <spring:url value="/logout" /> '>Logout</a></li>
			</security:authorize>
		</ul>
	</nav>
</div>