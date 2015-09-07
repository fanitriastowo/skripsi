package com.skripsi.beni.apps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name ="keaktifan")
public class Keaktifan {
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getJml_siswa() {
		return jml_siswa;
	}
	public void setJml_siswa(Integer jml_siswa) {
		this.jml_siswa = jml_siswa;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	@Id
	@GeneratedValue
	private Integer id;
	Integer jml_siswa;
	double point;

}
