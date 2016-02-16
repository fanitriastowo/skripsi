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
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date tanggal;

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

	@ManyToOne
	@JoinColumn(name = "bobotspk_id")
	private BobotSPK bobotSpk;

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

	public BobotSPK getBobotSpk() {
		return bobotSpk;
	}

	public void setBobotSpk(BobotSPK bobotSpk) {
		this.bobotSpk = bobotSpk;
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
