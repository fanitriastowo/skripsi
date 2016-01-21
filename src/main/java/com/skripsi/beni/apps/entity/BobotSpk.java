package com.skripsi.beni.apps.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOBOT")
public class BobotSpk {

	@Id
	private String id;

	private Byte jumlahSiswaBobot;

	private Byte kondisiKelasBobot;

	private Byte keaktifanSiswaBobot;

	private Byte kualitasPengajarBobot;

	private Byte fasilitasBobot;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Byte getJumlahSiswaBobot() {
		return jumlahSiswaBobot;
	}

	public void setJumlahSiswaBobot(Byte jumlahSiswaBobot) {
		this.jumlahSiswaBobot = jumlahSiswaBobot;
	}

	public Byte getKondisiKelasBobot() {
		return kondisiKelasBobot;
	}

	public void setKondisiKelasBobot(Byte kondisiKelasBobot) {
		this.kondisiKelasBobot = kondisiKelasBobot;
	}

	public Byte getKeaktifanSiswaBobot() {
		return keaktifanSiswaBobot;
	}

	public void setKeaktifanSiswaBobot(Byte keaktifanSiswaBobot) {
		this.keaktifanSiswaBobot = keaktifanSiswaBobot;
	}

	public Byte getKualitasPengajarBobot() {
		return kualitasPengajarBobot;
	}

	public void setKualitasPengajarBobot(Byte kualitasPengajarBobot) {
		this.kualitasPengajarBobot = kualitasPengajarBobot;
	}

	public Byte getFasilitasBobot() {
		return fasilitasBobot;
	}

	public void setFasilitasBobot(Byte fasilitasBobot) {
		this.fasilitasBobot = fasilitasBobot;
	}

}
