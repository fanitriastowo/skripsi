package com.skripsi.beni.apps.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skripsi.beni.apps.entity.Fasilitas;
import com.skripsi.beni.apps.entity.Keaktifan;
import com.skripsi.beni.apps.entity.JumlahSiswa;
import com.skripsi.beni.apps.entity.Metode;
import com.skripsi.beni.apps.entity.Pengajar;
import com.skripsi.beni.apps.entity.Role;
import com.skripsi.beni.apps.entity.User;
import com.skripsi.beni.apps.repository.FasilitasRepository;
import com.skripsi.beni.apps.repository.KeaktifanRepository;
import com.skripsi.beni.apps.repository.JumlahSiswaRepository;
import com.skripsi.beni.apps.repository.MetodeRepository;
import com.skripsi.beni.apps.repository.PengajarRepository;
import com.skripsi.beni.apps.repository.RoleRepository;
import com.skripsi.beni.apps.repository.UserRepository;

@Service
@Transactional
public class InitDbService implements InitializingBean {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MetodeRepository metodeRepository;

	@Autowired
	private JumlahSiswaRepository kondisiRepository;
	
	@Autowired
	private KeaktifanRepository keaktifanRepository;
	
	@Autowired
	private PengajarRepository pengajarRepository;
	
	@Autowired
	private FasilitasRepository fasilitasRepository;

	@Override
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
		metode9.setMetode("Karya Wisata");
		metodeRepository.save(metode9);

		Metode metode10 = new Metode();
		metode10.setMetode("Demonstrasi");
		metodeRepository.save(metode10);
		// ===================================================== //

		/**
		 * Inisial Table Kondisi Kelas
		 */
		// ====================================================== //
		JumlahSiswa kondisi1 = new JumlahSiswa();
		kondisi1.setJmlSiswa("<= 10");
		kondisi1.setPoint(50.0);
		kondisiRepository.save(kondisi1);
		
		JumlahSiswa kondisi2 = new JumlahSiswa();
		kondisi2.setJmlSiswa("10 - 15");
		kondisi2.setPoint(40.0);
		kondisiRepository.save(kondisi2);

		JumlahSiswa kondisi3 = new JumlahSiswa();
		kondisi3.setJmlSiswa("15 - 20");
		kondisi3.setPoint(30.0);
		kondisiRepository.save(kondisi3);
		
		JumlahSiswa kondisi4 = new JumlahSiswa();
		kondisi4.setJmlSiswa("21 - 25");
		kondisi4.setPoint(20.0);
		kondisiRepository.save(kondisi4);

		JumlahSiswa kondisi5 = new JumlahSiswa();
		kondisi5.setJmlSiswa("=> 26");
		kondisi5.setPoint(10.0);
		kondisiRepository.save(kondisi5);
		
		// ====================================================== //
		
		/**
		 * Inisial Keaktifan siswa
		 */
		// ======================================================= //
		Keaktifan keaktifan1 = new Keaktifan();
		keaktifan1.setJmlSiswa("<= 5");
		keaktifan1.setPoint(50.0);
		keaktifanRepository.save(keaktifan1);
		
		Keaktifan keaktifan2 = new Keaktifan();
		keaktifan2.setJmlSiswa("6 - 10");
		keaktifan2.setPoint(40.0);
		keaktifanRepository.save(keaktifan2);
		
		Keaktifan keaktifan3 = new Keaktifan();
		keaktifan3.setJmlSiswa("11 - 15");
		keaktifan3.setPoint(30.0);
		keaktifanRepository.save(keaktifan3);
		
		Keaktifan keaktifan4 = new Keaktifan();
		keaktifan4.setJmlSiswa("16 - 20");
		keaktifan4.setPoint(20.0);
		keaktifanRepository.save(keaktifan4);
		
		Keaktifan keaktifan5 = new Keaktifan();
		keaktifan5.setJmlSiswa("=> 21");
		keaktifan5.setPoint(10.0);
		keaktifanRepository.save(keaktifan5);
		
		// ======================================================= //
		
		/**
		 * Inisial Table Pengajar
		 */
		// ======================================================= //
		Pengajar pengajar1 = new Pengajar();
		pengajar1.setKualitas("Sangat Baik");
		pengajar1.setPoint(50.0);
		pengajarRepository.save(pengajar1);
		
		Pengajar pengajar2 = new Pengajar();
		pengajar2.setKualitas("Baik");
		pengajar2.setPoint(40.0);
		pengajarRepository.save(pengajar2);
		
		Pengajar pengajar3 = new Pengajar();
		pengajar3.setKualitas("Cukup");
		pengajar3.setPoint(30.0);
		pengajarRepository.save(pengajar3);
		
		Pengajar pengajar4 = new Pengajar();
		pengajar4.setKualitas("Kurang Baik");
		pengajar4.setPoint(20.0);
		pengajarRepository.save(pengajar4);
		
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
		fasilitas1.setFasilitas("Sangat Baik");
		fasilitas1.setPoint(50.0);
		fasilitasRepository.save(fasilitas1);

		Fasilitas fasilitas2 = new Fasilitas();
		fasilitas2.setFasilitas("Baik");
		fasilitas2.setPoint(40.0);
		fasilitasRepository.save(fasilitas2);

		Fasilitas fasilitas3 = new Fasilitas();
		fasilitas3.setFasilitas("Cukup");
		fasilitas3.setPoint(30.0);
		fasilitasRepository.save(fasilitas3);

		Fasilitas fasilitas4 = new Fasilitas();
		fasilitas4.setFasilitas("Kurang");
		fasilitas4.setPoint(20.0);
		fasilitasRepository.save(fasilitas4);

		Fasilitas fasilitas5 = new Fasilitas();
		fasilitas5.setFasilitas("Tidak Ada");
		fasilitas5.setPoint(10.0);
		fasilitasRepository.save(fasilitas5);

		// ======================================================= //
	}

}
