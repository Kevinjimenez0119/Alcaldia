package com.app.alcaldia.api.service.impl;

import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.alcaldia.api.model.Categoria;
import com.app.alcaldia.api.model.Subcategoria;
import com.app.alcaldia.api.model.Usuario;
import com.app.alcaldia.api.repository.CategoriaRepository;
import com.app.alcaldia.api.repository.SubcategoriaRepository;
import com.app.alcaldia.api.service.CategoriaService;
import com.app.alcaldia.api.service.SubcategoriaService;


@Service
public class SubcategoriaServiceImpl implements SubcategoriaService {
	Logger logger = LoggerFactory.getLogger(SubcategoriaServiceImpl.class);

	@Autowired
	private SubcategoriaRepository repository;

	@Override
	public Subcategoria save(Subcategoria entity) {
		try {
			
			
			return repository.save(entity);
		} catch (Exception e) {
			logger.error("Registrar subcategorias", e);
		}
		return null;
	}

	


	@Override
	public List<Subcategoria> listarSubcategorias() {
		try {
			return (List<Subcategoria>) repository.findAll();
		} catch (Exception e) {
			logger.error("Listar subcategorias", e);
		}
		return new ArrayList<>();
	}




	@Override
	public Subcategoria findByCodigo(String codigo) {
		try {
			return repository.findByCodigo(codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}




	

	

}
