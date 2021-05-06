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
import com.app.alcaldia.api.data.UsuarioApi;
import com.app.alcaldia.api.model.Alcaldia;
import com.app.alcaldia.api.model.Categoria;
import com.app.alcaldia.api.model.Rol;
import com.app.alcaldia.api.model.TipoIdentificacion;
import com.app.alcaldia.api.model.Usuario;
import com.app.alcaldia.api.service.AlcaldiaService;
import com.app.alcaldia.api.service.CategoriaService;
import com.app.alcaldia.api.service.RolService;
import com.app.alcaldia.api.service.TipoIdentificacionService;
import com.app.alcaldia.api.service.UsuarioService;
import com.app.alcaldia.api.utils.ValidationException;

@RestController
@RequestMapping("api/Categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@Autowired
	private UsuarioService usuarioService;

	@Secured({ "ROLE_ADMIN", "ROLE_PROV" })
	@PostMapping("")
	public ResponseEntity<Categoria> save(@RequestBody(required = false) CategoriaApi entrada) {

		Categoria categoria = service.findByCodigo(entrada.getCodigo());

		if (categoria == null) {
			try {
				Categoria categoriasave;

				Usuario usuario = usuarioService.findByIdentificacion(entrada.getCodigo());

				categoria = new Categoria();
				categoria.setCodigo(entrada.getCodigo());
				categoria.setDescripcion(entrada.getDescripcion());
				categoria.setNombre(entrada.getNombre());
				categoria.setFechaActualizacion(new Date());

				categoria.setUsuario(usuario);
				

				

				categoriasave = service.save(categoria);
				return new ResponseEntity<>(categoriasave, HttpStatus.OK);
			} catch (Exception e) {
				throw new ValidationException("Error de formulario", HttpStatus.BAD_REQUEST);
			}
		} else {
			throw new ValidationException(
					"La categoria con identificación '" + entrada.getCodigo() + "' ya existe",
					HttpStatus.BAD_REQUEST);
		}
	}

	@Secured({ "ROLE_ADMIN" })
	@PostMapping("update")
	public ResponseEntity<Categoria> update(@RequestBody(required = false) CategoriaApi entrada) {

		if (entrada != null && entrada.getCodigo() != null && !entrada.getCodigo().isEmpty()) {

			Categoria categoria = service.findByCodigo(entrada.getCodigo());

			if (categoria != null) {

				Usuario usuario = categoria.getUsuario();
				

				Categoria categoriaedit = new Categoria();

				
				categoriaedit.setId(categoria.getId());
				categoriaedit.setCodigo(entrada.getCodigo());
				categoriaedit.setDescripcion(entrada.getDescripcion());
				categoriaedit.setNombre(entrada.getNombre());
				categoriaedit.setFechaRegistro(categoria.getFechaRegistro());

				categoriaedit.setFechaActualizacion(new Date());
				categoriaedit.setUsuario(usuario);

				try {
					categoriaedit = service.save(categoriaedit);
				} catch (Exception e) {
					throw new ValidationException(e.getMessage(), HttpStatus.BAD_REQUEST);
				}
				return new ResponseEntity<>(categoriaedit, HttpStatus.OK);
			} else {
				throw new ValidationException(
						"La categoria con identificación '" + entrada.getCodigo() + "' no existe",
						HttpStatus.BAD_REQUEST);
			}
		} else {
			throw new ValidationException("La identificación '" + entrada.getCodigo() + "' es invalida",
					HttpStatus.BAD_REQUEST);
		}

	}

	

	

}
