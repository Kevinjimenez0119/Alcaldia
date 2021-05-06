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

import com.app.alcaldia.api.data.AlcaldiaApi;
import com.app.alcaldia.api.data.UsuarioApi;
import com.app.alcaldia.api.model.Alcaldia;
import com.app.alcaldia.api.model.Rol;
import com.app.alcaldia.api.model.TipoIdentificacion;
import com.app.alcaldia.api.model.Usuario;
import com.app.alcaldia.api.service.AlcaldiaService;
import com.app.alcaldia.api.service.RolService;
import com.app.alcaldia.api.service.TipoIdentificacionService;
import com.app.alcaldia.api.service.UsuarioService;
import com.app.alcaldia.api.utils.ValidationException;

@RestController
@RequestMapping("api/alcaldia")
public class AlcaldiaController {

	@Autowired
	private AlcaldiaService service;

	

	@Secured({ "ROLE_ADMIN", "ROLE_PROV" })
	@PostMapping("")
	public ResponseEntity<Alcaldia> save(@RequestBody(required = false) AlcaldiaApi entrada) {

		Alcaldia alcaldia = service.buscarPorNit(entrada.getNit());

		if (alcaldia == null) {
			try {
				Alcaldia alcalidaSave;

				

				alcaldia = new Alcaldia();
				alcaldia.setNit(entrada.getNit());
				alcaldia.setNombre(entrada.getNombre());
				alcaldia.setDireccion(entrada.getDireccion());
				alcaldia.setEmail(entrada.getEmail());
				alcaldia.setAlcalde(entrada.getAlcalde());
				alcaldia.setMision(entrada.getMision());
				alcaldia.setVision(entrada.getVision());
				alcaldia.setFechaActualizacion(new Date());

				

		

				alcalidaSave = service.guardar(alcaldia);
				return new ResponseEntity<>(alcalidaSave, HttpStatus.OK);
			} catch (Exception e) {
				throw new ValidationException("Error de formulario", HttpStatus.BAD_REQUEST);
			}
		} else {
			throw new ValidationException(
					"La alcaldia con identificación '" + entrada.getNit() + "' ya existe",
					HttpStatus.BAD_REQUEST);
		}
	}

	@Secured({ "ROLE_ADMIN" })
	@PostMapping("update")
	public ResponseEntity<Alcaldia> update(@RequestBody(required = false) AlcaldiaApi entrada) {

		if (entrada != null && entrada.getNit() != null && !entrada.getNit().isEmpty()
				&& entrada.getNit().length() > 5) {

			Alcaldia alcaldia = service.buscarPorNit(entrada.getNit());

			if (alcaldia != null) {

				
				Alcaldia alcaldiaEdit = new Alcaldia();

				// VALORES NO CAMBIANTES
				
				alcaldiaEdit.setFechaRegistro(alcaldia.getFechaRegistro());

				// VALORES CAMBIANTES
				alcaldiaEdit.setEmail(entrada.getEmail());
				alcaldiaEdit.setActivo(entrada.getActivo());
				alcaldiaEdit.setNit(entrada.getNit());
				alcaldiaEdit.setNombre(entrada.getNombre());
				alcaldiaEdit.setDireccion(entrada.getDireccion());
				alcaldiaEdit.setFechaActualizacion(new Date());
				

				try {
					alcaldiaEdit = service.guardar(alcaldiaEdit);
				} catch (Exception e) {
					throw new ValidationException(e.getMessage(), HttpStatus.BAD_REQUEST);
				}
				return new ResponseEntity<>(alcaldiaEdit, HttpStatus.OK);
			} else {
				throw new ValidationException(
						"La alcaldia con identificación '" + entrada.getNit() + "' no existe",
						HttpStatus.BAD_REQUEST);
			}
		} else {
			throw new ValidationException("La identificación '" + entrada.getNit() + "' es invalida",
					HttpStatus.BAD_REQUEST);
		}

	}

	

	@Secured({ "ROLE_ADMIN" })
	@PostMapping("enableEdit/{nit}/{enableNew}")
	public ResponseEntity<Boolean> editEstado(@PathVariable String identificacion, @PathVariable Boolean enableNew) {
		Boolean hecho = false;

		Alcaldia alcaldia = service.buscarPorNit(identificacion);

		if (alcaldia != null) {

			if (enableNew != null && enableNew != alcaldia.getActivo()) {

				alcaldia.setActivo(enableNew);
				try {
					service.guardar(alcaldia);
					hecho = true;
				} catch (Exception e) {
					throw new ValidationException(e.getMessage(), HttpStatus.BAD_REQUEST);
				}

			} else {
				throw new ValidationException("El estado no ha cambiado", HttpStatus.BAD_REQUEST);
			}
		} else {
			throw new ValidationException("Alcaldia inexistente", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(hecho, HttpStatus.OK);
	}

}
