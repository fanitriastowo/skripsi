package com.skripsi.beni.apps.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PENGAJAR")
@JsonIgnoreProperties(value = { "metode" })
public class Pengajar {

	@Id
	@GeneratedValue
	private Long id;
	private String kualitas;
	private Double point;

	@OneToMany(mappedBy = "pengajar", cascade = CascadeType.MERGE)
	private List<Metode> metode;

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

	public List<Metode> getMetode() {
		return metode;
	}

	public void setMetode(List<Metode> metode) {
		this.metode = metode;
	}

}
