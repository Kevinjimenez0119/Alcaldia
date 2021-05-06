package com.app.alcaldia.api.data;

import java.io.Serializable;
import java.util.Date;




public class SubcategoriaApi implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	private String codigo;
	private String nombre;
	private String descripcion;
	private Date fechaActualizacion;
	private Integer categoria;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	public Integer getCategoria() {
		return categoria;
	}
	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	

}
