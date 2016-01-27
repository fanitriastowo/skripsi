package com.skripsi.beni.apps.dto;

public class MetodeDTO {

	private Long id;
	private String metode;
	private Long jumlahSiswa;
	private Long keaktifan;
	private Long kondisi;
	private Long fasilitas;
	private Long pengajar;

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

	public Long getKeaktifan() {
		return keaktifan;
	}

	public void setKeaktifan(Long keaktifan) {
		this.keaktifan = keaktifan;
	}

	public Long getKondisi() {
		return kondisi;
	}

	public void setKondisi(Long kondisi) {
		this.kondisi = kondisi;
	}

	public Long getFasilitas() {
		return fasilitas;
	}

	public void setFasilitas(Long fasilitas) {
		this.fasilitas = fasilitas;
	}

	public Long getPengajar() {
		return pengajar;
	}

	public void setPengajar(Long pengajar) {
		this.pengajar = pengajar;
	}

}
