package com.skripsi.beni.apps.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.Fasilitas;
import com.skripsi.beni.apps.entity.JumlahSiswa;
import com.skripsi.beni.apps.entity.Keaktifan;
import com.skripsi.beni.apps.entity.Kondisi;
import com.skripsi.beni.apps.entity.Metode;
import com.skripsi.beni.apps.entity.Pengajar;
import com.skripsi.beni.apps.entity.Role;
import com.skripsi.beni.apps.entity.User;
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

	// @PostConstruct
	public void afterPropertiesSet() throws Exception {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

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
		 * Inisial Table Metode
		 */
		// ============================================== //
		Metode metode1 = new Metode();
		metode1.setMetode("Ceramah");
		metodeRepository.save(metode1);

		Metode metode2 = new Metode();
		metode2.setMetode("Diskusi");
		metodeRepository.save(metode2);

		Metode metode3 = new Metode();
		metode3.setMetode("Problem Solving");
		metodeRepository.save(metode3);

		Metode metode4 = new Metode();
		metode4.setMetode("Tanya Jawab");
		metodeRepository.save(metode4);

		Metode metode5 = new Metode();
		metode5.setMetode("Latihan");
		metodeRepository.save(metode5);

		Metode metode6 = new Metode();
		metode6.setMetode("Eksperimen");
		metodeRepository.save(metode6);

		Metode metode7 = new Metode();
		metode7.setMetode("Membaca dan Berdiskusi");
		metodeRepository.save(metode7);

		Metode metode8 = new Metode();
		metode8.setMetode("Role Playing");
		metodeRepository.save(metode8);

		Metode metode9 = new Metode();
		metode9.setMetode("Resitasi");
		metodeRepository.save(metode9);

		Metode metode10 = new Metode();
		metode10.setMetode("Demonstrasi");
		metodeRepository.save(metode10);
		// ===================================================== //

		/**
		 * Inisial Table Jumlah Siswa
		 */
		// ====================================================== //
		JumlahSiswa jumlahSiswa1 = new JumlahSiswa();
		jumlahSiswa1.setJmlSiswa("=> 26");
		jumlahSiswa1.setPoint(50.0);
		jumlahSiswaRepository.save(jumlahSiswa1);

		JumlahSiswa jumlahSiswa2 = new JumlahSiswa();
		jumlahSiswa2.setJmlSiswa("21 - 25");
		jumlahSiswa2.setPoint(40.0);
		jumlahSiswaRepository.save(jumlahSiswa2);

		JumlahSiswa jumlahSiswa3 = new JumlahSiswa();
		jumlahSiswa3.setJmlSiswa("15 - 20");
		jumlahSiswa3.setPoint(30.0);
		jumlahSiswaRepository.save(jumlahSiswa3);

		JumlahSiswa jumlahSiswa4 = new JumlahSiswa();
		jumlahSiswa4.setJmlSiswa("11 - 14");
		jumlahSiswa4.setPoint(20.0);
		jumlahSiswaRepository.save(jumlahSiswa4);

		JumlahSiswa jumlahSiswa5 = new JumlahSiswa();
		jumlahSiswa5.setJmlSiswa("<= 10");
		jumlahSiswa5.setPoint(10.0);
		jumlahSiswaRepository.save(jumlahSiswa5);

		// ====================================================== //

		/**
		 * Inisial Keaktifan siswa
		 */
		// ======================================================= //
		Keaktifan keaktifan1 = new Keaktifan();
		keaktifan1.setJmlSiswa("=> 26");
		keaktifan1.setPoint(50.0);
		keaktifanRepository.save(keaktifan1);

		Keaktifan keaktifan2 = new Keaktifan();
		keaktifan2.setJmlSiswa("21 - 25");
		keaktifan2.setPoint(40.0);
		keaktifanRepository.save(keaktifan2);

		Keaktifan keaktifan3 = new Keaktifan();
		keaktifan3.setJmlSiswa("15 - 20");
		keaktifan3.setPoint(30.0);
		keaktifanRepository.save(keaktifan3);

		Keaktifan keaktifan4 = new Keaktifan();
		keaktifan4.setJmlSiswa("11 - 14");
		keaktifan4.setPoint(20.0);
		keaktifanRepository.save(keaktifan4);

		Keaktifan keaktifan5 = new Keaktifan();
		keaktifan5.setJmlSiswa("<= 10");
		keaktifan5.setPoint(10.0);
		keaktifanRepository.save(keaktifan5);

		// ======================================================= //

		/**
		 * Inisial Table Pengajar
		 */
		// ======================================================= //
		Pengajar pengajar1 = new Pengajar();
		pengajar1.setKualitas("Sangat Baik");
		pengajar1.setPoint(30.0);
		pengajarRepository.save(pengajar1);

		Pengajar pengajar2 = new Pengajar();
		pengajar2.setKualitas("Baik");
		pengajar2.setPoint(20.0);
		pengajarRepository.save(pengajar2);

		Pengajar pengajar5 = new Pengajar();
		pengajar5.setKualitas("Buruk");
		pengajar5.setPoint(10.0);
		pengajarRepository.save(pengajar5);
		// ======================================================= //

		/**
		 * Inisial table fasilitas
		 */
		// ======================================================= //
		Fasilitas fasilitas1 = new Fasilitas();
		fasilitas1.setFasilitas("Ada");
		fasilitas1.setPoint(50.0);
		fasilitasRepository.save(fasilitas1);

		Fasilitas fasilitas2 = new Fasilitas();
		fasilitas2.setFasilitas("Tidak Ada");
		fasilitas2.setPoint(30.0);
		fasilitasRepository.save(fasilitas2);

		// ======================================================= //
		
		/**
		 * Inisial table Kondisi
		 */
		// ======================================================= //
		Kondisi kondisi1 = new Kondisi();
		kondisi1.setKondisi("Jauh dari pusat keramaian");
		kondisi1.setPoint(30.0);
		kondisiRepository.save(kondisi1);
		
		Kondisi kondisi2 = new Kondisi();
		kondisi2.setKondisi("Dekat dengan pusat keramaian");
		kondisi2.setPoint(20.0);
		kondisiRepository.save(kondisi2);
		
		Kondisi kondisi3 = new Kondisi();
		kondisi3.setKondisi("Berada dipusat keramaian");
		kondisi3.setPoint(10.0);
		kondisiRepository.save(kondisi3);
		
		// ======================================================= //
	}

}
