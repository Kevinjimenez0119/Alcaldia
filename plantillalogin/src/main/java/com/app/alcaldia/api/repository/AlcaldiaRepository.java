package com.app.alcaldia.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.alcaldia.api.model.Alcaldia;

public interface AlcaldiaRepository extends CrudRepository<Alcaldia, Integer> {

	public Alcaldia findFirstByNit(String nit);

}
