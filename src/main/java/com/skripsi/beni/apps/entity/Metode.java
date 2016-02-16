package com.skripsi.beni.apps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.skripsi.beni.apps.entity.kriteria.Fasilitas;
import com.skripsi.beni.apps.entity.kriteria.JumlahSiswa;
import com.skripsi.beni.apps.entity.kriteria.KemampuanGuru;
import com.skripsi.beni.apps.entity.kriteria.KemampuanSiswa;
import com.skripsi.beni.apps.entity.kriteria.MateriPengajaran;
import com.skripsi.beni.apps.entity.kriteria.TujuanPengajaran;
import com.skripsi.beni.apps.entity.kriteria.WaktuPembelajaran;

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
	@JoinColumn(name = "fasilitas_id")
	private Fasilitas fasilitas;

	@ManyToOne
	@JoinColumn(name = "kemampuan_siswa_id")
	private KemampuanSiswa kemampuanSiswa;

	@ManyToOne
	@JoinColumn(name = "kemampuan_guru_id")
	private KemampuanGuru kemampuanGuru;

	@ManyToOne
	@JoinColumn(name = "materi_pengajaran_id")
	private MateriPengajaran materiPengajaran;

	@ManyToOne
	@JoinColumn(name = "tujuan_pengajaran_id")
	private TujuanPengajaran tujuanPengajaran;

	@ManyToOne
	@JoinColumn(name = "waktu_pembelajaran_id")
	private WaktuPembelajaran waktuPembelajaran;

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

	public JumlahSiswa getJumlahSiswa() {
		return jumlahSiswa;
	}

	public void setJumlahSiswa(JumlahSiswa jumlahSiswa) {
		this.jumlahSiswa = jumlahSiswa;
	}

	public Fasilitas getFasilitas() {
		return fasilitas;
	}

	public void setFasilitas(Fasilitas fasilitas) {
		this.fasilitas = fasilitas;
	}

	public KemampuanSiswa getKemampuanSiswa() {
		return kemampuanSiswa;
	}

	public void setKemampuanSiswa(KemampuanSiswa kemampuanSiswa) {
		this.kemampuanSiswa = kemampuanSiswa;
	}

	public KemampuanGuru getKemampuanGuru() {
		return kemampuanGuru;
	}

	public void setKemampuanGuru(KemampuanGuru kemampuanGuru) {
		this.kemampuanGuru = kemampuanGuru;
	}

	public MateriPengajaran getMateriPengajaran() {
		return materiPengajaran;
	}

	public void setMateriPengajaran(MateriPengajaran materiPengajaran) {
		this.materiPengajaran = materiPengajaran;
	}

	public TujuanPengajaran getTujuanPengajaran() {
		return tujuanPengajaran;
	}

	public void setTujuanPengajaran(TujuanPengajaran tujuanPengajaran) {
		this.tujuanPengajaran = tujuanPengajaran;
	}

	public WaktuPembelajaran getWaktuPembelajaran() {
		return waktuPembelajaran;
	}

	public void setWaktuPembelajaran(WaktuPembelajaran waktuPembelajaran) {
		this.waktuPembelajaran = waktuPembelajaran;
	}

}
