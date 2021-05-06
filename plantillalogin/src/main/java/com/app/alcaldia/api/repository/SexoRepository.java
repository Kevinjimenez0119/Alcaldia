package com.app.alcaldia.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.alcaldia.api.model.Sexo;

public interface SexoRepository extends CrudRepository<Sexo, Integer> {

	public Sexo findFirstByNombre(String nombre);

}
