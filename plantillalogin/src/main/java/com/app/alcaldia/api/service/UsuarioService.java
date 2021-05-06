package com.app.alcaldia.api.service;

import java.util.List;

import com.app.alcaldia.api.model.Alcaldia;
import com.app.alcaldia.api.model.Usuario;

public interface UsuarioService {

	public List<Usuario> findAll();

	public Usuario save(Usuario entity);

	public Usuario findByUsernameAndIdentificacion(String username, String identificacion);

	public Usuario findByUsername(String username);

	public Usuario findByIdentificacion(String identificacion);

	public boolean existByUsernameAndIdentificacion(String username, String identificacion);


}
