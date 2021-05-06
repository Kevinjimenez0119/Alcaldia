package com.app.alcaldia.api.repository;



import org.springframework.data.repository.CrudRepository;

import com.app.alcaldia.api.model.Categoria;


public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {

	public Categoria findByCodigo(String codigo);

}
