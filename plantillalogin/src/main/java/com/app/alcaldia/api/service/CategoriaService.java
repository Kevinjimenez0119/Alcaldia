package com.app.alcaldia.api.service;

import java.util.List;


import com.app.alcaldia.api.model.Categoria;
import com.app.alcaldia.api.model.Usuario;

public interface CategoriaService {

	public List<Categoria> listarCategorias();

	public Categoria save(Categoria entity);
	public Categoria findByCodigo(String codigo);

	


}
