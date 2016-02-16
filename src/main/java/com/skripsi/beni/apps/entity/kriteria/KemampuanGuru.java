package com.skripsi.beni.apps.entity.kriteria;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.skripsi.beni.apps.entity.Metode;

@Entity
@Table(name = "KEMAMPUAN_GURU")
@JsonIgnoreProperties(value = { "metode" })
public class KemampuanGuru {

	@Id
	@GeneratedValue
	private Long id;

	private String kemampuan;

	private Double point;

	@OneToMany(mappedBy = "kemampuanGuru", cascade = CascadeType.MERGE)
	private List<Metode> metode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKemampuan() {
		return kemampuan;
	}

	public void setKemampuan(String kemampuan) {
		this.kemampuan = kemampuan;
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
