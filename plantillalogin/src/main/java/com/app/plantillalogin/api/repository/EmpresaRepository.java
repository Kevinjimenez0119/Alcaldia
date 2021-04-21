package com.app.plantillalogin.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.plantillalogin.api.model.Empresa;

public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {

	public Empresa findFirstByNit(String nit);

}
