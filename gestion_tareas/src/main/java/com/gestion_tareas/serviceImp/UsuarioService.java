package com.gestion_tareas.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion_tareas.entity.Usuario;
import com.gestion_tareas.repository.UsuarioRepository;
import com.gestion_tareas.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Override
	public Usuario usuarioValidadoLogin(String email, String contrasena) {

		return usuarioRepo.findByEmailAndContrasena(email, contrasena);
	}

	@Override
	public Usuario buscarPorEmail(String email) {

		return usuarioRepo.findByEmail(email);
	}

	@Override
	public void crearUsuario(Usuario usuario) {
		usuarioRepo.save(usuario);

	}

}
