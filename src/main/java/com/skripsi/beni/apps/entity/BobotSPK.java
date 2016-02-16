package com.skripsi.beni.apps.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BOBOT_SPK")
public class BobotSPK {

	@Id
	@GeneratedValue
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date tanggal;

	private Integer bobotJumlahSiswa;
	private Integer bobotFasilitas;
	private Integer bobotKemampuanSiswa;
	private Integer bobotKemampuanGuru;
	private Integer bobotMateriPengajaran;
	private Integer bobotTujuanPengajaran;
	private Integer bobotWaktuPembelajaran;

	@OneToMany(mappedBy = "bobotSpk", cascade = CascadeType.MERGE)
	private List<SPK> spkList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public Integer getBobotJumlahSiswa() {
		return bobotJumlahSiswa;
	}

	public void setBobotJumlahSiswa(Integer bobotJumlahSiswa) {
		this.bobotJumlahSiswa = bobotJumlahSiswa;
	}

	public Integer getBobotFasilitas() {
		return bobotFasilitas;
	}

	public void setBobotFasilitas(Integer bobotFasilitas) {
		this.bobotFasilitas = bobotFasilitas;
	}

	public Integer getBobotKemampuanSiswa() {
		return bobotKemampuanSiswa;
	}

	public void setBobotKemampuanSiswa(Integer bobotKemampuanSiswa) {
		this.bobotKemampuanSiswa = bobotKemampuanSiswa;
	}

	public Integer getBobotKemampuanGuru() {
		return bobotKemampuanGuru;
	}

	public void setBobotKemampuanGuru(Integer bobotKemampuanGuru) {
		this.bobotKemampuanGuru = bobotKemampuanGuru;
	}

	public Integer getBobotMateriPengajaran() {
		return bobotMateriPengajaran;
	}

	public void setBobotMateriPengajaran(Integer bobotMateriPengajaran) {
		this.bobotMateriPengajaran = bobotMateriPengajaran;
	}

	public Integer getBobotTujuanPengajaran() {
		return bobotTujuanPengajaran;
	}

	public void setBobotTujuanPengajaran(Integer bobotTujuanPengajaran) {
		this.bobotTujuanPengajaran = bobotTujuanPengajaran;
	}

	public Integer getBobotWaktuPembelajaran() {
		return bobotWaktuPembelajaran;
	}

	public void setBobotWaktuPembelajaran(Integer bobotWaktuPembelajaran) {
		this.bobotWaktuPembelajaran = bobotWaktuPembelajaran;
	}

	public List<SPK> getSpkList() {
		return spkList;
	}

	public void setSpkList(List<SPK> spkList) {
		this.spkList = spkList;
	}

}