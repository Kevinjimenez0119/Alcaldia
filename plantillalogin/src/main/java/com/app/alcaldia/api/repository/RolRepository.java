package com.app.alcaldia.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.alcaldia.api.model.Rol;

public interface RolRepository extends CrudRepository<Rol, Integer> {

	public Rol findFirstByRol(String rol);

}
