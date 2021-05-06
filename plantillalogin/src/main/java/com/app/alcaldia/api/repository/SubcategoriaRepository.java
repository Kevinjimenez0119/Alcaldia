package com.app.alcaldia.api.repository;



import org.springframework.data.repository.CrudRepository;

import com.app.alcaldia.api.model.Subcategoria;


public interface SubcategoriaRepository extends CrudRepository<Subcategoria, Integer> {

	public Subcategoria findByCodigo(String codigo);

}
