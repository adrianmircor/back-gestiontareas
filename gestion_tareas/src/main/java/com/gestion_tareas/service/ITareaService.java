package com.gestion_tareas.service;

import java.util.List;

import com.gestion_tareas.entity.Tarea;

public interface ITareaService {

	List<Tarea> listaTareas();
	void guardar(Tarea tarea);
	void eliminar(int idTarea);
	List<Tarea> listaTareasPorEmail(String email);
}
