package com.skripsi.beni.apps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PENGAJAR")
public class Pengajar {

	@Id
	@GeneratedValue
	private Long id;
	private String kualitas;
	private Double point;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKualitas() {
		return kualitas;
	}

	public void setKualitas(String kualitas) {
		this.kualitas = kualitas;
	}

	public Double getPoint() {
		return point;
	}

	public void setPoint(Double point) {
		this.point = point;
	}

}
