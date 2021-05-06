package com.app.alcaldia.api.service.impl;

import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.alcaldia.api.model.Categoria;
import com.app.alcaldia.api.model.Usuario;
import com.app.alcaldia.api.repository.CategoriaRepository;
import com.app.alcaldia.api.service.CategoriaService;


@Service
public class CategoriaServiceImpl implements CategoriaService {
	Logger logger = LoggerFactory.getLogger(CategoriaServiceImpl.class);

	@Autowired
	private CategoriaRepository repository;

	@Override
	public Categoria save(Categoria entity) {
		try {
			
			
			return repository.save(entity);
		} catch (Exception e) {
			logger.error("Registrar categorias", e);
		}
		return null;
	}

	


	@Override
	public List<Categoria> listarCategorias() {
		try {
			return (List<Categoria>) repository.findAll();
		} catch (Exception e) {
			logger.error("Listar categorias", e);
		}
		return new ArrayList<>();
	}




	@Override
	public Categoria findByCodigo(String codigo) {
		try {
			return repository.findByCodigo(codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}




	

	

}
