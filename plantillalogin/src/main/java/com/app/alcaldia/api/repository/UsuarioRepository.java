package com.app.alcaldia.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.alcaldia.api.model.Alcaldia;
import com.app.alcaldia.api.model.Usuario;


public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	public Usuario findByUsernameIgnoreCaseAndIdentificacion(String username, String identificacion);

	public Usuario findByUsernameIgnoreCase(String username);

	public Usuario findByIdentificacion(String identificacion);

	public boolean existsByUsernameIgnoreCaseAndIdentificacion(String username, String identificacion);
	
}
