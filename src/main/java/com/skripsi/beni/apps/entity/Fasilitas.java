package com.skripsi.beni.apps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fasilitas")
public class Fasilitas {
	@Id
	@GeneratedValue
	private Integer id;
	private Boolean fasilitas;
	private Double point;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getFasilitas() {
		return fasilitas;
	}
	public void setFasilitas(Boolean fasilitas) {
		this.fasilitas = fasilitas;
	}
	public Double getPoint() {
		return point;
	}
	public void setPoint(Double point) {
		this.point = point;
	}

}
