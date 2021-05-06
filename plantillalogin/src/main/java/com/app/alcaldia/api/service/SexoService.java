package com.app.alcaldia.api.service;

import java.util.List;

import com.app.alcaldia.api.model.Sexo;

public interface SexoService {

	public Sexo buscarPorNombre(String nombre);

	public Sexo buscarPorIdentificador(Integer id);

	public List<Sexo> listarSexos();
}
