package com.skripsi.beni.apps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "METODE")
public class Metode {

	@Id
	@GeneratedValue
	private Long id;

	private String metode;

	@ManyToOne
	@JoinColumn(name = "jumlah_siswa_id")
	private JumlahSiswa jumlahSiswa;

	@ManyToOne
	@JoinColumn(name = "kondisi_sekolah_id")
	private KondisiSekolah kondisiSekolah;

	@ManyToOne
	@JoinColumn(name = "keaktifan_id")
	private Keaktifan keaktifan;

	@ManyToOne
	@JoinColumn(name = "pengajar_id")
	private Pengajar pengajar;

	@ManyToOne
	@JoinColumn(name = "fasilitas_id")
	private Fasilitas fasilitas;

	@ManyToOne
	@JoinColumn(name = "kondisi_kelas_id")
	private KondisiKelas kondisiKelas;

	public JumlahSiswa getJumlahSiswa() {
		return jumlahSiswa;
	}

	public void setJumlahSiswa(JumlahSiswa jumlahSiswa) {
		this.jumlahSiswa = jumlahSiswa;
	}

	public KondisiSekolah getKondisiSekolah() {
		return kondisiSekolah;
	}

	public void setKondisiSekolah(KondisiSekolah kondisiSekolah) {
		this.kondisiSekolah = kondisiSekolah;
	}

	public Keaktifan getKeaktifan() {
		return keaktifan;
	}

	public void setKeaktifan(Keaktifan keaktifan) {
		this.keaktifan = keaktifan;
	}

	public Pengajar getPengajar() {
		return pengajar;
	}

	public void setPengajar(Pengajar pengajar) {
		this.pengajar = pengajar;
	}

	public Fasilitas getFasilitas() {
		return fasilitas;
	}

	public void setFasilitas(Fasilitas fasilitas) {
		this.fasilitas = fasilitas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMetode() {
		return metode;
	}

	public void setMetode(String metode) {
		this.metode = metode;
	}

	public KondisiKelas getKondisiKelas() {
		return kondisiKelas;
	}

	public void setKondisiKelas(KondisiKelas kondisiKelas) {
		this.kondisiKelas = kondisiKelas;
	}

}
