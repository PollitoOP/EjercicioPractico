package com.ista.ejercicio.dao;

import org.springframework.data.repository.CrudRepository;

import com.ista.ejercicio.entity.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {

}

