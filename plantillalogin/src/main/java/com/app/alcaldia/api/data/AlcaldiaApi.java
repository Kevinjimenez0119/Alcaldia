package com.app.alcaldia.api.data;

import java.io.Serializable;
import java.util.Date;



public class AlcaldiaApi implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	private String nombre;
	private String nit;
	private String email;
	private String mision;
	private String vision;
	private String alcalde;
	private String direccion;
	private Boolean activo;
	private Date fechaRegistro;
	private Date fechaActualizacion;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMision() {
		return mision;
	}
	public void setMision(String mision) {
		this.mision = mision;
	}
	public String getVision() {
		return vision;
	}
	public void setVision(String vision) {
		this.vision = vision;
	}
	public String getAlcalde() {
		return alcalde;
	}
	public void setAlcalde(String alcalde) {
		this.alcalde = alcalde;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	

}
