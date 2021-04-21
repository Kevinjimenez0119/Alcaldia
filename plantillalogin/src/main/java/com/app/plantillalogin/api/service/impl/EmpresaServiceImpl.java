package com.app.plantillalogin.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.plantillalogin.api.model.Empresa;
import com.app.plantillalogin.api.repository.EmpresaRepository;
import com.app.plantillalogin.api.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {
	Logger logger = LoggerFactory.getLogger(EmpresaServiceImpl.class);

	@Autowired
	private EmpresaRepository repository;

	@Override
	public Empresa guardar(Empresa entity) {
		try {
			return repository.save(entity);
		} catch (Exception e) {
			logger.error("Registrar empresa", e);
		}
		return null;
	}

	@Override
	public Empresa buscarPorNit(String nit) {
		try {
			return repository.findFirstByNit(nit);
		} catch (Exception e) {
			logger.error("Busqueda empresa por nit", e);
		}
		return null;
	}

	@Override
	public Empresa buscarPorIdentificador(Integer id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {
			logger.error("Busqueda empresa por id", e);
		}
		return null;
	}

	@Override
	public List<Empresa> listarEmpresas() {
		try {
			return (List<Empresa>) repository.findAll();
		} catch (Exception e) {
			logger.error("Listar empresas", e);
		}
		return new ArrayList<>();
	}

}
