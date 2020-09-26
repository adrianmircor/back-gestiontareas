package com.gestion_tareas.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion_tareas.entity.Tarea;
import com.gestion_tareas.repository.TareaRepository;
import com.gestion_tareas.service.ITareaService;

@Service
public class TareaService implements ITareaService {
	
	@Autowired
	private TareaRepository tareaRepo;

	@Override
	public List<Tarea> listaTareas() {
		return tareaRepo.findAll();
	}

	@Override
	public void guardar(Tarea tarea) {
		tareaRepo.save(tarea);
	}

	@Override
	public void eliminar(int idTarea) {
		tareaRepo.deleteById(idTarea);
	}

	@Override
	public List<Tarea> listaTareasPorEmail(String email) {
		
		return tareaRepo.findByEmail(email);
	}

}
