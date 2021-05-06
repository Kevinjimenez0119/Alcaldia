package com.app.alcaldia.api.service;

import java.util.List;



import com.app.alcaldia.api.model.Subcategoria;


public interface SubcategoriaService {

	public List<Subcategoria> listarSubcategorias();

	public Subcategoria save(Subcategoria entity);
	public Subcategoria findByCodigo(String codigo);

	


}
