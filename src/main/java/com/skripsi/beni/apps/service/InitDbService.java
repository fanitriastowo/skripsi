package com.skripsi.beni.apps.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.BobotSpk;
import com.skripsi.beni.apps.entity.Fasilitas;
import com.skripsi.beni.apps.entity.JumlahSiswa;
import com.skripsi.beni.apps.entity.Keaktifan;
import com.skripsi.beni.apps.entity.KondisiKelas;
import com.skripsi.beni.apps.entity.KondisiSekolah;
import com.skripsi.beni.apps.entity.Metode;
import com.skripsi.beni.apps.entity.Pengajar;
import com.skripsi.beni.apps.entity.Role;
import com.skripsi.beni.apps.entity.User;
import com.skripsi.beni.apps.repository.BobotRepository;
import com.skripsi.beni.apps.repository.FasilitasRepository;
import com.skripsi.beni.apps.repository.JumlahSiswaRepository;
import com.skripsi.beni.apps.repository.KeaktifanRepository;
import com.skripsi.beni.apps.repository.KondisiKelasRepository;
import com.skripsi.beni.apps.repository.KondisiSekolahRepository;
import com.skripsi.beni.apps.repository.MetodeRepository;
import com.skripsi.beni.apps.repository.PengajarRepository;
import com.skripsi.beni.apps.repository.RoleRepository;
import com.skripsi.beni.apps.repository.UserRepository;

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
	private JumlahSiswaRepository jumlahSiswaRepository;

	@Autowired
	private KeaktifanRepository keaktifanRepository;

	@Autowired
	private PengajarRepository pengajarRepository;

	@Autowired
	private FasilitasRepository fasilitasRepository;

	@Autowired
	private KondisiSekolahRepository kondisiSekolahRepository;
	
	@Autowired
	private KondisiKelasRepository kondisiKelasRepository;
	
	@Autowired
	private BobotRepository bobotRepository;

	@PostConstruct
	public void afterPropertiesSet() throws Exception {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		/**
		 * Inisial Table Bobot
		 */
		// ==================================== //
		final byte jumlahSiswaBobot = 2;
		final byte kondisiSekolahBobot = 5;
		final byte keaktifanSiswaBobot = 5;
		final byte kualitasPengajarBobot = 5;
		final byte fasilitasBobot = 4;
		
		// jumlahkan semua bobot
		final byte jumlahBobot = jumlahSiswaBobot + kondisiSekolahBobot + keaktifanSiswaBobot + kualitasPengajarBobot + fasilitasBobot;
		
		BobotSpk bobot = new BobotSpk();
		bobot.setId("bobot");
		bobot.setJumlahSiswaBobot(jumlahSiswaBobot);
		bobot.setKondisiSekolahBobot(kondisiSekolahBobot);
		bobot.setKeaktifanSiswaBobot(keaktifanSiswaBobot);
		bobot.setKualitasPengajarBobot(kualitasPengajarBobot);
		bobot.setFasilitasBobot(fasilitasBobot);
		
		bobot.setnJumlahSiswaBobot(Float.valueOf(jumlahSiswaBobot) / jumlahBobot);
		bobot.setnKondisiSekolahBobot(Float.valueOf(kondisiSekolahBobot) / jumlahBobot);
		bobot.setnKeaktifanSiswaBobot(Float.valueOf(keaktifanSiswaBobot) / jumlahBobot);
		bobot.setnKualitasPengajarBobot(Float.valueOf(kualitasPengajarBobot) / jumlahBobot);
		bobot.setnFasilitasBobot(Float.valueOf(fasilitasBobot) / jumlahBobot);
		
		bobotRepository.save(bobot);
		
		// ==================================== //
		
		/**
		 * Inisial Table Role
		 */
		// ==================================== //
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
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

		// User Lain
		User userLain = new User();
		userLain.setUsername("user1");
		userLain.setPassword(encoder.encode("user1"));
		userLain.setNamaLengkap("Blah");
		userLain.setNoTelp("999");
		userLain.setEnabled(true);
		userLain.setRole(roleUser);
		userRepository.save(userLain);
		// ==================================================== //

		/**
		 * Inisial Table Jumlah Siswa
		 */
		// ====================================================== //
		JumlahSiswa jumlahSiswaLebihDari26 = new JumlahSiswa();
		jumlahSiswaLebihDari26.setJmlSiswa("=> 26");
		jumlahSiswaLebihDari26.setPoint(50.0);
		jumlahSiswaRepository.save(jumlahSiswaLebihDari26);

		JumlahSiswa jumlahSiswaAntara21Dan25 = new JumlahSiswa();
		jumlahSiswaAntara21Dan25.setJmlSiswa("21 - 25");
		jumlahSiswaAntara21Dan25.setPoint(40.0);
		jumlahSiswaRepository.save(jumlahSiswaAntara21Dan25);

		JumlahSiswa jumlahSiswaAntara15Dan20 = new JumlahSiswa();
		jumlahSiswaAntara15Dan20.setJmlSiswa("15 - 20");
		jumlahSiswaAntara15Dan20.setPoint(30.0);
		jumlahSiswaRepository.save(jumlahSiswaAntara15Dan20);

		JumlahSiswa jumlahSiswaAntara11Dan14 = new JumlahSiswa();
		jumlahSiswaAntara11Dan14.setJmlSiswa("11 - 14");
		jumlahSiswaAntara11Dan14.setPoint(20.0);
		jumlahSiswaRepository.save(jumlahSiswaAntara11Dan14);

		JumlahSiswa jumlahSiswaKurangDari10 = new JumlahSiswa();
		jumlahSiswaKurangDari10.setJmlSiswa("<= 10");
		jumlahSiswaKurangDari10.setPoint(10.0);
		jumlahSiswaRepository.save(jumlahSiswaKurangDari10);

		// ====================================================== //

		/**
		 * Inisial Keaktifan siswa
		 */
		// ======================================================= //
		Keaktifan keaktifanLebihDari26 = new Keaktifan();
		keaktifanLebihDari26.setJmlSiswa("=> 26");
		keaktifanLebihDari26.setPoint(50.0);
		keaktifanRepository.save(keaktifanLebihDari26);

		Keaktifan keaktifanAntara21Dan25 = new Keaktifan();
		keaktifanAntara21Dan25.setJmlSiswa("21 - 25");
		keaktifanAntara21Dan25.setPoint(40.0);
		keaktifanRepository.save(keaktifanAntara21Dan25);

		Keaktifan keaktifanAntara15Dan20 = new Keaktifan();
		keaktifanAntara15Dan20.setJmlSiswa("15 - 20");
		keaktifanAntara15Dan20.setPoint(30.0);
		keaktifanRepository.save(keaktifanAntara15Dan20);

		Keaktifan keaktifanAntara11Dan14 = new Keaktifan();
		keaktifanAntara11Dan14.setJmlSiswa("11 - 14");
		keaktifanAntara11Dan14.setPoint(20.0);
		keaktifanRepository.save(keaktifanAntara11Dan14);

		Keaktifan keaktifanKurangDari10 = new Keaktifan();
		keaktifanKurangDari10.setJmlSiswa("<= 10");
		keaktifanKurangDari10.setPoint(10.0);
		keaktifanRepository.save(keaktifanKurangDari10);

		// ======================================================= //

		/**
		 * Inisial Table Pengajar
		 */
		// ======================================================= //
		Pengajar pengajarSangatBaik = new Pengajar();
		pengajarSangatBaik.setKualitas("Sangat Baik");
		pengajarSangatBaik.setPoint(30.0);
		pengajarRepository.save(pengajarSangatBaik);

		Pengajar pengajarBaik = new Pengajar();
		pengajarBaik.setKualitas("Baik");
		pengajarBaik.setPoint(20.0);
		pengajarRepository.save(pengajarBaik);

		Pengajar pengajarBuruk = new Pengajar();
		pengajarBuruk.setKualitas("Buruk");
		pengajarBuruk.setPoint(10.0);
		pengajarRepository.save(pengajarBuruk);
		// ======================================================= //

		/**
		 * Inisial table fasilitas
		 */
		// ======================================================= //
		Fasilitas fasilitasAda = new Fasilitas();
		fasilitasAda.setFasilitas("Ada");
		fasilitasAda.setPoint(50.0);
		fasilitasRepository.save(fasilitasAda);

		Fasilitas fasilitasTidakAda = new Fasilitas();
		fasilitasTidakAda.setFasilitas("Tidak Ada");
		fasilitasTidakAda.setPoint(30.0);
		fasilitasRepository.save(fasilitasTidakAda);

		// ======================================================= //
		
		/**
		 * Inisial table Kondisi Sekolah
		 */
		// ======================================================= //
		KondisiSekolah kondisiJauhDariPusatKeramaian = new KondisiSekolah();
		kondisiJauhDariPusatKeramaian.setKondisi("Jauh dari pusat keramaian");
		kondisiJauhDariPusatKeramaian.setPoint(30.0);
		kondisiSekolahRepository.save(kondisiJauhDariPusatKeramaian);
		
		KondisiSekolah kondisiDekatDenganPusatKeramaian = new KondisiSekolah();
		kondisiDekatDenganPusatKeramaian.setKondisi("Dekat dengan pusat keramaian");
		kondisiDekatDenganPusatKeramaian.setPoint(20.0);
		kondisiSekolahRepository.save(kondisiDekatDenganPusatKeramaian);
		
		KondisiSekolah kondisiBeradaDiPusatKeramaian = new KondisiSekolah();
		kondisiBeradaDiPusatKeramaian.setKondisi("Berada dipusat keramaian");
		kondisiBeradaDiPusatKeramaian.setPoint(10.0);
		kondisiSekolahRepository.save(kondisiBeradaDiPusatKeramaian);
		
		// ======================================================= //
		
		/**
		 * Inisial table Kondisi Kelas
		 */
		// ======================================================= //
		KondisiKelas kondisiKelasGaduh = new KondisiKelas();
		kondisiKelasGaduh.setKondisi("Gaduh");
		kondisiKelasGaduh.setPoint(10.0);
		kondisiKelasRepository.save(kondisiKelasGaduh);
		
		KondisiKelas kondisiKelasSepi = new KondisiKelas();
		kondisiKelasSepi.setKondisi("Sepi");
		kondisiKelasSepi.setPoint(20.0);
		kondisiKelasRepository.save(kondisiKelasSepi);
		
		KondisiKelas kondisiKelasCukupKondusif = new KondisiKelas();
		kondisiKelasCukupKondusif.setKondisi("Cukup Kondusif");
		kondisiKelasCukupKondusif.setPoint(30.0);
		kondisiKelasRepository.save(kondisiKelasCukupKondusif);
		
		KondisiKelas kondisiKelasKondusif = new KondisiKelas();
		kondisiKelasKondusif.setKondisi("Kondusif");
		kondisiKelasKondusif.setPoint(40.0);
		kondisiKelasRepository.save(kondisiKelasKondusif);
		
		KondisiKelas kondisiKelasAktif = new KondisiKelas();
		kondisiKelasAktif.setKondisi("Aktif");
		kondisiKelasAktif.setPoint(50.0);
		kondisiKelasRepository.save(kondisiKelasAktif);
		
		// ======================================================= //
		
		
		/**
		 * Inisial Table Metode
		 */
		// ============================================== //
		Metode metode1 = new Metode();
		metode1.setMetode("Ceramah");
		metode1.setJumlahSiswa(jumlahSiswaLebihDari26);
		metode1.setKeaktifan(keaktifanLebihDari26);
		metode1.setKondisi(kondisiJauhDariPusatKeramaian);
		metode1.setFasilitas(fasilitasAda);
		metode1.setPengajar(pengajarSangatBaik);
		metodeRepository.save(metode1);

		Metode metode2 = new Metode();
		metode2.setMetode("Diskusi");
		metode2.setJumlahSiswa(jumlahSiswaLebihDari26);
		metode2.setKeaktifan(keaktifanAntara15Dan20);
		metode2.setKondisi(kondisiJauhDariPusatKeramaian);
		metode2.setFasilitas(fasilitasAda);
		metode2.setPengajar(pengajarSangatBaik);
		metodeRepository.save(metode2);

		Metode metode3 = new Metode();
		metode3.setMetode("Problem Solving");
		metode3.setJumlahSiswa(jumlahSiswaLebihDari26);
		metode3.setKeaktifan(keaktifanAntara11Dan14);
		metode3.setKondisi(kondisiJauhDariPusatKeramaian);
		metode3.setFasilitas(fasilitasAda);
		metode3.setPengajar(pengajarSangatBaik);
		metodeRepository.save(metode3);

		Metode metode4 = new Metode();
		metode4.setMetode("Tanya Jawab");
		metode4.setJumlahSiswa(jumlahSiswaLebihDari26);
		metode4.setKeaktifan(keaktifanLebihDari26);
		metode4.setKondisi(kondisiJauhDariPusatKeramaian);
		metode4.setFasilitas(fasilitasTidakAda);
		metode4.setPengajar(pengajarSangatBaik);
		metodeRepository.save(metode4);

		Metode metode5 = new Metode();
		metode5.setMetode("Latihan");
		metode5.setJumlahSiswa(jumlahSiswaLebihDari26);
		metode5.setKeaktifan(keaktifanAntara15Dan20);
		metode5.setKondisi(kondisiJauhDariPusatKeramaian);
		metode5.setFasilitas(fasilitasTidakAda);
		metode5.setPengajar(pengajarSangatBaik);
		metodeRepository.save(metode5);

		Metode metode6 = new Metode();
		metode6.setMetode("Eksperimen");
		metode6.setJumlahSiswa(jumlahSiswaLebihDari26);
		metode6.setKeaktifan(keaktifanLebihDari26);
		metode6.setKondisi(kondisiJauhDariPusatKeramaian);
		metode6.setFasilitas(fasilitasTidakAda);
		metode6.setPengajar(pengajarSangatBaik);
		metodeRepository.save(metode6);

		Metode metode7 = new Metode();
		metode7.setMetode("Membaca dan Berdiskusi");
		metode7.setJumlahSiswa(jumlahSiswaLebihDari26);
		metode7.setKeaktifan(keaktifanAntara21Dan25);
		metode7.setKondisi(kondisiJauhDariPusatKeramaian);
		metode7.setFasilitas(fasilitasAda);
		metode7.setPengajar(pengajarSangatBaik);
		metodeRepository.save(metode7);

		Metode metode8 = new Metode();
		metode8.setMetode("Role Playing");
		metode8.setJumlahSiswa(jumlahSiswaLebihDari26);
		metode8.setKeaktifan(keaktifanLebihDari26);
		metode8.setKondisi(kondisiJauhDariPusatKeramaian);
		metode8.setFasilitas(fasilitasTidakAda);
		metode8.setPengajar(pengajarSangatBaik);
		metodeRepository.save(metode8);

		Metode metode9 = new Metode();
		metode9.setMetode("Resitasi");
		metode9.setJumlahSiswa(jumlahSiswaLebihDari26);
		metode9.setKeaktifan(keaktifanLebihDari26);
		metode9.setKondisi(kondisiJauhDariPusatKeramaian);
		metode9.setFasilitas(fasilitasTidakAda);
		metode9.setPengajar(pengajarSangatBaik);
		metodeRepository.save(metode9);

		Metode metode10 = new Metode();
		metode10.setMetode("Demonstrasi");
		metode10.setJumlahSiswa(jumlahSiswaLebihDari26);
		metode10.setKeaktifan(keaktifanAntara11Dan14);
		metode10.setKondisi(kondisiJauhDariPusatKeramaian);
		metode10.setFasilitas(fasilitasTidakAda);
		metode10.setPengajar(pengajarSangatBaik);
		metodeRepository.save(metode10);
		// ===================================================== //
	}

}
