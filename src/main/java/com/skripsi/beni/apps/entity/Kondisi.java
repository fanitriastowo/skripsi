package com.skripsi.beni.apps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "KONDISI")
public class Kondisi {

	@Id
	@GeneratedValue
	private Long id;

	private String kondisi;

	private Double point;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKondisi() {
		return kondisi;
	}

	public void setKondisi(String kondisi) {
		this.kondisi = kondisi;
	}

	public Double getPoint() {
		return point;
	}

	public void setPoint(Double point) {
		this.point = point;
	}

}
