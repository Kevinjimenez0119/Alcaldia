package com.app.plantillalogin.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.plantillalogin.api.model.TipoIdentificacion;

public interface TipoIdentificacionRepository extends CrudRepository<TipoIdentificacion, Integer> {

	public TipoIdentificacion findFirstByTipo(String tipo);

}
