package com.app.alcaldia.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the tipo_identificacion database table.
 * 
 */
@Entity
@Table(name = "tipo_identificacion")
public class TipoIdentificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String descripcion;

	@Column(nullable = false, unique = true)
	private String tipo;

	public TipoIdentificacion() {
		super();
	}

	public TipoIdentificacion(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "TipoIdentificacion [id=" + id + ", descripcion=" + descripcion + ", tipo=" + tipo + "]";
	}

}
