package com.skripsi.beni.apps.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.Bobot;
import com.skripsi.beni.apps.entity.Metode;
import com.skripsi.beni.apps.entity.Role;
import com.skripsi.beni.apps.entity.User;
import com.skripsi.beni.apps.entity.kriteria.Fasilitas;
import com.skripsi.beni.apps.entity.kriteria.JumlahSiswa;
import com.skripsi.beni.apps.entity.kriteria.KemampuanGuru;
import com.skripsi.beni.apps.entity.kriteria.KemampuanSiswa;
import com.skripsi.beni.apps.entity.kriteria.MateriPengajaran;
import com.skripsi.beni.apps.entity.kriteria.TujuanPengajaran;
import com.skripsi.beni.apps.entity.kriteria.WaktuPembelajaran;
import com.skripsi.beni.apps.repository.BobotRepository;
import com.skripsi.beni.apps.repository.FasilitasRepository;
import com.skripsi.beni.apps.repository.JumlahSiswaRepository;
import com.skripsi.beni.apps.repository.KemampuanGuruRepository;
import com.skripsi.beni.apps.repository.KemampuanSiswaRepository;
import com.skripsi.beni.apps.repository.MateriPengajaranRepository;
import com.skripsi.beni.apps.repository.MetodeRepository;
import com.skripsi.beni.apps.repository.RoleRepository;
import com.skripsi.beni.apps.repository.TujuanPengajaranRepository;
import com.skripsi.beni.apps.repository.UserRepository;
import com.skripsi.beni.apps.repository.WaktuPembelajaranRepository;

