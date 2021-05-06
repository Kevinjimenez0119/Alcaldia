package com.app.alcaldia.api.service.impl;

import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.alcaldia.api.model.Alcaldia;
import com.app.alcaldia.api.repository.AlcaldiaRepository;
import com.app.alcaldia.api.service.AlcaldiaService;

@Service
public class AlcaldiaServiceImpl implements AlcaldiaService {
	Logger logger = LoggerFactory.getLogger(AlcaldiaServiceImpl.class);

	@Autowired
	private AlcaldiaRepository repository;

	@Override
	public Alcaldia guardar(Alcaldia entity) {
		try {
			entity.setNit(entity.getNit().toUpperCase());
			entity.setNombre(entity.getNombre().toUpperCase());
			entity.setEmail(entity.getEmail().toUpperCase());
			entity.setDireccion(entity.getDireccion().toUpperCase());
			
			return repository.save(entity);
		} catch (Exception e) {
			logger.error("Registrar alcaldia", e);
		}
		return null;
	}

	@Override
	public Alcaldia buscarPorNit(String nit) {
		try {
			return repository.findFirstByNit(nit);
		} catch (Exception e) {
			logger.error("Busqueda alcadia por nit", e);
		}
		return null;
	}

	@Override
	public Alcaldia buscarPorIdentificador(Integer id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {
			logger.error("Busqueda alcaldia por id", e);
		}
		return null;
	}

	@Override
	public List<Alcaldia> listarEmpresas() {
		try {
			return (List<Alcaldia>) repository.findAll();
		} catch (Exception e) {
			logger.error("Listar alcaldia", e);
		}
		return new ArrayList<>();
	}

}
