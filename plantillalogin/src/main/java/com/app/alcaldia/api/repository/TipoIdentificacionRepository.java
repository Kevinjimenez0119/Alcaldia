package com.app.alcaldia.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.alcaldia.api.model.TipoIdentificacion;

public interface TipoIdentificacionRepository extends CrudRepository<TipoIdentificacion, Integer> {

	public TipoIdentificacion findFirstByTipo(String tipo);

}