@Service
@Transactional
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MetodeRepository metodeRepository;

	@Autowired
	private MateriPengajaranRepository materiPengajaranRepository;
	
	@Autowired
	private TujuanPengajaranRepository tujuanPengajaranRepository;
	
	@Autowired
	private WaktuPembelajaranRepository waktuPembelajaranRepository;
	
	@Autowired
	private FasilitasRepository fasilitasRepository;
	
	@Autowired
	private KemampuanGuruRepository kemampuanGuruRepository;

	@Autowired
	private JumlahSiswaRepository jumlahSiswaRepository;
	
	@Autowired
	private KemampuanSiswaRepository kemampuanSiswaRepository;

	@Autowired
	private BobotRepository bobotRepository;

	@PostConstruct
	public void afterPropertiesSet() throws Exception {
	    
	    if(roleRepository.findOneByName("ROLE_ADMIN") != null) {
	        return;
	    }

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		/**
		 * Inisial Table Bobot
		 */
		// ==================================== //
		Double jumlahSiswa = 3D;
		Double fasilitas = 3D;
		Double kemampuanSiswa = 4D;
		Double kemampuanGuru = 5D;
		Double materiPengajaran = 3D;
		Double tujuanPengajaran = 4D;
		Double waktuPembelajaran = 3D;
		Double jumlahBobot = jumlahSiswa + fasilitas + kemampuanSiswa + kemampuanGuru + materiPengajaran + tujuanPengajaran + waktuPembelajaran;

		Double nJumlahSiswa = jumlahSiswa / jumlahBobot;
		Double nFasilitas = fasilitas / jumlahBobot;
		Double nKemampuanSiswa = kemampuanSiswa / jumlahBobot;
		Double nKemampuanGuru = kemampuanGuru / jumlahBobot;
		Double nMateriPengajaran = materiPengajaran / jumlahBobot;
		Double nTujuanPengajaran = tujuanPengajaran / jumlahBobot;
		Double nWaktuPembelajaran = waktuPembelajaran / jumlahBobot;

		Bobot bobotBaru = new Bobot();
		bobotBaru.setId("bobot");
		bobotBaru.setJumlahSiswa(jumlahSiswa);
		bobotBaru.setFasilitas(fasilitas);
		bobotBaru.setKemampuanSiswa(kemampuanSiswa);
		bobotBaru.setKemampuanGuru(kemampuanGuru);
		bobotBaru.setMateriPengajaran(materiPengajaran);
		bobotBaru.setTujuanPengajaran(tujuanPengajaran);
		bobotBaru.setWaktuPembelajaran(waktuPembelajaran);

		bobotBaru.setnJumlahSiswa(nJumlahSiswa);
		bobotBaru.setnFasilitas(nFasilitas);
		bobotBaru.setnKemampuanSiswa(nKemampuanSiswa);
		bobotBaru.setnKemampuanGuru(nKemampuanGuru);
		bobotBaru.setnMateriPengajaran(nMateriPengajaran);
		bobotBaru.setnTujuanPengajaran(nTujuanPengajaran);
		bobotBaru.setnWaktuPembelajaran(nWaktuPembelajaran);

		bobotRepository.save(bobotBaru);

		// ==================================== //

		/**
		 * Inisial Table Role
		 */
		// ==================================== //
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);

		Role roleGuru = new Role();
		roleGuru.setName("ROLE_GURU");
		roleRepository.save(roleGuru);
		// ==================================== //

		/**
		 * Inisial Table User
		 */
		// ==================================================== //
		// User Admin
		User userAdmin = new User();
		userAdmin.setUsername("admin");
		userAdmin.setPassword(encoder.encode("admin"));
		userAdmin.setNamaLengkap("Administrator");
		userAdmin.setNoTelp("085291070216");
		userAdmin.setEnabled(true);
		userAdmin.setRole(roleAdmin);
		userRepository.save(userAdmin);

		// User Guru
		User userLain = new User();
		userLain.setUsername("guru");
		userLain.setPassword(encoder.encode("guru"));
		userLain.setNamaLengkap("Guru");
		userLain.setNoTelp("999");
		userLain.setEnabled(true);
		userLain.setRole(roleGuru);
		userRepository.save(userLain);
		// ==================================================== //

		/**
		 * Inisial Table Materi Pengajaran
		 */
		// ====================================================== //
		MateriPengajaran materiSulit = new MateriPengajaran();
		materiSulit.setMateri("Sulit");
		materiSulit.setPoint(50D);
		materiPengajaranRepository.save(materiSulit);

		MateriPengajaran materiSedang = new MateriPengajaran();
		materiSedang.setMateri("Sedang");
		materiSedang.setPoint(45D);
		materiPengajaranRepository.save(materiSedang);

		MateriPengajaran materiMudah = new MateriPengajaran();
		materiMudah.setMateri("Mudah");
		materiMudah.setPoint(40D);
		materiPengajaranRepository.save(materiMudah);
		// ====================================================== //

		/**
		 * Inisial Table Tujuan Pengajaran
		 */
		// ====================================================== //
		TujuanPengajaran tujuanPenyampaianPesan = new TujuanPengajaran();
		tujuanPenyampaianPesan.setTujuan("Penyampaian Pesan");
		tujuanPenyampaianPesan.setPoint(50D);
		tujuanPengajaranRepository.save(tujuanPenyampaianPesan);
		
		TujuanPengajaran tujuanPengorganisasianSiswa = new TujuanPengajaran();
		tujuanPengorganisasianSiswa.setTujuan("Pengorganisasian Siswa");
		tujuanPengorganisasianSiswa.setPoint(45D);
		tujuanPengajaranRepository.save(tujuanPengorganisasianSiswa);
		
		
		TujuanPengajaran tujuanPendekatanPengajaran = new TujuanPengajaran();
		tujuanPendekatanPengajaran.setTujuan("Pendekatan Pengajaran");
		tujuanPendekatanPengajaran.setPoint(40D);
		tujuanPengajaranRepository.save(tujuanPendekatanPengajaran);
		
		// ====================================================== //

		/**
		 * Inisial Table Waktu Pembelajaran
		 */
		// ====================================================== //
		WaktuPembelajaran waktuSedikit = new WaktuPembelajaran();
		waktuSedikit.setWaktu("Sedikit / Singkat bisa dilakukan");
		waktuSedikit.setPoint(30D);
		waktuPembelajaranRepository.save(waktuSedikit);
		
		WaktuPembelajaran waktuBanyak = new WaktuPembelajaran();
		waktuBanyak.setWaktu("Banyak");
		waktuBanyak.setPoint(50D);
		waktuPembelajaranRepository.save(waktuBanyak);
		
		// ====================================================== //
		
		/**
		 * Inisial table fasilitas
		 */
		// ======================================================= //
		Fasilitas fasilitasPerlu = new Fasilitas();
		fasilitasPerlu.setFasilitas("Perlu");
		fasilitasPerlu.setPoint(50D);
		fasilitasRepository.save(fasilitasPerlu);

		Fasilitas fasilitasTidakPerlu = new Fasilitas();
		fasilitasTidakPerlu.setFasilitas("Tidak Perlu");
		fasilitasTidakPerlu.setPoint(30D);
		fasilitasRepository.save(fasilitasTidakPerlu);
		
		// ======================================================= //
		
		/**
		 * Inisial Table Kemampuan Guru
		 */
		// ====================================================== //
		KemampuanGuru kemampuanGuruSangatBaik = new KemampuanGuru();
		kemampuanGuruSangatBaik.setKemampuan("Sangat Baik");
		kemampuanGuruSangatBaik.setPoint(50D);
		kemampuanGuruRepository.save(kemampuanGuruSangatBaik);
		
		KemampuanGuru kemampuanGuruBaik = new KemampuanGuru();
		kemampuanGuruBaik.setKemampuan("Baik");
		kemampuanGuruBaik.setPoint(30D);
		kemampuanGuruRepository.save(kemampuanGuruBaik);
		
		KemampuanGuru kemampuanGuruBuruk = new KemampuanGuru();
		kemampuanGuruBuruk.setKemampuan("Buruk");
		kemampuanGuruBuruk.setPoint(10D);
		kemampuanGuruRepository.save(kemampuanGuruBuruk);
		
		// ====================================================== //
		
		/**
		 * Inisial Table Jumlah Siswa
		 */
		// ====================================================== //
		JumlahSiswa jumlahSiswaBanyak = new JumlahSiswa();
		jumlahSiswaBanyak.setJmlSiswa("Banyak");
		jumlahSiswaBanyak.setPoint(50D);
		jumlahSiswaRepository.save(jumlahSiswaBanyak);
		
		JumlahSiswa jumlahSiswaBanyakSedikit = new JumlahSiswa();
		jumlahSiswaBanyakSedikit.setJmlSiswa("Banyak Sedikit");
		jumlahSiswaBanyakSedikit.setPoint(40D);
		jumlahSiswaRepository.save(jumlahSiswaBanyakSedikit);
		
		JumlahSiswa jumlahSiswaSedikit = new JumlahSiswa();
		jumlahSiswaSedikit.setJmlSiswa("Sedikit");
		jumlahSiswaSedikit.setPoint(30D);
		jumlahSiswaRepository.save(jumlahSiswaSedikit);

		// ====================================================== //

		/**
		 * Inisial Table Metode
		 */
		// ============================================== //
		KemampuanSiswa kemampuanSiswaSangatBaik = new KemampuanSiswa();
		kemampuanSiswaSangatBaik.setKemampuan("Sangat Baik");
		kemampuanSiswaSangatBaik.setPoint(50D);
		kemampuanSiswaRepository.save(kemampuanSiswaSangatBaik);
		
		KemampuanSiswa kemampuanSiswaBaik = new KemampuanSiswa();
		kemampuanSiswaBaik.setKemampuan("Baik");
		kemampuanSiswaBaik.setPoint(30D);
		kemampuanSiswaRepository.save(kemampuanSiswaBaik);
		
		KemampuanSiswa kemampuanSiswaBuruk = new KemampuanSiswa();
		kemampuanSiswaBuruk.setKemampuan("Buruk");
		kemampuanSiswaBuruk.setPoint(10D);
		kemampuanSiswaRepository.save(kemampuanSiswaBuruk);
		
		// ============================================== //
		
		/**
		 * Inisial Table Metode
		 */
		// ============================================== //
		Metode metode1 = new Metode();
		metode1.setMetode("Ceramah");
		metode1.setFasilitas(fasilitasTidakPerlu);
		metode1.setJumlahSiswa(jumlahSiswaBanyak);
		metode1.setKemampuanGuru(kemampuanGuruBaik);
		metode1.setKemampuanSiswa(kemampuanSiswaBaik);
		metode1.setMateriPengajaran(materiSulit);
		metode1.setTujuanPengajaran(tujuanPenyampaianPesan);
		metode1.setWaktuPembelajaran(waktuSedikit);
		metodeRepository.save(metode1);

		Metode metode2 = new Metode();
		metode2.setMetode("Demonstrasi");
		metode2.setFasilitas(fasilitasPerlu);
		metode2.setJumlahSiswa(jumlahSiswaBanyak);
		metode2.setKemampuanGuru(kemampuanGuruBaik);
		metode2.setKemampuanSiswa(kemampuanSiswaBaik);
		metode2.setMateriPengajaran(materiMudah);
		metode2.setTujuanPengajaran(tujuanPenyampaianPesan);
		metode2.setWaktuPembelajaran(waktuBanyak);
		metodeRepository.save(metode2);
		
		Metode metode3 = new Metode();
		metode3.setMetode("Diskusi");
		metode3.setFasilitas(fasilitasPerlu);
		metode3.setJumlahSiswa(jumlahSiswaBanyakSedikit);
		metode3.setKemampuanGuru(kemampuanGuruBaik);
		metode3.setKemampuanSiswa(kemampuanSiswaBaik);
		metode3.setMateriPengajaran(materiSedang);
		metode3.setTujuanPengajaran(tujuanPengorganisasianSiswa);
		metode3.setWaktuPembelajaran(waktuBanyak);
		metodeRepository.save(metode3);
		
		Metode metode4 = new Metode();
		metode4.setMetode("Tanya Jawab");
		metode4.setFasilitas(fasilitasTidakPerlu);
		metode4.setJumlahSiswa(jumlahSiswaBanyak);
		metode4.setKemampuanGuru(kemampuanGuruBaik);
		metode4.setKemampuanSiswa(kemampuanSiswaBaik);
		metode4.setMateriPengajaran(materiSulit);
		metode4.setTujuanPengajaran(tujuanPenyampaianPesan);
		metode4.setWaktuPembelajaran(waktuBanyak);
		metodeRepository.save(metode4);
		
		Metode metode5 = new Metode();
		metode5.setMetode("Eksperimen");
		metode5.setFasilitas(fasilitasPerlu);
		metode5.setJumlahSiswa(jumlahSiswaSedikit);
		metode5.setKemampuanGuru(kemampuanGuruBaik);
		metode5.setKemampuanSiswa(kemampuanSiswaBaik);
		metode5.setMateriPengajaran(materiMudah);
		metode5.setTujuanPengajaran(tujuanPenyampaianPesan);
		metode5.setWaktuPembelajaran(waktuBanyak);
		metodeRepository.save(metode5);
		
		Metode metode6 = new Metode();
		metode6.setMetode("Karyawisata");
		metode6.setFasilitas(fasilitasPerlu);
		metode6.setJumlahSiswa(jumlahSiswaSedikit);
		metode6.setKemampuanGuru(kemampuanGuruBaik);
		metode6.setKemampuanSiswa(kemampuanSiswaBaik);
		metode6.setMateriPengajaran(materiSulit);
		metode6.setTujuanPengajaran(tujuanPengorganisasianSiswa);
		metode6.setWaktuPembelajaran(waktuBanyak);
		metodeRepository.save(metode6);
		
		Metode metode7 = new Metode();
		metode7.setMetode("Simulasi");
		metode7.setFasilitas(fasilitasPerlu);
		metode7.setJumlahSiswa(jumlahSiswaSedikit);
		metode7.setKemampuanGuru(kemampuanGuruBaik);
		metode7.setKemampuanSiswa(kemampuanSiswaBaik);
		metode7.setMateriPengajaran(materiMudah);
		metode7.setTujuanPengajaran(tujuanPendekatanPengajaran);
		metode7.setWaktuPembelajaran(waktuBanyak);
		metodeRepository.save(metode7);
		
		Metode metode8 = new Metode();
		metode8.setMetode("Tugas dan Resitasi");
		metode8.setFasilitas(fasilitasTidakPerlu);
		metode8.setJumlahSiswa(jumlahSiswaBanyakSedikit);
		metode8.setKemampuanGuru(kemampuanGuruBaik);
		metode8.setKemampuanSiswa(kemampuanSiswaBaik);
		metode8.setMateriPengajaran(materiSedang);
		metode8.setTujuanPengajaran(tujuanPenyampaianPesan);
		metode8.setWaktuPembelajaran(waktuBanyak);
		metodeRepository.save(metode8);
		
		Metode metode9 = new Metode();
		metode9.setMetode("Problem Solving");
		metode9.setFasilitas(fasilitasTidakPerlu);
		metode9.setJumlahSiswa(jumlahSiswaBanyak);
		metode9.setKemampuanGuru(kemampuanGuruBaik);
		metode9.setKemampuanSiswa(kemampuanSiswaBaik);
		metode9.setMateriPengajaran(materiMudah);
		metode9.setTujuanPengajaran(tujuanPendekatanPengajaran);
		metode9.setWaktuPembelajaran(waktuBanyak);
		metodeRepository.save(metode9);
		
		Metode metode10 = new Metode();
		metode10.setMetode("Inquiry");
		metode10.setFasilitas(fasilitasTidakPerlu);
		metode10.setJumlahSiswa(jumlahSiswaBanyak);
		metode10.setKemampuanGuru(kemampuanGuruBaik);
		metode10.setKemampuanSiswa(kemampuanSiswaBaik);
		metode10.setMateriPengajaran(materiSedang);
		metode10.setTujuanPengajaran(tujuanPendekatanPengajaran);
		metode10.setWaktuPembelajaran(waktuBanyak);
		metodeRepository.save(metode10);
		
		// ===================================================== //
	}

}
