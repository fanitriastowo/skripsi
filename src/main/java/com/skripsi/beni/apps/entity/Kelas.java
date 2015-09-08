package com.skripsi.beni.apps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name ="kelas" )
public class Kelas {
	
	@Id
	@GeneratedValue 
	private Integer id;
	private Integer jml_siswa;
	private Double point;
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
	public Double getPoint() {
		return point;
	}
	public void setPoint(Double point) {
		this.point = point;
	}
 
	
}
