<%@ include file="taglib.jsp" %>
<div class="masthead">
	<h3 class="text-muted">SPK Menentukan Metode Pembelajaran</h3>
	<nav>
		<ul class="nav nav-justified">
			<li id="home"><a 			href=' <spring:url value="/" />				'>Home</a></li>
			
			<li id="metode"><a 			href=' <spring:url value="/metode" />		'>Metode</a></li>
			<li id="kondisi_kelas"><a 	href=' <spring:url value="/kondisi" />		'>Kondisi Kelas</a></li>
			<li id="keaktifan_siswa"><a href=' <spring:url value="/keaktifan" />	'>Keaktifan Siswa</a></li>
			<li id="pengajar"><a 		href=' <spring:url value="/pengajar" />		'>Pengajar</a></li>
			<li id="fasilitas"><a 		href=' <spring:url value="/fasilitas" />	'>Fasilitas</a></li>
			<li id="user"><a 			href=' <spring:url value="/user" />			'>User</a></li>
			<li id="hitung"><a 			href='										'>Hitung</a> </li>
			
			<security:authorize access="!isAuthenticated()">
				<li id="login"><a href=' <spring:url value="/login" /> '>Login</a></li>
			</security:authorize>
			
			<security:authorize access="isAuthenticated()">
				<li><a href=' <spring:url value="/logout" /> '>Logout</a></li>
			</security:authorize>
		</ul>
	</nav>
</div>