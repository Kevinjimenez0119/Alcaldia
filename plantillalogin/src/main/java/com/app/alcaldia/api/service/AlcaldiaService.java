package com.app.alcaldia.api.service;

import java.util.List;

import com.app.alcaldia.api.model.Alcaldia;

public interface AlcaldiaService {
	
	public Alcaldia guardar(Alcaldia entity);

	public Alcaldia buscarPorNit(String nit);

	public Alcaldia buscarPorIdentificador(Integer id);
	
	public List<Alcaldia> listarEmpresas();

}
