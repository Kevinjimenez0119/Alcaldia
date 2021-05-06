package com.app.alcaldia.api.service;

import java.util.List;

import com.app.alcaldia.api.model.Rol;

public interface RolService {

	public Rol buscarPorRol(String rol);

	public Rol buscarPorIdentificador(Integer id);
	
	public List<Rol> listarRoles();
	
}
