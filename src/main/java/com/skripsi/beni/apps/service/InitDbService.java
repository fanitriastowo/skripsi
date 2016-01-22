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
import com.skripsi.beni.apps.entity.Kondisi;
import com.skripsi.beni.apps.entity.Metode;
import com.skripsi.beni.apps.entity.Pengajar;
import com.skripsi.beni.apps.entity.Role;
import com.skripsi.beni.apps.entity.User;
import com.skripsi.beni.apps.repository.BobotRepository;
import com.skripsi.beni.apps.repository.FasilitasRepository;
import com.skripsi.beni.apps.repository.JumlahSiswaRepository;
import com.skripsi.beni.apps.repository.KeaktifanRepository;
import com.skripsi.beni.apps.repository.KondisiRepository;
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
	private KondisiRepository kondisiRepository;
	
	@Autowired
	private BobotRepository bobotRepository;

	// @PostConstruct
	public void afterPropertiesSet() throws Exception {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		/**
		 * Inisial Table Bobot
		 */
		// ==================================== //
		BobotSpk bobot = new BobotSpk();
		bobot.setId("bobot");
		bobot.setJumlahSiswaBobot((byte) 4);
		bobot.setKondisiKelasBobot((byte) 5);
		bobot.setKeaktifanSiswaBobot((byte) 5);
		bobot.setKualitasPengajarBobot((byte) 5);
		bobot.setFasilitasBobot((byte) 3);
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
		 * Inisial table Kondisi
		 */
		// ======================================================= //
		Kondisi kondisiJauhDariPusatKeramaian = new Kondisi();
		kondisiJauhDariPusatKeramaian.setKondisi("Jauh dari pusat keramaian");
		kondisiJauhDariPusatKeramaian.setPoint(30.0);
		kondisiRepository.save(kondisiJauhDariPusatKeramaian);
		
		Kondisi kondisiDekatDenganPusatKeramaian = new Kondisi();
		kondisiDekatDenganPusatKeramaian.setKondisi("Dekat dengan pusat keramaian");
		kondisiDekatDenganPusatKeramaian.setPoint(20.0);
		kondisiRepository.save(kondisiDekatDenganPusatKeramaian);
		
		Kondisi kondisiBeradaDiPusatKeramaian = new Kondisi();
		kondisiBeradaDiPusatKeramaian.setKondisi("Berada dipusat keramaian");
		kondisiBeradaDiPusatKeramaian.setPoint(10.0);
		kondisiRepository.save(kondisiBeradaDiPusatKeramaian);
		
		// ======================================================= //
		
		
		/**
		 * Inisial Table Metode
		 */
		// ============================================== //
		Metode metode1 = new Metode();
		metode1.setMetode("Ceramah");
		metode1.setFasilitas(fasilitasAda);
		metode1.setJumlahSiswa(jumlahSiswaAntara21Dan25);
		metode1.setKeaktifan(keaktifanLebihDari26);
		metode1.setKondisi(kondisiJauhDariPusatKeramaian);
		metode1.setPengajar(pengajarBaik);
		metodeRepository.save(metode1);

		Metode metode2 = new Metode();
		metode2.setMetode("Diskusi");
		metode2.setFasilitas(fasilitasAda);
		metode2.setJumlahSiswa(jumlahSiswaKurangDari10);
		metode2.setKeaktifan(keaktifanLebihDari26);
		metode2.setKondisi(kondisiDekatDenganPusatKeramaian);
		metode2.setPengajar(pengajarBaik);
		metodeRepository.save(metode2);

		Metode metode3 = new Metode();
		metode3.setMetode("Problem Solving");
		metode3.setFasilitas(fasilitasTidakAda);
		metode3.setJumlahSiswa(jumlahSiswaAntara11Dan14);
		metode3.setKeaktifan(keaktifanAntara15Dan20);
		metode3.setKondisi(kondisiJauhDariPusatKeramaian);
		metode3.setPengajar(pengajarBuruk);
		metodeRepository.save(metode3);

		Metode metode4 = new Metode();
		metode4.setMetode("Tanya Jawab");
		metode4.setFasilitas(fasilitasTidakAda);
		metode4.setJumlahSiswa(jumlahSiswaLebihDari26);
		metode4.setKeaktifan(keaktifanAntara21Dan25);
		metode4.setKondisi(kondisiBeradaDiPusatKeramaian);
		metode4.setPengajar(pengajarSangatBaik);
		metodeRepository.save(metode4);

		Metode metode5 = new Metode();
		metode5.setMetode("Latihan");
		metode5.setFasilitas(fasilitasTidakAda);
		metode5.setJumlahSiswa(jumlahSiswaAntara21Dan25);
		metode5.setKeaktifan(keaktifanLebihDari26);
		metode5.setKondisi(kondisiJauhDariPusatKeramaian);
		metode5.setPengajar(pengajarBaik);
		metodeRepository.save(metode5);

		Metode metode6 = new Metode();
		metode6.setMetode("Eksperimen");
		metode6.setFasilitas(fasilitasAda);
		metode6.setJumlahSiswa(jumlahSiswaAntara15Dan20);
		metode6.setKeaktifan(keaktifanAntara21Dan25);
		metode6.setKondisi(kondisiBeradaDiPusatKeramaian);
		metode6.setPengajar(pengajarBaik);
		metodeRepository.save(metode6);

		Metode metode7 = new Metode();
		metode7.setMetode("Membaca dan Berdiskusi");
		metode7.setFasilitas(fasilitasTidakAda);
		metode7.setJumlahSiswa(jumlahSiswaAntara21Dan25);
		metode7.setKeaktifan(keaktifanAntara21Dan25);
		metode7.setKondisi(kondisiDekatDenganPusatKeramaian);
		metode7.setPengajar(pengajarBuruk);
		metodeRepository.save(metode7);

		Metode metode8 = new Metode();
		metode8.setMetode("Role Playing");
		metode8.setFasilitas(fasilitasAda);
		metode8.setJumlahSiswa(jumlahSiswaAntara21Dan25);
		metode8.setKeaktifan(keaktifanLebihDari26);
		metode8.setKondisi(kondisiJauhDariPusatKeramaian);
		metode8.setPengajar(pengajarBaik);
		metodeRepository.save(metode8);

		Metode metode9 = new Metode();
		metode9.setMetode("Resitasi");
		metode9.setFasilitas(fasilitasTidakAda);
		metode9.setJumlahSiswa(jumlahSiswaAntara21Dan25);
		metode9.setKeaktifan(keaktifanAntara21Dan25);
		metode9.setKondisi(kondisiJauhDariPusatKeramaian);
		metode9.setPengajar(pengajarSangatBaik);
		metodeRepository.save(metode9);

		Metode metode10 = new Metode();
		metode10.setMetode("Demonstrasi");
		metode10.setFasilitas(fasilitasAda);
		metode10.setJumlahSiswa(jumlahSiswaKurangDari10);
		metode10.setKeaktifan(keaktifanAntara15Dan20);
		metode10.setKondisi(kondisiDekatDenganPusatKeramaian);
		metode10.setPengajar(pengajarSangatBaik);
		metodeRepository.save(metode10);
		// ===================================================== //
	}

}
