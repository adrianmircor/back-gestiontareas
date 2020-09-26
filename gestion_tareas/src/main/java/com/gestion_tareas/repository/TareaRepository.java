package com.gestion_tareas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestion_tareas.entity.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Integer> {

	//CONSULTA DE ACUERDO A LA FK 
	//Consultar en la tabla tarea los registros q son del mismo usuario
    /*
     * FROM Tarea g where g.usuario.email = :email
     * Tarea		: Entidad Tarea
     * usuario.email: Dentro de la tabla 'tarea' se encuentra un campo que es del objeto usuario, de la Entidad Usuario
     * usuario.email: Se refiere al 'email' de la tabla 'tarea'
     * :email		: Es el parametro que llega por a url en TareaController
     * 
     * Se usa @Query pues 'email' no es atributo propio de Tarea sino de Usuario
     */
	@Query("FROM Tarea g where g.usuario.email = :email")
	List<Tarea> findByEmail(@Param("email") String email);
}
