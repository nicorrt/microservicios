package com.anramirez.microservicioscocheservice.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coche {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String marca;
	private String modelo;
	private int usuarioId;

	public Coche() {
		super();
	}

	public Coche(int id, String marca, String modelo, int usuarioId) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.usuarioId = usuarioId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, marca, modelo, usuarioId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		return id == other.id && Objects.equals(marca, other.marca) && Objects.equals(modelo, other.modelo)
				&& usuarioId == other.usuarioId;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", usuarioId=" + usuarioId + "]";
	}

}
