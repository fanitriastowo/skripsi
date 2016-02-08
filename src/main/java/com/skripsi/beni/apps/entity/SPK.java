package com.skripsi.beni.apps.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SPK")
public class SPK implements Serializable, Comparable<SPK> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	@Temporal(TemporalType.DATE)
	private Date tanggal;
	private String namaMetode;
	private Double jumlahSiswa;
	private Double kondisiSekolah;
	private Double kondisiKelas;
	private Double keaktifanSiswa;
	private Double kualitasPengajar;
	private Double fasilitas;
	private Double vectorS;
	private Double jumlahVectorS;
	private Double vectorV;

	@ManyToOne
	@JoinColumn(name = "temp_bobotid")
	private TempBobot tempBobot;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

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

	public Double getKondisiKelas() {
		return kondisiKelas;
	}

	public void setKondisiKelas(Double kondisiKelas) {
		this.kondisiKelas = kondisiKelas;
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

	public TempBobot getTempBobot() {
		return tempBobot;
	}

	public void setTempBobot(TempBobot tempBobot) {
		this.tempBobot = tempBobot;
	}

	@Override
	public int compareTo(SPK o) {
		Double bil1 = this.getVectorV();
		Double bil2 = o.getVectorV();
		
		if (bil1 > bil2) {
			return -1;
		} else {
			return 1;
		}
	}

}
