package com.skripsi.beni.apps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kelas")
public class JumlahSiswa {

	@Id
	@GeneratedValue
	private Integer id;
	private String jmlSiswa;
	private Double point;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJmlSiswa() {
		return jmlSiswa;
	}

	public void setJmlSiswa(String jmlSiswa) {
		this.jmlSiswa = jmlSiswa;
	}

	public Double getPoint() {
		return point;
	}

	public void setPoint(Double point) {
		this.point = point;
	}

}
