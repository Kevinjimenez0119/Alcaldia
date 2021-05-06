package com.app.alcaldia.api.service;

import java.util.List;

import com.app.alcaldia.api.model.TipoIdentificacion;

public interface TipoIdentificacionService {

	public TipoIdentificacion buscarPorTipo(String tipoIdentificacion);

	public TipoIdentificacion buscarPorIdentificador(Integer id);

	public List<TipoIdentificacion> listarTiposIdentificacion();

}
