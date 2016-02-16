package com.skripsi.beni.apps.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOBOT")
public class Bobot {

	@Id
	private String id;
	private Double jumlahSiswa;
	private Double fasilitas;
	private Double kemampuanSiswa;
	private Double kemampuanGuru;
	private Double materiPengajaran;
	private Double tujuanPengajaran;
	private Double waktuPembelajaran;

	private Double nJumlahSiswa;
	private Double nFasilitas;
	private Double nKemampuanSiswa;
	private Double nKemampuanGuru;
	private Double nMateriPengajaran;
	private Double nTujuanPengajaran;
	private Double nWaktuPembelajaran;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Double getnJumlahSiswa() {
		return nJumlahSiswa;
	}

	public void setnJumlahSiswa(Double nJumlahSiswa) {
		this.nJumlahSiswa = nJumlahSiswa;
	}

	public Double getnFasilitas() {
		return nFasilitas;
	}

	public void setnFasilitas(Double nFasilitas) {
		this.nFasilitas = nFasilitas;
	}

	public Double getnKemampuanSiswa() {
		return nKemampuanSiswa;
	}

	public void setnKemampuanSiswa(Double nKemampuanSiswa) {
		this.nKemampuanSiswa = nKemampuanSiswa;
	}

	public Double getnKemampuanGuru() {
		return nKemampuanGuru;
	}

	public void setnKemampuanGuru(Double nKemampuanGuru) {
		this.nKemampuanGuru = nKemampuanGuru;
	}

	public Double getnMateriPengajaran() {
		return nMateriPengajaran;
	}

	public void setnMateriPengajaran(Double nMateriPengajaran) {
		this.nMateriPengajaran = nMateriPengajaran;
	}

	public Double getnTujuanPengajaran() {
		return nTujuanPengajaran;
	}

	public void setnTujuanPengajaran(Double nTujuanPengajaran) {
		this.nTujuanPengajaran = nTujuanPengajaran;
	}

	public Double getnWaktuPembelajaran() {
		return nWaktuPembelajaran;
	}

	public void setnWaktuPembelajaran(Double nWaktuPembelajaran) {
		this.nWaktuPembelajaran = nWaktuPembelajaran;
	}

}
