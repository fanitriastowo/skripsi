package com.skripsi.beni.apps.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TEMP_BOBOT")
public class TempBobot {

	@Id
	@GeneratedValue
	private Integer id;

	private Integer bobotJumlahSiswa;
	private Integer bobotKondisiSekolah;
	private Integer bobotKondisiKelas;
	private Integer bobotKeaktifanSiswa;
	private Integer bobotKualitasPengajar;
	private Integer bobotFasilitas;

	@OneToMany(mappedBy = "tempBobot", cascade = CascadeType.MERGE)
	private List<SPK> spkList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBobotJumlahSiswa() {
		return bobotJumlahSiswa;
	}

	public void setBobotJumlahSiswa(Integer bobotJumlahSiswa) {
		this.bobotJumlahSiswa = bobotJumlahSiswa;
	}

	public Integer getBobotKondisiSekolah() {
		return bobotKondisiSekolah;
	}

	public void setBobotKondisiSekolah(Integer bobotKondisiSekolah) {
		this.bobotKondisiSekolah = bobotKondisiSekolah;
	}

	public Integer getBobotKondisiKelas() {
		return bobotKondisiKelas;
	}

	public void setBobotKondisiKelas(Integer bobotKondisiKelas) {
		this.bobotKondisiKelas = bobotKondisiKelas;
	}

	public Integer getBobotKeaktifanSiswa() {
		return bobotKeaktifanSiswa;
	}

	public void setBobotKeaktifanSiswa(Integer bobotKeaktifanSiswa) {
		this.bobotKeaktifanSiswa = bobotKeaktifanSiswa;
	}

	public Integer getBobotKualitasPengajar() {
		return bobotKualitasPengajar;
	}

	public void setBobotKualitasPengajar(Integer bobotKualitasPengajar) {
		this.bobotKualitasPengajar = bobotKualitasPengajar;
	}

	public Integer getBobotFasilitas() {
		return bobotFasilitas;
	}

	public void setBobotFasilitas(Integer bobotFasilitas) {
		this.bobotFasilitas = bobotFasilitas;
	}

	public List<SPK> getSpkList() {
		return spkList;
	}

	public void setSpkList(List<SPK> spkList) {
		this.spkList = spkList;
	}
}