package com.skripsi.beni.apps.dto;

import java.io.Serializable;

public class MetodeSpk implements Serializable {

	private static final long serialVersionUID = 1L;

	private String namaMetode;
	private Double jumlahSiswa;
	private Double fasilitas;
	private Double kemampuanSiswa;
	private Double kemampuanGuru;
	private Double materiPengajaran;
	private Double tujuanPengajaran;
	private Double waktuPembelajaran;
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

	public Double getFasilitas() {
		return fasilitas;
	}

	public void setFasilitas(Double fasilitas) {
		this.fasilitas = fasilitas;
	}

	public Double getKemampuanSiswa() {
		return kemampuanSiswa;
	}

	public void setKemampuanSiswa(Double kemampuanSiswa) {
		this.kemampuanSiswa = kemampuanSiswa;
	}

	public Double getKemampuanGuru() {
		return kemampuanGuru;
	}

	public void setKemampuanGuru(Double kemampuanGuru) {
		this.kemampuanGuru = kemampuanGuru;
	}

	public Double getMateriPengajaran() {
		return materiPengajaran;
	}

	public void setMateriPengajaran(Double materiPengajaran) {
		this.materiPengajaran = materiPengajaran;
	}

	public Double getTujuanPengajaran() {
		return tujuanPengajaran;
	}

	public void setTujuanPengajaran(Double tujuanPengajaran) {
		this.tujuanPengajaran = tujuanPengajaran;
	}

	public Double getWaktuPembelajaran() {
		return waktuPembelajaran;
	}

	public void setWaktuPembelajaran(Double waktuPembelajaran) {
		this.waktuPembelajaran = waktuPembelajaran;
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
