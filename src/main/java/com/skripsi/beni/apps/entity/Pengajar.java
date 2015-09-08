package com.skripsi.beni.apps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pengajar")
public class Pengajar {

	@Id
	@GeneratedValue

	private Integer id;
	private String kulaitas;
	private Double point;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKulaitas() {
		return kulaitas;
	}
	public void setKulaitas(String kulaitas) {
		this.kulaitas = kulaitas;
	}
	public Double getPoint() {
		return point;
	}
	public void setPoint(Double point) {
		this.point = point;
	}

}
