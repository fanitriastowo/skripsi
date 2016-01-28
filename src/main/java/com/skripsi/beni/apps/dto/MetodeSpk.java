package com.skripsi.beni.apps.dto;

import java.io.Serializable;

public class MetodeSpk implements Serializable {

	private static final long serialVersionUID = 1L;

	private String namaMetode;
	private Double jumlahSiswa;
	private Double kondisiSekolah;
	private Double keaktifanSiswa;
	private Double kualitasPengajar;
	private Double fasilitas;
	private Double vectorS;
	private Double jumlahVectorS;
	private Double vectorV;

	public String getNamaMetode() {
		return namaMetode;
	}

	public void setNamaMetode(String namaMetode) {
		this.namaMetode = namaMetode;
	}

	public Double getJumlahSiswa() {
		return jumlahSiswa;
	}

	public void setJumlahSiswa(Double jumlahSiswa) {
		this.jumlahSiswa = jumlahSiswa;
	}

	public Double getKondisiSekolah() {
		return kondisiSekolah;
	}

	public void setKondisiSekolah(Double kondisiSekolah) {
		this.kondisiSekolah = kondisiSekolah;
	}

	public Double getKeaktifanSiswa() {
		return keaktifanSiswa;
	}

	public void setKeaktifanSiswa(Double keaktifanSiswa) {
		this.keaktifanSiswa = keaktifanSiswa;
	}

	public Double getKualitasPengajar() {
		return kualitasPengajar;
	}

	public void setKualitasPengajar(Double kualitasPengajar) {
		this.kualitasPengajar = kualitasPengajar;
	}

	public Double getFasilitas() {
		return fasilitas;
	}

	public void setFasilitas(Double fasilitas) {
		this.fasilitas = fasilitas;
	}

	public Double getVectorS() {
		return vectorS;
	}

	public void setVectorS(Double vectorS) {
		this.vectorS = vectorS;
	}

	public Double getJumlahVectorS() {
		return jumlahVectorS;
	}

	public void setJumlahVectorS(Double jumlahVectorS) {
		this.jumlahVectorS = jumlahVectorS;
	}

	public Double getVectorV() {
		return vectorV;
	}

	public void setVectorV(Double vectorV) {
		this.vectorV = vectorV;
	}

}
