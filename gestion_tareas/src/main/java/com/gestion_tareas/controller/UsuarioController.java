package com.gestion_tareas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion_tareas.entity.Usuario;
import com.gestion_tareas.service.IUsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*") // Acepte a todos los clientes puedan acceder al back, esto es problema del cors
public class UsuarioController {

	@Autowired
	private IUsuarioService iUsuarioService;

	@GetMapping("/encontrar/{email}/{contrasena}")
	public Usuario encontrarUsuario(@PathVariable String email, @PathVariable String contrasena) {

		Usuario usuario = new Usuario();
		usuario = iUsuarioService.usuarioValidadoLogin(email, contrasena);

		if (usuario != null) {
			System.out.println("--> " + usuario);

			return usuario; // LO QUE RETORNA ES EL JSON QUE SE PINTA EN EL BROWSER
			// Si retorna cadena de String, en el browser se lee como mensaje

		} else {

			System.out.println("--> NO SE ENCONTRÓ NADA");
			return null;
		}

	}

	@GetMapping("/validar/{email}")
	public Usuario validarExistenciaPorEmail(@PathVariable String email) {

		Usuario us = new Usuario();
		us = iUsuarioService.buscarPorEmail(email);
		if (us != null) {
			return us;
		} else {
			return null;
		}

	}
	
	@PostMapping("/add")
	public String crearUsuario(@RequestBody Usuario usuario) {
		iUsuarioService.crearUsuario(usuario);
		return "Usuario creado";
	}

}
