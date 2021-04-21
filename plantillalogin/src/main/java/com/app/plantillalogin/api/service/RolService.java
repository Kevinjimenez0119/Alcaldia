package com.app.plantillalogin.api.service;

import java.util.List;

import com.app.plantillalogin.api.model.Rol;

public interface RolService {

	public Rol buscarPorRol(String rol);

	public Rol buscarPorIdentificador(Integer id);
	
	public List<Rol> listarRoles();
	
}
