package com.gestion_tareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion_tareas.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	Usuario findByEmailAndContrasena(String email, String contrasena);
	Usuario findByEmail(String email);
}
