package com.app.plantillalogin.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.plantillalogin.api.model.Rol;

public interface RolRepository extends CrudRepository<Rol, Integer> {

	public Rol findFirstByRol(String rol);

}
