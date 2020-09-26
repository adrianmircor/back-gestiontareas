package com.gestion_tareas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion_tareas.entity.Tarea;
import com.gestion_tareas.service.ITareaService;

@RestController
@RequestMapping("/tarea")
@CrossOrigin("*") //Acepte a todos los clientes puedan acceder al back, esto es problema del crors
public class TareaController {
	
	@Autowired
	private ITareaService iTareaService;

	@GetMapping
	public List<Tarea> mostrarTareas(){
		return iTareaService.listaTareas();
	}
	
	@GetMapping("/{email}")
	public List<Tarea> mostrarTareasPorEmail(@PathVariable String email){
		return iTareaService.listaTareasPorEmail(email);
	}
	
	@PostMapping("/add")
	public Tarea guardar(@RequestBody Tarea tarea) {
		iTareaService.guardar(tarea);
		System.out.println("email : "+tarea.getUsuario().getEmail());
		System.out.println("TAREA->"+tarea); //Muestra solo campos primitivos no campos relacionados como el email del Usuario
		return tarea;
	}
	
	@PutMapping("/update")
	public Tarea modificar(@RequestBody Tarea tarea) {
		
		
		iTareaService.guardar(tarea);
		return tarea;
	}
	
	@DeleteMapping("/eliminate/{id}")
	public String eliminar(@PathVariable("id") int idTarea) {
		iTareaService.eliminar(idTarea);
		return "Tarea eliminada";
	}
	
}
