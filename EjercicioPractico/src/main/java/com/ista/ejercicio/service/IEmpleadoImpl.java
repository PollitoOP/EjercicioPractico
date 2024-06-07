package com.ista.ejercicio.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ista.ejercicio.dao.EmpleadoRepository;
import com.ista.ejercicio.entity.Empleado;

@Service
public class IEmpleadoImpl {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> getAllEmpleados() {
        return StreamSupport.stream(empleadoRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<Empleado> getEmpleadoById(Long id) {
        return empleadoRepository.findById(id);
    }

    public Empleado createEmpleado(Empleado empleado, int diasTrabajados) {
        empleado.calcularSueldo(diasTrabajados);
        return empleadoRepository.save(empleado);
    }

    public Optional<Empleado> updateEmpleado(Long id, Empleado updatedEmpleado, int diasTrabajados) {
        return empleadoRepository.findById(id)
                .map(empleado -> {
                    empleado.setNombre(updatedEmpleado.getNombre());
                    empleado.setApellido(updatedEmpleado.getApellido());
                    empleado.setDireccion(updatedEmpleado.getDireccion());
                    empleado.setObservaciones(updatedEmpleado.getObservaciones());
                    empleado.setTelefono(updatedEmpleado.getTelefono());
                    empleado.setFechaNacimiento(updatedEmpleado.getFechaNacimiento());
                    empleado.calcularSueldo(diasTrabajados);
                    return empleadoRepository.save(empleado);
                });
    }

    public void deleteEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }
}
