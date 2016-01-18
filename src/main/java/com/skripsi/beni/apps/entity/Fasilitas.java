package com.skripsi.beni.apps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FASILITAS")
public class Fasilitas {

	@Id
	@GeneratedValue
	private Long id;
	private String fasilitas;
	private Double point;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFasilitas() {
		return fasilitas;
	}

	public void setFasilitas(String fasilitas) {
		this.fasilitas = fasilitas;
	}

	public Double getPoint() {
		return point;
	}

	public void setPoint(Double point) {
		this.point = point;
	}

}
