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
@Table(name = "KEAKTIFAN")
@JsonIgnoreProperties(value = { "metode" })
public class Keaktifan {

	@Id
	@GeneratedValue
	private Long id;
	private String jmlSiswa;
	private Double point;

	@OneToMany(mappedBy = "keaktifan", cascade = CascadeType.MERGE)
	private List<Metode> metode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public List<Metode> getMetode() {
		return metode;
	}

	public void setMetode(List<Metode> metode) {
		this.metode = metode;
	}

}
