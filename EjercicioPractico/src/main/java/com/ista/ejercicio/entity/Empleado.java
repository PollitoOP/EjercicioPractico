package com.ista.ejercicio.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpleado;

	@NotNull
	@Size(max = 45)
	private String apellido;

	@NotNull
	@Size(max = 45)
	private String nombre;

	@NotNull
	@Size(max = 45)
	private String direccion;

	@Size(max = 45)
	private String observaciones;

	@NotNull
	@Size(max = 15)
	private String telefono;

	@NotNull
	private LocalDate fechaNacimiento;

	@NotNull
	@Digits(integer = 10, fraction = 2)
	@PositiveOrZero
	private BigDecimal sueldo;

	// Getters y Setters

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public BigDecimal getSueldo() {
		return sueldo;
	}

	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}

	// Método para calcular el sueldo basado en días trabajados
	public void calcularSueldo(int diasTrabajados) {
		BigDecimal pagoPorDia = new BigDecimal("15");
		BigDecimal sueldoCalculado = pagoPorDia.multiply(new BigDecimal(diasTrabajados));
		if (diasTrabajados >= 30) {
			sueldoCalculado = sueldoCalculado.multiply(new BigDecimal("1.05"));
		} else if (diasTrabajados >= 20) {
			sueldoCalculado = sueldoCalculado.multiply(new BigDecimal("1.02"));
		}
		this.sueldo = sueldoCalculado;
	}
}
