package com.skripsi.beni.apps.dto;

public class MetodeDTO {

	private Long id;
	private String metode;
	private Long jumlahSiswa;
	private Long fasilitas;
	private Long kemampuanSiswa;
	private Long kemampuanGuru;
	private Long materiPengajaran;
	private Long tujuanPengajaran;
	private Long waktuPembelajaran;

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

	public Long getJumlahSiswa() {
		return jumlahSiswa;
	}

	public void setJumlahSiswa(Long jumlahSiswa) {
		this.jumlahSiswa = jumlahSiswa;
	}

	public Long getFasilitas() {
		return fasilitas;
	}

	public void setFasilitas(Long fasilitas) {
		this.fasilitas = fasilitas;
	}

	public Long getKemampuanSiswa() {
		return kemampuanSiswa;
	}

	public void setKemampuanSiswa(Long kemampuanSiswa) {
		this.kemampuanSiswa = kemampuanSiswa;
	}

	public Long getKemampuanGuru() {
		return kemampuanGuru;
	}

	public void setKemampuanGuru(Long kemampuanGuru) {
		this.kemampuanGuru = kemampuanGuru;
	}

	public Long getMateriPengajaran() {
		return materiPengajaran;
	}

	public void setMateriPengajaran(Long materiPengajaran) {
		this.materiPengajaran = materiPengajaran;
	}

	public Long getTujuanPengajaran() {
		return tujuanPengajaran;
	}

	public void setTujuanPengajaran(Long tujuanPengajaran) {
		this.tujuanPengajaran = tujuanPengajaran;
	}

	public Long getWaktuPembelajaran() {
		return waktuPembelajaran;
	}

	public void setWaktuPembelajaran(Long waktuPembelajaran) {
		this.waktuPembelajaran = waktuPembelajaran;
	}

}
