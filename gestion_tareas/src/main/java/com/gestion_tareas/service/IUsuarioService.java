package com.gestion_tareas.service;

import com.gestion_tareas.entity.Usuario;

public interface IUsuarioService {
	
	Usuario usuarioValidadoLogin(String email, String contrasena);
	Usuario buscarPorEmail(String email);
	void crearUsuario(Usuario usuario);
}
