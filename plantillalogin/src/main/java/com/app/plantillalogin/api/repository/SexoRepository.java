package com.app.plantillalogin.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.plantillalogin.api.model.Sexo;

public interface SexoRepository extends CrudRepository<Sexo, Integer> {

	public Sexo findFirstByNombre(String nombre);

}
