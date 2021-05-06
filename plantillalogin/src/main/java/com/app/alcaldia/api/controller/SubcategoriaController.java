package com.app.alcaldia.api.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.alcaldia.api.data.CategoriaApi;
import com.app.alcaldia.api.data.SubcategoriaApi;
import com.app.alcaldia.api.data.UsuarioApi;
import com.app.alcaldia.api.model.Alcaldia;
import com.app.alcaldia.api.model.Categoria;
import com.app.alcaldia.api.model.Rol;
import com.app.alcaldia.api.model.Subcategoria;
import com.app.alcaldia.api.model.TipoIdentificacion;
import com.app.alcaldia.api.model.Usuario;
import com.app.alcaldia.api.service.AlcaldiaService;
import com.app.alcaldia.api.service.CategoriaService;
import com.app.alcaldia.api.service.RolService;
import com.app.alcaldia.api.service.SubcategoriaService;
import com.app.alcaldia.api.service.TipoIdentificacionService;
import com.app.alcaldia.api.service.UsuarioService;
import com.app.alcaldia.api.utils.ValidationException;

@RestController
@RequestMapping("api/Subcategoria")
public class SubcategoriaController {

	@Autowired
	private SubcategoriaService service;

	@Autowired
	private CategoriaService categoriaservice;

	@Secured({ "ROLE_ADMIN", "ROLE_PROV" })
	@PostMapping("")
	public ResponseEntity<Subcategoria> save(@RequestBody(required = false) SubcategoriaApi entrada) {

		Subcategoria subcategoria = service.findByCodigo(entrada.getCodigo());

		if (subcategoria == null) {
			try {
				Subcategoria categoriasave;

				Categoria categoria = categoriaservice.findByCodigo(entrada.getCodigo());

				subcategoria = new Subcategoria();
				subcategoria.setCodigo(entrada.getCodigo());
				subcategoria.setDescripcion(entrada.getDescripcion());
				subcategoria.setNombre(entrada.getNombre());
				subcategoria.setFechaActualizacion(new Date());

				subcategoria.setCategoria(categoria);
				

				

				categoriasave = service.save(subcategoria);
				return new ResponseEntity<>(categoriasave, HttpStatus.OK);
			} catch (Exception e) {
				throw new ValidationException("Error de formulario", HttpStatus.BAD_REQUEST);
			}
		} else {
			throw new ValidationException(
					"La subcategoria con identificación '" + entrada.getCodigo() + "' ya existe",
					HttpStatus.BAD_REQUEST);
		}
	}

	@Secured({ "ROLE_ADMIN" })
	@PostMapping("update")
	public ResponseEntity<Subcategoria> update(@RequestBody(required = false) SubcategoriaApi entrada) {

		if (entrada != null && entrada.getCodigo() != null && !entrada.getCodigo().isEmpty()) {

			Subcategoria subcategoria = service.findByCodigo(entrada.getCodigo());

			if (subcategoria != null) {

				Categoria categoria = subcategoria.getCategoria();
				

				Subcategoria subcategoriaedit = new Subcategoria();

				
				subcategoriaedit.setId(subcategoria.getId());
				subcategoriaedit.setCodigo(entrada.getCodigo());
				subcategoriaedit.setDescripcion(entrada.getDescripcion());
				subcategoriaedit.setNombre(entrada.getNombre());
				subcategoriaedit.setFechaRegistro(subcategoria.getFechaRegistro());

				subcategoriaedit.setFechaActualizacion(new Date());
				subcategoriaedit.setCategoria(categoria);

				try {
					subcategoriaedit = service.save(subcategoriaedit);
				} catch (Exception e) {
					throw new ValidationException(e.getMessage(), HttpStatus.BAD_REQUEST);
				}
				return new ResponseEntity<>(subcategoriaedit, HttpStatus.OK);
			} else {
				throw new ValidationException(
						"La subcategoria con identificación '" + entrada.getCodigo() + "' no existe",
						HttpStatus.BAD_REQUEST);
			}
		} else {
			throw new ValidationException("La identificación '" + entrada.getCodigo() + "' es invalida",
					HttpStatus.BAD_REQUEST);
		}

	}

	

	

}
