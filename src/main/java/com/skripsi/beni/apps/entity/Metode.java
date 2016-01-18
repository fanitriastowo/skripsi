package com.skripsi.beni.apps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "METODE")
public class Metode {

	@Id
	@GeneratedValue
	private Long id;

	private String metode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMetode() {
		return metode;
	}

	public void setMetode(String metode) {
		this.metode = metode;
	}

}
