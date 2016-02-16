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
@Table(name = "WAKTU_PEMBELAJARAN")
@JsonIgnoreProperties(value = { "metode" })
public class WaktuPembelajaran {

	@Id
	@GeneratedValue
	private Long id;

	private String waktu;

	private Double point;

	@OneToMany(mappedBy = "waktuPembelajaran", cascade = CascadeType.MERGE)
	private List<Metode> metode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWaktu() {
		return waktu;
	}

	public void setWaktu(String waktu) {
		this.waktu = waktu;
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
