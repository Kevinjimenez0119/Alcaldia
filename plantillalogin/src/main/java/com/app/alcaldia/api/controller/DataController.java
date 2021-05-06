package com.app.alcaldia.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.alcaldia.api.model.Categoria;
import com.app.alcaldia.api.model.Rol;
import com.app.alcaldia.api.model.Sexo;
import com.app.alcaldia.api.model.TipoIdentificacion;
import com.app.alcaldia.api.service.CategoriaService;
import com.app.alcaldia.api.service.RolService;
import com.app.alcaldia.api.service.SexoService;
import com.app.alcaldia.api.service.TipoIdentificacionService;



@RestController
@RequestMapping("api/datos/")
public class DataController {

	@Autowired
	private RolService rolService;

	@Autowired
	private TipoIdentificacionService tipoIdService;

	@Autowired
	private SexoService sexoService;

	@Autowired
	private CategoriaService categoriaService;


	@GetMapping("roles")
	public ResponseEntity<List<Rol>> getRol() {

		List<Rol> roles = rolService.listarRoles();

		return new ResponseEntity<>(roles, HttpStatus.OK);
	}

	@GetMapping("tiposId")
	public ResponseEntity<List<TipoIdentificacion>> getTiposIdentificacion() {

		List<TipoIdentificacion> tiposId = tipoIdService.listarTiposIdentificacion();

		return new ResponseEntity<>(tiposId, HttpStatus.OK);
	}

	@GetMapping("sexos")
	public ResponseEntity<List<Sexo>> getSexo() {

		List<Sexo> sexos = sexoService.listarSexos();

		return new ResponseEntity<>(sexos, HttpStatus.OK);
	}


	@GetMapping("categorias")
	public ResponseEntity<List<Categoria>> getCategorias() {

		List<Categoria> categorias = categoriaService.listarCategorias();

		return new ResponseEntity<>(categorias, HttpStatus.OK);
	}



}
