package com.ista.ejercicio.service;

import java.util.List;

import com.ista.ejercicio.entity.Empleado;

public interface EmpleadoService {
	public List<Empleado> findAll();

	public Empleado save(Empleado empleado);

	public Empleado findById(Long id);

	public void delete(Long id);

}
